package com.kcn.mixin;

import com.kcn.ModPotion;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingMixin {

    @Invoker("registerPotionRecipe")
    @SuppressWarnings("ALL")
    private static void registerPotionRecipe(Potion input, Item item, Potion output) {}

    @Inject(at = @At("TAIL"), method = "registerDefaults")
    private static void registerDefaults(CallbackInfo ci) {
        BrewingMixin.registerPotionRecipe(Potions.FIRE_RESISTANCE, Items.TROPICAL_FISH, ModPotion.ADVANCED_FIRE_PROTECTION_POTION);
        BrewingMixin.registerPotionRecipe(Potions.LONG_FIRE_RESISTANCE, Items.TROPICAL_FISH, ModPotion.LONG_ADVANCED_FIRE_PROTECTION_POTION);
        BrewingMixin.registerPotionRecipe(ModPotion.ADVANCED_FIRE_PROTECTION_POTION, Items.GLOWSTONE_DUST, ModPotion.STRONG_ADVANCED_FIRE_PROTECTION_POTION);
        BrewingMixin.registerPotionRecipe(ModPotion.LONG_ADVANCED_FIRE_PROTECTION_POTION, Items.GLOWSTONE_DUST, ModPotion.LONG_STRONG_ADVANCED_FIRE_PROTECTION_POTION);
    }
}


