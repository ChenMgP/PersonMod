package com.kcn.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffect {

    public static void effect() {}

    private static StatusEffect register(String name, StatusEffect entry) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier("kcn", name), entry);
    }

    public static final StatusEffect ADVANCED_FIRE_PROTECTION = ModEffect.register("advanced_fire_protection", new AdvancedFireProtection());
    public static final StatusEffect COLD = ModEffect.register("cold", new ColdEffect());


}
