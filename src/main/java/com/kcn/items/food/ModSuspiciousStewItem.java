package com.kcn.items.food;

import com.kcn.util.Data;
import net.minecraft.item.SuspiciousStewItem;

public class ModSuspiciousStewItem extends SuspiciousStewItem {

    private final int water;
    private final int fat;
    private final int protein;
    private final int carbohydrate;

    public ModSuspiciousStewItem(Settings settings, int water, int fat, int protein, int carbohydrate) {
        super(settings);
        this.water = water;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
    }


    public void changeHealth(Data data) {
        data.increaseFat(fat);
        data.increaseCarbohydrate(carbohydrate);
        data.increaseProtein(protein);
        data.increase(water);
    }

}
