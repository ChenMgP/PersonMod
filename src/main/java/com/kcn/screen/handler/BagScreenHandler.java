package com.kcn.screen.handler;

import com.kcn.items.ModItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.registry.Registry;

public class BagScreenHandler extends ScreenHandler {
    public Inventory inventory;

    public BagScreenHandler(int synId, PlayerInventory playerInventory) {
        this(synId, playerInventory, new SimpleInventory(27));
    }

    public BagScreenHandler(int synId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandler.BAG_SCREEN_HANDLER, synId);
        this.inventory = inventory;
        checkSize(inventory, 27);
        int a;
        for (a = 0; a < 3; ++a) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + a * 9, 8 + j * 18, 15 + a * 18) {
                    @Override
                    public boolean canInsert(ItemStack stack) {
                        return stack.getItem() != ModItem.BAG;
                    }
                });
            }
        }
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }



    @Override
    public void close(PlayerEntity player) {
        NbtCompound baseNbt = new NbtCompound();
        NbtList list = new NbtList();
        for (int i = 0; i < inventory.size(); i++) {
            NbtCompound item = new NbtCompound();
            if (inventory.getStack(i).hasNbt()) {
                ItemStack stack = inventory.getStack(i);
                int count = stack.getCount();
                String id = Registry.ITEM.getId(stack.getItem()).toString();
                NbtCompound nbt = stack.getNbt();
                item.put("nbt", nbt);
                item.putInt("has_nbt", 1);
                item.putInt("count", count);
                item.putString("id", id);
                list.add(item);
            } else {
                ItemStack stack = inventory.getStack(i);
                int count = stack.getCount();
                String id = Registry.ITEM.getId(stack.getItem()).toString();
                item.putString("id", id);
                item.putInt("has_nbt", 0);
                item.putInt("count", count);
                list.add(item);
            }
        }
        baseNbt.put("items", list);
        player.getMainHandStack().setNbt(baseNbt);
        super.close(player);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }
}
