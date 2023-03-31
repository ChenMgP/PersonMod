package com.kcn.mixin;

import com.kcn.items.food.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Items.class)
public class ItemMixin {

    /**
     * @author NaiBai
     * @reason For Mod
     */
    @Overwrite
    private static Item register(String id, Item item) {
        switch (id) {
            case "beef" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).meat()
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 30 * 20, 1), 1).alwaysEdible().build()), 0, 4, 18, 0, 250, true);
            case "chicken", "mutton" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).meat()
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 30 * 20, 1), 1).alwaysEdible().build()), 0, 4, 12, 0, 250, true);
            case "porkchop" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).meat()
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 30 * 20, 1), 1).alwaysEdible().build()), 0, 6, 15, 0, 250, true);
            case "rabbit" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).meat()
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 30 * 20, 1), 1).alwaysEdible().build()), 0, 4, 12, 0, 250, true);
            case "cod" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 30 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 30 * 20, 1), 1).alwaysEdible().build()), 0, 0, 6, 0, 230, true);
            case "salmon" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 30 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 30 * 20, 1), 1).alwaysEdible().build()), 0, 0, 8, 0, 230, true);
            case "tropical_fish" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 30 * 20, 1), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 30 * 20, 1), 1).alwaysEdible().build()), 0, 0, 5, 0, 230, true);
            case "pufferfish" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 1), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 2), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 600, 1), 1).alwaysEdible().build()), 0, 0, 6, 0, 230, true);
            case "cooked_beef" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).meat().alwaysEdible().build()), 0, 12, 34, 0, 250, false);
            case "cooked_chicken" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).meat().alwaysEdible().build()), 0, 10, 30, 0, 250, false);
            case "cooked_mutton" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).meat().alwaysEdible().build()), 0, 12, 29, 0, 250, false);
            case "cooked_porkchop" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).meat().alwaysEdible().build()), 0, 15, 30, 0, 250, false);
            case "cooked_rabbit" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).meat().alwaysEdible().build()), 0, 10, 27, 0, 250, false);
            case "cooked_cod" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).alwaysEdible().build()), 0, 0, 18, 0, 230, false);
            case "cooked_salmon" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible().build()), 0, 0, 22, 0, 230, false);
            case "mushroom_stew" ->
                    item = new ModStewItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).alwaysEdible().build()).maxCount(1), 0, 0, 0, 7, 300);
            case "rabbit_stew" ->
                    item = new ModStewItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).alwaysEdible().build()).maxCount(1), 0, 10, 27, 27, 300);
            case "beetroot_soup" ->
                    item = new ModStewItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).alwaysEdible().build()).maxCount(1), 2, 0, 0, 36, 0);
            case "suspicious_stew" ->
                    item = new ModSuspiciousStewItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).alwaysEdible().build()).maxCount(1), 2, 0, 0, 15);
            case "apple" ->//
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).alwaysEdible().build()), 2, 0, 0, 5, 0, false);
            case "melon_slice" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).alwaysEdible().build()), 2, 0, 0, 2, 0, false);
            case "chorus_fruit" ->
                    item = new ModChorusFruitItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).alwaysEdible().build()), 2, 3);
            case "glow_berries", "sweet_berries" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).alwaysEdible().build()), 2, 0, 0, 2, 0, false);
            case "golden_apple" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.2f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0f).alwaysEdible().build()), 2, 0, 0, 2, 0, false);
            case "enchanted_golden_apple" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0f).alwaysEdible().build()), 2, 0, 0, 5, 0, false);
            case "carrot" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).alwaysEdible().build()), 1, 0, 0, 7, 0, false);
            case "potato" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).alwaysEdible().build()), 1, 0, 0, 10, 0, false);
            case "beetroot" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.6f).alwaysEdible().build()), 1, 0, 0, 6, 0, false);
            case "golden_carrot" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(1.2f).alwaysEdible().build()), 1, 0, 0, 7, 0, false);
            case "bread" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).alwaysEdible().build()), 0, 0, 0, 25, 145, false);
            case "pumpkin_pie" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.3f).alwaysEdible().build()), 0, 0, 0, 45, 145, false);
            case "cookie" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).alwaysEdible().build()), 0, 0, 0, 20, 145, false);
            case "baked_potato" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).alwaysEdible().build()), 0, 0, 0, 50, 0, false);
            case "honey_bottle" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.1f).alwaysEdible().build()).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16), 0, 0, 0, 15, 145, false);
            case "dried_kelp" ->
                    item = new ModFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).snack().alwaysEdible().build()), 0, 0, 0, 6, 0, false);
            case "rotten_flesh" ->
                    item = new ModBadFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.8f).meat().alwaysEdible().build()), 4, 4, 250);
            case "spider_eye" ->
                    item = new ModBadFoodItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0f).alwaysEdible().build()), 2, 3, 170);
        }
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registry.ITEM, new Identifier(id), item);
    }

}
