package com.kcn.blocks.cistern;

import com.kcn.blocks.ModBlock;
import com.kcn.items.ModItem;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Cistern0 extends TransparentBlock {

    public Cistern0(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem() == ModItem.DELETE_SCROLL) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 4.0f, 1.75f, true);
            return ActionResult.SUCCESS;
        }
        String id = Registry.ITEM.getId(player.getMainHandStack().getItem()).toString();
        switch (id) {
            case "kcn:oak_wooden_stake" -> {
                player.getMainHandStack().decrement(1);
                world.setBlockState(pos, ModBlock.CISTERN_1.getDefaultState());
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 4.0f, 2.0f, true);
                return ActionResult.SUCCESS;
            }
            case "kcn:birch_wooden_stake" -> {
                player.getMainHandStack().decrement(1);
                world.setBlockState(pos, ModBlock.BIRCH_CISTERN_1.getDefaultState());
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 4.0f, 2.0f, true);
                return ActionResult.SUCCESS;
            }
            case "kcn:jungle_wooden_stake" -> {
                player.getMainHandStack().decrement(1);
                world.setBlockState(pos, ModBlock.JUNGLE_CISTERN_1.getDefaultState());
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 4.0f, 2.0f, true);
                return ActionResult.SUCCESS;
            }
            case "kcn:acacia_wooden_stake" -> {
                player.getMainHandStack().decrement(1);
                world.setBlockState(pos, ModBlock.ACACIA_CISTERN_1.getDefaultState());
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 4.0f, 2.0f, true);
                return ActionResult.SUCCESS;
            }
            case "kcn:spruce_wooden_stake" -> {
                player.getMainHandStack().decrement(1);
                world.setBlockState(pos, ModBlock.SPRUCE_CISTERN_1.getDefaultState());
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 4.0f, 2.0f, true);
                return ActionResult.SUCCESS;
            }
            case "kcn:dark_oak_wooden_stake" -> {
                player.getMainHandStack().decrement(1);
                world.setBlockState(pos, ModBlock.DARK_OAK_CISTERN_1.getDefaultState());
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 4.0f, 2.0f, true);
                return ActionResult.SUCCESS;
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(2.0, 0.0, 3.0, 13.0, 12.5, 13.0);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(2.0, 0.0, 3.0, 13.0, 12.5, 13.0);
    }

}
