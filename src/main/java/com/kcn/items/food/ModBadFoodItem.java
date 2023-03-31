package com.kcn.items.food;

import com.kcn.util.Data;
import net.minecraft.item.Item;

public class ModBadFoodItem extends Item {

    private final int protein;
    private final int tickSpeedValue;
    private final int parasite;

    public ModBadFoodItem(Settings settings, int protein, int parasite, int tickSpeedValue) {
        super(settings);
        this.protein = protein;
        this.parasite = parasite;
        this.tickSpeedValue = tickSpeedValue;
    }

    public void changeHealth(Data data) {
        data.increaseProtein(protein);
        data.parasiteIncrease(parasite);
        data.tickSpeed(tickSpeedValue);
    }
}
