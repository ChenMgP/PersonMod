package com.kcn.blocks.cistern.dark_oak;

import com.kcn.blocks.ModBlock;
import com.kcn.items.ModItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DarkOakCistern3 extends Block {
    public DarkOakCistern3(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem() == ModItem.DELETE_SCROLL) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItem.DARK_OAK_WOODEN_STAKE, 3)));
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 4.0f, 1.75f, true);
            return ActionResult.SUCCESS;
        }
        if (player.getMainHandStack().getItem() == ModItem.DARK_OAK_WOODEN_STAKE) {
            player.getMainHandStack().decrement(1);
            world.setBlockState(pos, ModBlock.DARK_OAK_CISTERN_4.getDefaultState());
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 4.0f, 2.0f, true);
            return ActionResult.SUCCESS;
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
