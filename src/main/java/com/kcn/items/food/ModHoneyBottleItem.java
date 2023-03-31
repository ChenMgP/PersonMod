package com.kcn.items.food;

import com.kcn.util.Data;
import net.minecraft.item.HoneyBottleItem;

public class ModHoneyBottleItem extends HoneyBottleItem {

    private final int carbohydrate;
    private final int tickSpeedValue;

    public ModHoneyBottleItem(Settings settings, int carbohydrate, int tickSpeedValue) {
        super(settings);
        this.carbohydrate = carbohydrate;
        this.tickSpeedValue = tickSpeedValue;
    }

    public void changeHealth(Data data) {
        data.increaseCarbohydrate(carbohydrate);
        data.tickSpeed(tickSpeedValue);
    }
}
