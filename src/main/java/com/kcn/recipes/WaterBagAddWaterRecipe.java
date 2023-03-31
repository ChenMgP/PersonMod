package com.kcn.recipes;

import com.google.common.collect.Lists;
import com.kcn.items.ModItem;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;

public class WaterBagAddWaterRecipe extends SpecialCraftingRecipe {

    private ArrayList<Integer> list = Lists.newArrayList();
    private int water = 0;

    public WaterBagAddWaterRecipe(Identifier id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        boolean hasWaterBag = false;
        boolean hasCleanWater = false;
        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()) {
                if (stack.getItem() == ModItem.WATER_BAG) {
                    hasWaterBag = true;
                } else if (stack.getItem() == ModItem.PURIFIED_WATER) {
                    hasCleanWater = true;
                } else {
                    return false;
                }
            }
        }
        return hasWaterBag && hasCleanWater;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        boolean hasWaterBag = false;
        boolean hasCleanWater = false;
        int count = 0;
        ArrayList<Integer> arr = Lists.newArrayList();
        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()) {
                if (stack.getItem() != ModItem.PURIFIED_WATER && stack.getItem() != ModItem.WATER_BAG) {
                    return ItemStack.EMPTY;
                }
                if (stack.getItem() == ModItem.WATER_BAG && hasWaterBag) {
                    return ItemStack.EMPTY;
                }
                if (stack.getItem() == ModItem.WATER_BAG) {
                    if (stack.hasNbt()) {
                        assert stack.getNbt() != null;
                        water = stack.getNbt().getInt("amount");
                    } else {
                        water = 0;
                    }
                    hasWaterBag = true;
                }
                if (stack.getItem() == ModItem.PURIFIED_WATER) {
                    hasCleanWater = true;
                    count++;
                    arr.add(i);
                }
            }
        }
        list = arr;
        if (hasWaterBag && hasCleanWater) {
            ItemStack stack = new ItemStack(ModItem.WATER_BAG);
            int a = water + count;
            if (a > 20) {
                return ItemStack.EMPTY;
            }
            NbtCompound nbt = new NbtCompound();
            nbt.putInt("amount", a);
            NbtCompound nbt1 = new NbtCompound();
            NbtString string = NbtString.of(NbtString.escape("§f§l剩余水量: §b" + a));
            NbtList list = new NbtList();
            list.add(string);
            nbt1.put("Lore", list);
            nbt.put("display", nbt1);
            stack.setNbt(nbt);
            return stack;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(9, ItemStack.EMPTY);
        for (Integer i : list) {
            defaultedList.set(i, new ItemStack(Items.GLASS_BOTTLE));
        }
        return defaultedList;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipe.WATER_BAG_ADD_WATER_RECIPE;
    }
}
