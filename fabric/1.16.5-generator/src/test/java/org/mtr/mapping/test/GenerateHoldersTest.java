package org.mtr.mapping.test;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.property.*;
import net.minecraft.text.MutableText;
import net.minecraft.text.OrderedText;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.*;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import net.minecraft.world.chunk.ChunkManager;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.explosion.Explosion;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

public final class GenerateHoldersTest {

	@Test
	public void generate() throws IOException {
		final GenerateHolders generateHolders = new GenerateHolders();
		generateHolders.put("ActionResult", ActionResult.class);
		generateHolders.put("Axis", Direction.Axis.class);
		generateHolders.put("BlockEntityRendererArgument", BlockEntityRenderDispatcher.class);
		generateHolders.put("BlockEntityType", BlockEntityType.class);
		generateHolders.put("BlockHitResult", BlockHitResult.class);
		generateHolders.put("BlockPos", BlockPos.class);
		generateHolders.put("BlockState", BlockState.class);
		generateHolders.put("BlockView", BlockView.class);
		generateHolders.put("BooleanProperty", BooleanProperty.class);
		generateHolders.put("Box", Box.class);
		generateHolders.put("ChunkManager", ChunkManager.class);
		generateHolders.put("ClientWorld", ClientWorld.class);
		generateHolders.put("CompoundTag", NbtCompound.class);
		generateHolders.put("Direction", Direction.class);
		generateHolders.put("DirectionProperty", DirectionProperty.class);
		generateHolders.put("EntityType", EntityType.class);
		generateHolders.put("EnumProperty", EnumProperty.class);
		generateHolders.put("Explosion", Explosion.class);
		generateHolders.put("FluidState", FluidState.class);
		generateHolders.put("Hand", Hand.class);
		generateHolders.put("HeightMapType", Heightmap.Type.class);
		generateHolders.put("IntegerProperty", IntProperty.class);
		generateHolders.put("ItemPlacementContext", ItemPlacementContext.class);
		generateHolders.put("ItemStack", ItemStack.class);
		generateHolders.put("ItemUsageContext", ItemUsageContext.class);
		generateHolders.put("LivingEntity", LivingEntity.class);
		generateHolders.put("MathHelper", MathHelper.class);
		generateHolders.put("Mirror", BlockMirror.class);
		generateHolders.put("MutableText", MutableText.class);
		generateHolders.put("OrderedText", OrderedText.class);
		generateHolders.put("PacketBuffer", PacketByteBuf.class);
		generateHolders.put("PlayerEntity", PlayerEntity.class);
		generateHolders.put("Position", Position.class);
		generateHolders.put("Property", Property.class);
		generateHolders.put("Random", Random.class);
		generateHolders.put("ResourceLocation", Identifier.class);
		generateHolders.put("Rotation", BlockRotation.class);
		generateHolders.put("Scoreboard", Scoreboard.class);
		generateHolders.put("ServerPlayerEntity", ServerPlayerEntity.class);
		generateHolders.put("ServerWorld", ServerWorld.class);
		generateHolders.put("ServerWorldAccess", ServerWorldAccess.class);
		generateHolders.put("ShapeContext", ShapeContext.class);
		generateHolders.put("SoundCategory", SoundCategory.class);
		generateHolders.put("SoundEvent", SoundEvent.class);
		generateHolders.put("TextFormatting", Formatting.class);
		generateHolders.put("TooltipContext", TooltipContext.class);
		generateHolders.put("Vector3d", Vec3d.class);
		generateHolders.put("Vector3f", Vec3f.class);
		generateHolders.put("Vector3i", Vec3i.class);
		generateHolders.put("VoxelShape", VoxelShape.class);
		generateHolders.put("VoxelShapes", VoxelShapes.class);
		generateHolders.put("World", World.class);
		generateHolders.put("WorldAccess", WorldAccess.class);
		generateHolders.put("WorldChunk", WorldChunk.class);
		generateHolders.putAbstract("Block", Block.class);
		generateHolders.putAbstract("BlockEntity", BlockEntity.class);
		generateHolders.putAbstract("Entity", Entity.class);
		generateHolders.putAbstract("Item", Item.class);
		generateHolders.generate();
	}
}
