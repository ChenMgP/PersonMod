package com.kcn.blocks.entities.chest;

import com.kcn.blocks.entities.ModBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class EChestEntity extends BlockEntity {
    public EChestEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.E_CHEST_BLOCK_ENTITY, pos, state);
    }
}
