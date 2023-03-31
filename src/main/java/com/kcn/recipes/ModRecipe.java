package com.kcn.recipes;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;

public class ModRecipe {

    public static void recipe() {}

    public static final RecipeSerializer<WaterBagAddWaterRecipe> WATER_BAG_ADD_WATER_RECIPE = RecipeSerializer.register("crafting_water_bag_add_water", new SpecialRecipeSerializer<>(WaterBagAddWaterRecipe::new));

}
