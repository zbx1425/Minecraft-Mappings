package org.mtr.mapping.test;

import net.minecraft.advancements.FunctionManager;
import net.minecraft.block.*;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.GameSettings;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.*;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AbstractSlider;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.ToggleWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.multiplayer.ClientChunkProvider;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.particle.TexturedParticle;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.resources.IResource;
import net.minecraft.resources.IResourceManager;
import net.minecraft.scoreboard.*;
import net.minecraft.server.CustomServerBossInfoManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.state.*;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerChunkProvider;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.CommandStorage;
import net.minecraft.world.storage.FolderName;
import net.minecraft.world.storage.IServerConfiguration;
import net.minecraft.world.storage.WorldSavedData;
import org.junit.jupiter.api.Test;

import java.util.Random;

public final class ClassScannerTest {

	@Test
	public void scan() {
		final ClassScannerBase scanner = ClassScannerBase.getInstance();
		scanner.put("AbstractTexture", Texture.class);
		scanner.put("ActionResult", ActionResultType.class);
		scanner.put("Axis", Direction.Axis.class);
		scanner.put("Biome", Biome.class);
		scanner.put("BiomeSource", BiomeProvider.class);
		scanner.put("BlockEntityType", TileEntityType.class);
		scanner.put("BlockHitResult", BlockRayTraceResult.class);
		scanner.put("BlockPos", BlockPos.class);
		scanner.put("BlockRenderType", BlockRenderType.class);
		scanner.put("BlockRenderView", IBlockDisplayReader.class);
		scanner.put("BlockRotation", Rotation.class);
		scanner.put("Blocks", Blocks.class);
		scanner.put("BlockSettings", AbstractBlock.Properties.class);
		scanner.put("BlockState", BlockState.class);
		scanner.put("BlockView", IBlockReader.class);
		scanner.put("BooleanBiFunction", IBooleanFunction.class);
		scanner.put("BooleanProperty", BooleanProperty.class);
		scanner.put("BossBarManager", CustomServerBossInfoManager.class);
		scanner.put("Box", AxisAlignedBB.class);
		scanner.put("BufferBuilder", BufferBuilder.class);
		scanner.put("BufferBuilderStorage", RenderTypeBuffers.class);
		scanner.put("Camera", ActiveRenderInfo.class);
		scanner.put("ClientChunkManager", ClientChunkProvider.class);
		scanner.put("Chunk", IChunk.class);
		scanner.put("ChunkGenerator", ChunkGenerator.class);
		scanner.put("ChunkManager", AbstractChunkProvider.class);
		scanner.put("ChunkPos", ChunkPos.class);
		scanner.put("ChunkSection", ChunkSection.class);
		scanner.put("ChunkStatus", ChunkStatus.class);
		scanner.put("ClientPlayerEntity", ClientPlayerEntity.class, "getType");
		scanner.put("ClientPlayNetworkHandler", ClientPlayNetHandler.class);
		scanner.put("ClientWorld", ClientWorld.class);
		scanner.put("CommandFunctionManager", FunctionManager.class);
		scanner.put("CompoundTag", CompoundNBT.class);
		scanner.put("DataCommandStorage", CommandStorage.class);
		scanner.put("DefaultParticleType", BasicParticleType.class);
		scanner.put("Difficulty", Difficulty.class);
		scanner.put("DimensionOptions", Dimension.class);
		scanner.put("DimensionType", DimensionType.class);
		scanner.put("Direction", Direction.class);
		scanner.put("DirectionProperty", DirectionProperty.class);
		scanner.put("EntityPose", Pose.class);
		scanner.put("EntityRenderDispatcher", EntityRendererManager.class);
		scanner.put("EntityType", EntityType.class);
		scanner.put("EnumProperty", EnumProperty.class);
		scanner.put("Explosion", Explosion.class);
		scanner.put("FluidState", FluidState.class);
		scanner.put("GameMode", GameType.class);
		scanner.put("GameOptions", GameSettings.class);
		scanner.put("GameRenderer", GameRenderer.class);
		scanner.put("Hand", Hand.class);
		scanner.put("HeightMap", Heightmap.class);
		scanner.put("HeightMapType", Heightmap.Type.class);
		scanner.put("HitResult", RayTraceResult.class);
		scanner.put("HitResultType", RayTraceResult.Type.class);
		scanner.put("Identifier", ResourceLocation.class);
		scanner.put("IntegerProperty", IntegerProperty.class);
		scanner.put("InternalFormat", NativeImage.PixelFormatGLCode.class);
		scanner.put("Inventory", IInventory.class);
		scanner.put("ItemConvertible", IItemProvider.class);
		scanner.put("ItemPlacementContext", BlockItemUseContext.class);
		scanner.put("Items", Items.class);
		scanner.put("ItemSettings", Item.Properties.class);
		scanner.put("ItemStack", ItemStack.class);
		scanner.put("ItemUsageContext", ItemUseContext.class);
		scanner.put("KeyBinding", KeyBinding.class);
		scanner.put("LightmapTextureManager", LightTexture.class);
		scanner.put("LightType", LightType.class);
		scanner.put("LivingEntity", LivingEntity.class, "getType");
		scanner.put("MapColor", MaterialColor.class);
		scanner.put("MathHelper", MathHelper.class, "MathHelper");
		scanner.put("Matrix3f", Matrix3f.class);
		scanner.put("Matrix4f", Matrix4f.class);
		scanner.put("MinecraftClient", Minecraft.class, "ask", "askEither");
		scanner.put("MinecraftServer", MinecraftServer.class, "ask", "askEither");
		scanner.put("Mirror", Mirror.class);
		scanner.put("ModelPart", ModelRenderer.class);
		scanner.put("MutableText", IFormattableTextComponent.class);
		scanner.put("NativeImage", NativeImage.class);
		scanner.put("NativeImageBackedTexture", DynamicTexture.class);
		scanner.put("NativeImageFormat", NativeImage.PixelFormat.class);
		scanner.put("OperatingSystem", Util.OS.class);
		scanner.put("OrderedText", IReorderingProcessor.class);
		scanner.put("OverlayTexture", OverlayTexture.class);
		scanner.put("PacketBuffer", PacketBuffer.class);
		scanner.put("ParticleEffect", IParticleData.class);
		scanner.put("ParticleTypes", ParticleTypes.class);
		scanner.put("PlayerEntity", PlayerEntity.class, "getType");
		scanner.put("PlayerInventory", PlayerInventory.class);
		scanner.put("PlayerListEntry", NetworkPlayerInfo.class);
		scanner.put("PlayerManager", PlayerList.class);
		scanner.put("Position", IPosition.class);
		scanner.put("Property", Property.class);
		scanner.put("Random", Random.class);
		scanner.put("RenderLayer", RenderType.class);
		scanner.put("Resource", IResource.class);
		scanner.put("ResourceManager", IResourceManager.class);
		scanner.put("SaveProperties", IServerConfiguration.class);
		scanner.put("Scoreboard", Scoreboard.class);
		scanner.put("ScoreboardCriterion", ScoreCriteria.class);
		scanner.put("ScoreboardCriterionRenderType", ScoreCriteria.RenderType.class);
		scanner.put("ScoreboardObjective", ScoreObjective.class);
		scanner.put("ScoreboardScore", Score.class);
		scanner.put("ServerChunkManager", ServerChunkProvider.class);
		scanner.put("ServerPlayerEntity", ServerPlayerEntity.class, "getType");
		scanner.put("ServerWorld", ServerWorld.class);
		scanner.put("ServerWorldAccess", IServerWorld.class);
		scanner.put("ShapeContext", ISelectionContext.class);
		scanner.put("SlabType", SlabType.class);
		scanner.put("SoundCategory", SoundCategory.class);
		scanner.put("SoundEvent", SoundEvent.class);
		scanner.put("SoundEvents", SoundEvents.class);
		scanner.put("SoundInstance", ISound.class);
		scanner.put("SoundManager", SoundHandler.class);
		scanner.put("SpriteProvider", IAnimatedSprite.class);
		scanner.put("StairShape", StairsShape.class);
		scanner.put("Style", Style.class);
		scanner.put("Team", ScorePlayerTeam.class);
		scanner.put("Tessellator", Tessellator.class);
		scanner.put("Text", ITextComponent.class);
		scanner.put("TextColor", Color.class);
		scanner.put("TextFormatting", TextFormatting.class);
		scanner.put("TextRenderer", FontRenderer.class);
		scanner.put("TextureManager", TextureManager.class);
		scanner.put("TooltipContext", ITooltipFlag.class);
		scanner.put("Util", Util.class);
		scanner.put("Vector3d", Vector3d.class);
		scanner.put("Vector3f", Vector3f.class);
		scanner.put("Vector3i", Vector3i.class);
		scanner.put("VertexFormat", VertexFormat.class);
		scanner.put("VertexFormatElement", VertexFormatElement.class);
		scanner.put("VertexFormats", DefaultVertexFormats.class, "VertexFormats");
		scanner.put("VoxelShape", VoxelShape.class);
		scanner.put("VoxelShapes", VoxelShapes.class, "VoxelShapes");
		scanner.put("Window", MainWindow.class);
		scanner.put("World", World.class);
		scanner.put("WorldAccess", IWorld.class);
		scanner.put("WorldChunk", Chunk.class);
		scanner.put("WorldRenderer", WorldRenderer.class);
		scanner.put("WorldSavePath", FolderName.class);
		scanner.putAbstract("AbstractSoundInstance", LocatableSound.class);
		scanner.putAbstract("Block", Block.class, "canCreatureSpawn", "getBedSpawnPosition", "getRespawnPosition");
		scanner.putAbstract("BillboardParticle", TexturedParticle.class);
		scanner.putAbstract("BlockEntity", TileEntity.class, "getType");
		scanner.putAbstract("BlockItem", BlockItem.class);
		scanner.putAbstract("ButtonWidget", Button.class);
		scanner.putAbstract("CheckboxWidget", CheckboxButton.class);
		scanner.putAbstract("ClickableWidget", Widget.class);
		scanner.putAbstract("DoorBlock", DoorBlock.class, "canCreatureSpawn", "getBedSpawnPosition", "getRespawnPosition");
		scanner.putAbstract("Entity", Entity.class, "getType");
		scanner.putAbstract("EntityModel", EntityModel.class, "andThen");
		scanner.putAbstract("Item", Item.class);
		scanner.putAbstract("Model", Model.class);
		scanner.putAbstract("MovingSoundInstance", TickableSound.class);
		scanner.putAbstract("Particle", Particle.class);
		scanner.putAbstract("PersistentState", WorldSavedData.class);
		scanner.putAbstract("PlaceableOnWaterItem", LilyPadItem.class);
		scanner.putAbstract("PressableWidget", AbstractButton.class);
		scanner.putAbstract("Screen", Screen.class);
		scanner.putAbstract("SlabBlock", SlabBlock.class, "canCreatureSpawn", "getBedSpawnPosition", "getRespawnPosition");
		scanner.putAbstract("SliderWidget", AbstractSlider.class);
		scanner.putAbstract("SpriteBillboardParticle", SpriteTexturedParticle.class);
		scanner.putAbstract("StairsBlock", StairsBlock.class, "canCreatureSpawn", "getBedSpawnPosition", "getRespawnPosition");
		scanner.putAbstract("TextFieldWidget", TextFieldWidget.class);
		scanner.putAbstract("TexturedButtonWidget", ImageButton.class);
		scanner.putAbstract("ToggleButtonWidget", ToggleWidget.class);
		scanner.putInterface("BlockColorProvider", IBlockColor.class);
		scanner.putInterface("ItemColorProvider", IItemColor.class);
		scanner.putInterface("PressAction", Button.IPressable.class);
		scanner.putInterface("StringIdentifiable", IStringSerializable.class);
		scanner.putInterface("TickableSoundInstance", ITickableSound.class);
		scanner.generate();
	}
}
