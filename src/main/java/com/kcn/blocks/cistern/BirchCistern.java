package com.kcn.blocks.cistern;

import com.kcn.blocks.entities.BirchCisternEntity;
import com.kcn.blocks.entities.CisternEntity;
import com.kcn.blocks.entities.ModBlockEntity;
import com.kcn.items.ModItem;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class BirchCistern extends BlockWithEntity {
    public static final IntProperty WATER = IntProperty.of("water", 0, 5);

    public BirchCistern(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(WATER, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATER);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BirchCisternEntity(pos, state);
    }

    public void addWater(World world, BlockPos pos, BlockState state) {
        if (getWater(world, pos) < 5 && getWater(world, pos) >= 0) {
            int integer = world.getBlockState(pos).get(WATER) + 1;
            world.setBlockState(pos, state.with(WATER, integer));
        }
    }

    public void removeWater(World world, BlockPos pos, BlockState state) {
        int integer = world.getBlockState(pos).get(WATER) - 1;
        world.setBlockState(pos, state.with(WATER, integer));
    }

    public void removeWater(World world, BlockPos pos, BlockState state, int value) {
        int integer = world.getBlockState(pos).get(WATER) - value;
        world.setBlockState(pos, state.with(WATER, integer));
    }

    public void clearWater(World world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(WATER, 0));
    }

    public int getWater(World world, BlockPos pos) {
        return world.getBlockState(pos).get(WATER);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntity.BIRCH_CISTERN_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> BirchCisternEntity.tick(world1, pos, blockEntity));
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())) {
            return;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof Inventory) {
            ItemScatterer.spawn(world, pos, (Inventory) ((Object) blockEntity));
            world.updateComparators(pos, this);
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof BirchCisternEntity blockEntity) {
            if (player.getMainHandStack().getItem() == Items.GLASS_BOTTLE && getWater(world, pos) > 0) {
                player.getMainHandStack().decrement(1);
                player.giveItemStack(new ItemStack(ModItem.PURIFIED_WATER));
                removeWater(world, pos, world.getBlockState(pos));
                blockEntity.water--;
                return ActionResult.SUCCESS;
            }
            if (player.getMainHandStack().getItem() == ModItem.WATER_BAG && getWater(world, pos) > 0) {
                int value = getWater(world, pos);
                if (player.getMainHandStack().hasNbt()) {
                    int amount = Objects.requireNonNull(player.getMainHandStack().getNbt()).getInt("amount");
                    int a = amount + value;
                    if (a > 20) {
                        if (amount < 20) {
                            int x = 20 - amount;
                            NbtCompound nbt = new NbtCompound();
                            nbt.putInt("amount", 20);
                            NbtCompound nbt1 = new NbtCompound();
                            NbtString string = NbtString.of(NbtString.escape("§f§l剩余水量: §b" + 20));
                            NbtList list = new NbtList();
                            list.add(string);
                            nbt1.put("Lore", list);
                            nbt.put("display", nbt1);
                            player.getMainHandStack().setNbt(nbt);
                            removeWater(world, pos, state, 5 - (value - x));
                            return ActionResult.SUCCESS;
                        }
                        return ActionResult.PASS;
                    }
                    NbtCompound nbt = new NbtCompound();
                    nbt.putInt("amount", a);
                    NbtCompound nbt1 = new NbtCompound();
                    NbtString string = NbtString.of(NbtString.escape("§f§l剩余水量: §b" + a));
                    NbtList list = new NbtList();
                    list.add(string);
                    nbt1.put("Lore", list);
                    nbt.put("display", nbt1);
                    player.getMainHandStack().setNbt(nbt);
                } else {
                    NbtCompound nbt = new NbtCompound();
                    nbt.putInt("amount", value);
                    NbtCompound nbt1 = new NbtCompound();
                    NbtString string = NbtString.of(NbtString.escape("§f§l剩余水量: §b" + value));
                    NbtList list = new NbtList();
                    list.add(string);
                    nbt1.put("Lore", list);
                    nbt.put("display", nbt1);
                    player.getMainHandStack().setNbt(nbt);
                }
                clearWater(world, pos, state);
                return ActionResult.SUCCESS;
            }
            if (player.getMainHandStack().getItem() == Items.PAPER) {
                player.getMainHandStack().decrement(1);
                player.giveItemStack(new ItemStack(ModItem.CRAFTING_CISTERN_SCROLL));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
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
