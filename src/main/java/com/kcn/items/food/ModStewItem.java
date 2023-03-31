package com.kcn.items.food;

import com.kcn.util.Data;
import net.minecraft.item.StewItem;

public class ModStewItem extends StewItem {

    private final int water;
    private final int fat;
    private final int protein;
    private final int carbohydrate;
    private final int tickSpeedValue;

    public ModStewItem(Settings settings, int water, int fat, int protein, int carbohydrate, int tickSpeedValue) {
        super(settings);
        this.water = water;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.tickSpeedValue = tickSpeedValue;
    }

    public void changeHealth(Data data) {
        data.increase(water);
        data.increaseFat(fat);
        data.increaseProtein(protein);
        data.increaseCarbohydrate(carbohydrate);
        data.tickSpeed(tickSpeedValue);
    }

    public int getWater() {
        return water;
    }
}
