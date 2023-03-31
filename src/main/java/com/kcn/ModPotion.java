package com.kcn;

import com.kcn.effects.ModEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotion {

    public static final Potion ADVANCED_FIRE_PROTECTION_POTION = ModPotion.register("advanced_fire_protection_potion", new Potion(new StatusEffectInstance(ModEffect.ADVANCED_FIRE_PROTECTION, 20 * 200, 0)));
    public static final Potion LONG_ADVANCED_FIRE_PROTECTION_POTION = ModPotion.register("long_advanced_fire_protection_potion", new Potion(new StatusEffectInstance(ModEffect.ADVANCED_FIRE_PROTECTION, 20 * 400, 0)));
    public static final Potion STRONG_ADVANCED_FIRE_PROTECTION_POTION = ModPotion.register("strong_advanced_fire_protection_potion", new Potion(new StatusEffectInstance(ModEffect.ADVANCED_FIRE_PROTECTION, 20 * 200, 1)));
    public static final Potion LONG_STRONG_ADVANCED_FIRE_PROTECTION_POTION = ModPotion.register("long_strong_advanced_fire_protection_potion", new Potion(new StatusEffectInstance(ModEffect.ADVANCED_FIRE_PROTECTION, 20 * 400, 1)));

    public static void potion() {
    }

    private static Potion register(String name, Potion entry) {
        return Registry.register(Registry.POTION, new Identifier("kcn", name), entry);
    }


}
