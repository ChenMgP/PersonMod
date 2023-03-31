package com.kcn.blocks.entities;

import com.kcn.blocks.cistern.Cistern;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CisternEntity extends BlockEntity {

    public int tick = 0;
    public int water = 0;

    public CisternEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.CISTERN_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, CisternEntity entity) {
        BlockPos pos1 = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
        if (world.hasRain(pos1) && entity.water < 5) {
            entity.tick++;
            if (entity.tick == 20 * 85) {
                entity.water++;
                entity.tick = 0;
                if (world.getBlockState(pos).getBlock() instanceof Cistern cistern) {
                    cistern.addWater(world, pos, world.getBlockState(pos));
                }
            }
        } else {
            entity.tick = 0;
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.tick = nbt.getInt("tick");
        this.water = nbt.getInt("water");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("tick", tick);
        nbt.putInt("water", water);
    }
}
