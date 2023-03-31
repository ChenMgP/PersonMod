package com.kcn.items;

import com.kcn.blocks.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CraftingCisternScroll extends Item {
    public CraftingCisternScroll(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        BlockPos pos = new BlockPos(blockPos.getX(), blockPos.getY() +1, blockPos.getZ());
        World world = context.getWorld();
        Block block = world.getBlockState(pos).getBlock();
        if (block == Blocks.AIR) {
            world.setBlockState(pos, ModBlock.CISTERN_0.getDefaultState());
        }
        return super.useOnBlock(context);
    }
}
