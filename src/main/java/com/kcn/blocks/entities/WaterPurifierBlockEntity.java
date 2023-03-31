package com.kcn.blocks.entities;

import com.kcn.items.ModItem;
import com.kcn.screen.handler.WaterPurifierScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class WaterPurifierBlockEntity extends LootableContainerBlockEntity {

    private int water = 0;
    private int coal = 0;
    private int time = 0;

    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> water;
                case 1 -> coal;
                case 2 -> time;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> WaterPurifierBlockEntity.this.water = value;
                case 1 -> WaterPurifierBlockEntity.this.coal = value;
                case 2 -> WaterPurifierBlockEntity.this.time = value;
                default -> {
                }
            }
        }

        @Override
        public int size() {
            return 3;
        }
    };

    private DefaultedList<ItemStack> inv = DefaultedList.ofSize(4, ItemStack.EMPTY);


    public static void tick(WaterPurifierBlockEntity entity) {
        // 0 -- coal 1 -- water_bucket 2 -- water_bottle
        if (entity.inv.get(2).getItem() == Items.GLASS_BOTTLE && entity.coal > 0 && entity.water > 0 && entity.inv.get(3).getCount() < 64) {
            entity.time++;
            if (entity.time == 20 * 4) {
                entity.time = 0;
                entity.coal--;
                entity.water--;
                entity.inv.get(2).decrement(1);
                if (entity.inv.get(3).isEmpty()) {
                    entity.inv.set(3, new ItemStack(ModItem.PURIFIED_WATER));
                } else {
                    entity.inv.get(3).increment(1);
                }
            }
        } else {
            entity.time = 0;
        }
        if (entity.coal < 3 && !entity.inv.get(0).isEmpty()) {
            entity.inv.get(0).decrement(1);
            entity.coal++;
        }
        if (entity.water < 5 && entity.inv.get(1).getItem() == Items.WATER_BUCKET) {
            entity.inv.set(1, new ItemStack(Items.BUCKET));
            entity.water++;
        }
    }

    public WaterPurifierBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntity.WATER_PURIFIER_BLOCK_ENTITY, blockPos, blockState);
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inv;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inv = list;
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("Water Purifier");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new WaterPurifierScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public int size() {
        return 4;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inv);
        nbt.putInt("water", water);
        nbt.putInt("coal", coal);
        nbt.putInt("time", time);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.water = nbt.getInt("water");
        this.coal = nbt.getInt("coal");
        this.time = nbt.getInt("time");
        Inventories.readNbt(nbt, inv);
    }
}
