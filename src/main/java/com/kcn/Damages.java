package com.kcn;

import net.minecraft.entity.damage.DamageSource;

public class Damages extends DamageSource {
    protected Damages(String name) {
        super(name);
    }

    public static final DamageSource HEALTH = new Damages("health");
    public static final DamageSource COLD = new Damages("cold");

}

