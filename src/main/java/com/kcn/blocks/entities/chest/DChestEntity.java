package com.kcn.blocks.entities.chest;

import com.kcn.blocks.entities.ModBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class DChestEntity extends BlockEntity {
    public DChestEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.D_CHEST_BLOCK_ENTITY, pos, state);
    }
}
