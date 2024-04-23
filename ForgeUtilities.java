package @package@;

import dev.architectury.platform.forge.EventBuses;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import mtr.mappings.DeferredRegisterHolder;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ForgeUtilities {

	private static Runnable renderTickAction = () -> {
	};
	private static Consumer<Object> renderGameOverlayAction = matrices -> {
	};
	private static Consumer<Object> textureStitchEvent = atlas -> {
	};
	private static final List<ResourceLocation> CREATIVE_TAB_ORDER = new ArrayList<>();
	private static final Map<ResourceLocation, CreativeModeTabWrapper> CREATIVE_TABS = new HashMap<>();
	private static final Set<EntityRendererPair<?>> ENTITY_RENDERER_PAIRS = new HashSet<>();

	public static void registerModEventBus(String modId, IEventBus eventBus) {
		EventBuses.registerModEventBus(modId, eventBus);
	}

	public static void registerKeyBinding(KeyMapping keyMapping) {
		KeyMappingRegistry.register(keyMapping);
	}

	public static Packet<?> createAddEntityPacket(Entity entity) {
		return NetworkHooks.getEntitySpawningPacket(entity);
	}

	public static Supplier<CreativeModeTab> createCreativeModeTab(ResourceLocation resourceLocation, Supplier<ItemStack> iconSupplier, String translationKey) {
		if (!CREATIVE_TAB_ORDER.contains(resourceLocation)) {
			CREATIVE_TAB_ORDER.add(resourceLocation);
			CREATIVE_TABS.put(resourceLocation, new CreativeModeTabWrapper(iconSupplier, translationKey));
		}
		return CREATIVE_TABS.get(resourceLocation).creativeModeTabSupplier;
	}

	public static void registerCreativeModeTab(ResourceLocation resourceLocation, Item item) {
		if (CREATIVE_TABS.containsKey(resourceLocation)) {
			CREATIVE_TABS.get(resourceLocation).items.add(item);
		}
	}

	public static ResourceKey<Registry<Item>> registryGetItem() {
		return Registries.ITEM;
	}

	public static ResourceKey<Registry<Block>> registryGetBlock() {
		return Registries.BLOCK;
	}

	public static ResourceKey<Registry<BlockEntityType<?>>> registryGetBlockEntityType() {
		return Registries.BLOCK_ENTITY_TYPE;
	}

	public static ResourceKey<Registry<EntityType<?>>> registryGetEntityType() {
		return Registries.ENTITY_TYPE;
	}

	public static ResourceKey<Registry<SoundEvent>> registryGetSoundEvent() {
		return Registries.SOUND_EVENT;
	}

	public static ResourceKey<Registry<ParticleType<?>>> registryGetParticleType() {
		return Registries.PARTICLE_TYPE;
	}

	public static void renderTickAction(Runnable runnable) {
		renderTickAction = runnable;
	}

	public static void renderGameOverlayAction(Consumer<Object> consumer) {
		renderGameOverlayAction = consumer;
	}

	public static void registerTextureStitchEvent(Consumer<Object> consumer) {
		textureStitchEvent = consumer;
	}

	public static <T extends Entity> void registerEntityRenderer(Supplier<EntityType<? extends T>> entityType, EntityRendererProvider<T> entityRendererProvider) {
		ENTITY_RENDERER_PAIRS.add(new EntityRendererPair<>(entityType, entityRendererProvider));
	}

	public static class Events {

		@SubscribeEvent
		public static void onRenderTickEvent(RenderLevelStageEvent event) {
			if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_CUTOUT_BLOCKS) {
				renderTickAction.run();
			}
		}

		@SubscribeEvent
		public static void onRenderGameOverlayEvent(RenderGuiOverlayEvent.Post event) {
			renderGameOverlayAction.accept(event.getGuiGraphics());
		}
	}

	public static class ClientsideEvents {

		@SubscribeEvent
		public static void onEntityRendererEvent(EntityRenderersEvent.RegisterRenderers event) {
			ENTITY_RENDERER_PAIRS.forEach(entityRendererPair -> entityRendererPair.register(event));
		}

		@SubscribeEvent
		public static void onTextureStitchEvent(TextureStitchEvent event) {
			textureStitchEvent.accept(event.getAtlas());
		}
	}

	public static class RegisterCreativeTabs {

		@SubscribeEvent
		public static void onRegisterCreativeModeTabsEvent(BuildCreativeModeTabContentsEvent event) {
			CREATIVE_TABS.forEach((resourceLocation, creativeModeTabWrapper) -> {
				if (creativeModeTabWrapper.creativeModeTab.getDisplayName().equals(event.getTab().getDisplayName())) {
					creativeModeTabWrapper.items.forEach(item -> event.getEntries().put(new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
				}
			});
		}
	}

	public static void registerCreativeModeTabsToDeferredRegistry(DeferredRegisterHolder<CreativeModeTab> registry) {
		CREATIVE_TAB_ORDER.forEach(resourceLocation -> {
			final CreativeModeTabWrapper creativeModeTabWrapper = CREATIVE_TABS.get(resourceLocation);
			CreativeModeTab tab = CreativeModeTab.builder().icon(creativeModeTabWrapper.iconSupplier).title(Component.translatable(creativeModeTabWrapper.translationKey)).build();
			creativeModeTabWrapper.creativeModeTab = tab;
			registry.register(resourceLocation.getPath(), () -> tab);
		});
	}

	private static class EntityRendererPair<T extends Entity> {

		private final Supplier<EntityType<? extends T>> entityTypeSupplier;
		private final EntityRendererProvider<T> entityRendererProvider;

		private EntityRendererPair(Supplier<EntityType<? extends T>> entityTypeSupplier, EntityRendererProvider<T> entityRendererProvider) {
			this.entityTypeSupplier = entityTypeSupplier;
			this.entityRendererProvider = entityRendererProvider;
		}

		private void register(EntityRenderersEvent.RegisterRenderers event) {
			event.registerEntityRenderer(entityTypeSupplier.get(), entityRendererProvider);
		}
	}

	private static class CreativeModeTabWrapper {

		private CreativeModeTab creativeModeTab;
		private final Supplier<ItemStack> iconSupplier;
		private final Supplier<CreativeModeTab> creativeModeTabSupplier;
		private final String translationKey;
		private final List<Item> items = new ArrayList<>();

		private CreativeModeTabWrapper(Supplier<ItemStack> iconSupplier, String translationKey) {
			this.iconSupplier = iconSupplier;
			creativeModeTabSupplier = () -> creativeModeTab;
			this.translationKey = translationKey;
		}
	}
}
