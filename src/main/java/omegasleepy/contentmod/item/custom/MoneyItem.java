package omegasleepy.contentmod.item.custom;

import net.minecraft.item.Item;
import omegasleepy.contentmod.item.ModItems;

public class MoneyItem extends Item {
    private final int value;

    public MoneyItem (Settings settings, int value) {
        super(settings);
        this.value = value;
        ModItems.money_items.add(this);
    }

    public int getValue () {
        return value;
    }
}
