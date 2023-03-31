package com.kcn.screen.handler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class WaterPurifierScreenHandler extends ScreenHandler {
    private final PropertyDelegate propertyDelegate;
    public Inventory inventory;


    public WaterPurifierScreenHandler(int synId, PlayerInventory playerInventory) {
        this(synId, playerInventory, new SimpleInventory(4), new ArrayPropertyDelegate(3));
    }

    public WaterPurifierScreenHandler(int synId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ModScreenHandler.WATER_PURIFIER_SCREEN_HANDLER, synId);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.addProperties(propertyDelegate);
        checkSize(inventory, 4);
        checkDataCount(propertyDelegate, 3);
        this.addSlot(new Slot(this.inventory, 0, 89, 16) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.getItem() == Items.CHARCOAL;
            }
        });
        this.addSlot(new Slot(this.inventory, 1, 28, 30) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.getItem() == Items.WATER_BUCKET;
            }
        });
        this.addSlot(new Slot(this.inventory, 2, 28, 57) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.getItem() == Items.GLASS_BOTTLE;
            }
        });
        this.addSlot(new Slot(this.inventory, 3, 61, 57) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });
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
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    public int getWater() {
        return this.propertyDelegate.get(0);
    }

    public int getCoal() {
        return this.propertyDelegate.get(1);
    }

    public int getTime() {
        return this.propertyDelegate.get(2);
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
