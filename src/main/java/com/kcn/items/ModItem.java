package com.kcn.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItem {

    public static final Item WOODEN_STAKE = ModItem.register("oak_wooden_stake", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item BIRCH_WOODEN_STAKE = ModItem.register("birch_wooden_stake", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item SPRUCE_WOODEN_STAKE = ModItem.register("spruce_wooden_stake", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item JUNGLE_WOODEN_STAKE = ModItem.register("jungle_wooden_stake", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item ACACIA_WOODEN_STAKE = ModItem.register("acacia_wooden_stake", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item DARK_OAK_WOODEN_STAKE = ModItem.register("dark_oak_wooden_stake", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item WOODEN_BOX = ModItem.register("oak_wooden_box", new Item(new Item.Settings().group(Group.WATER_GROUP).maxCount(1)));
    public static final Item BIRCH_WOODEN_BOX = ModItem.register("birch_wooden_box", new Item(new Item.Settings().group(Group.WATER_GROUP).maxCount(1)));
    public static final Item SPRUCE_WOODEN_BOX = ModItem.register("spruce_wooden_box", new Item(new Item.Settings().group(Group.WATER_GROUP).maxCount(1)));
    public static final Item JUNGLE_WOODEN_BOX = ModItem.register("jungle_wooden_box", new Item(new Item.Settings().group(Group.WATER_GROUP).maxCount(1)));
    public static final Item ACACIA_WOODEN_BOX = ModItem.register("acacia_wooden_box", new Item(new Item.Settings().group(Group.WATER_GROUP).maxCount(1)));
    public static final Item DARK_OAK_WOODEN_BOX = ModItem.register("dark_oak_wooden_box", new Item(new Item.Settings().group(Group.WATER_GROUP).maxCount(1)));
    public static final Item WOODEN_SIDE = ModItem.register("oak_wooden_side", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item BIRCH_WOODEN_SIDE = ModItem.register("birch_wooden_side", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item SPRUCE_WOODEN_SIDE = ModItem.register("spruce_wooden_side", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item JUNGLE_WOODEN_SIDE = ModItem.register("jungle_wooden_side", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item ACACIA_WOODEN_SIDE = ModItem.register("acacia_wooden_side", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item DARK_OAK_WOODEN_SIDE = ModItem.register("dark_oak_wooden_side", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item IRON_SHEET = ModItem.register("iron_sheet", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item WOODEN_BASE_WRAPPED_WITH_WIRE = ModItem.register("oak_wooden_bas_wrapped_with_wire", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item BIRCH_WOODEN_BASE_WRAPPED_WITH_WIRE = ModItem.register("birch_wooden_bas_wrapped_with_wire", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item SPRUCE_WOODEN_BASE_WRAPPED_WITH_WIRE = ModItem.register("spruce_wooden_bas_wrapped_with_wire", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item JUNGLE_WOODEN_BASE_WRAPPED_WITH_WIRE = ModItem.register("jungle_wooden_bas_wrapped_with_wire", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item ACACIA_WOODEN_BASE_WRAPPED_WITH_WIRE = ModItem.register("acacia_wooden_bas_wrapped_with_wire", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item DARK_WOODEN_BASE_WRAPPED_WITH_WIRE = ModItem.register("dark_oak_wooden_bas_wrapped_with_wire", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item WOODEN_BASE = ModItem.register("oak_wooden_base", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item BIRCH_WOODEN_BASE = ModItem.register("birch_wooden_base", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item SPRUCE_WOODEN_BASE = ModItem.register("spruce_wooden_base", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item JUNGLE_WOODEN_BASE = ModItem.register("jungle_wooden_base", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item ACACIA_WOODEN_BASE = ModItem.register("acacia_wooden_base", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item DARK_OAK_WOODEN_BASE = ModItem.register("dark_oak_wooden_base", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item PURIFIED_WATER = ModItem.register("purified_water", new BoiledWater(new Item.Settings().maxCount(1).group(Group.WATER_GROUP)));
    public static final Item WATER_BAG = ModItem.register("water_bag", new WaterBag(new Item.Settings().maxCount(1).group(Group.WATER_GROUP)));
    public static final Item ANTIPARASITIC_DRUGS = ModItem.register("antiparasitic_drugs", new AntiparasiticDrugs(new Item.Settings().group(Group.WATER_GROUP).food(new FoodComponent.Builder().alwaysEdible().snack().build())));
    public static final Item CRAFTING_CISTERN_SCROLL = ModItem.register("crafting_cistern_scroll", new CraftingCisternScroll(new Item.Settings().group(Group.WATER_GROUP).maxCount(1)));
    public static final Item DELETE_SCROLL = ModItem.register("delete_scroll", new Item(new Item.Settings().group(Group.WATER_GROUP)));
    public static final Item BAG = ModItem.register("bag", new BagItem(new Item.Settings().group(Group.WATER_GROUP).maxCount(1)));

    public static void item() {
    }

    private static Item register(String name, Item entry) {
        return Registry.register(Registry.ITEM, new Identifier("kcn", name), entry);
    }
    public static class Group {
        public static final ItemGroup WATER_GROUP = FabricItemGroupBuilder.create(
                        new Identifier("kcn", "water_group"))
                .icon(() -> new ItemStack(ModItem.PURIFIED_WATER)).build();
    }
}
