package com.kcn.items.food;

import com.kcn.util.Data;
import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

public class ModFoodItem extends Item {

    private final int water;
    private final int fat;
    private final int protein;
    private final int carbohydrate;
    private final int tickSpeedValue;
    private final boolean isRaw;

    public boolean isRaw() {
        return isRaw;
    }

    public ModFoodItem(Settings settings, int water, int fat, int protein, int carbohydrate, int tickSpeedValue, boolean isRaw) {
        super(settings);
        this.water = water;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.tickSpeedValue = tickSpeedValue;
        this.isRaw = isRaw;
    }

    public void changeHealth(@NotNull Data data) {
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
