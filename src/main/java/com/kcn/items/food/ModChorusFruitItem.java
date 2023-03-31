package com.kcn.items.food;

import com.kcn.util.Data;
import net.minecraft.item.ChorusFruitItem;

public class ModChorusFruitItem extends ChorusFruitItem {

    private final int water;
    private final int carbohydrate;

    public ModChorusFruitItem(Settings settings, int water, int carbohydrate) {
        super(settings);
        this.water = water;
        this.carbohydrate = carbohydrate;
    }

    public void changeHealth(Data data) {
        data.increase(water);
        data.increaseCarbohydrate(carbohydrate);
        data.reloadTime();
    }

}
