package omegasleepy.contentmod.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.MainLogic;
import omegasleepy.contentmod.item.custom.MagicBoneMealItem;
import omegasleepy.contentmod.item.custom.MoneyItem;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static List<Item> money_items = new ArrayList<>();


    public static final Item MAGIC_BONEMEAL = registerItem("magic_bonemeal", new MagicBoneMealItem(new Item.Settings()));

    public static final Item ONE_KARAT = registerItem("one_karat", new MoneyItem(new Item.Settings(), 1));
    public static final Item TWO_KARAT = registerItem("two_karat", new MoneyItem(new Item.Settings(), 2));
    public static final Item FIVE_KARAT = registerItem("five_karat", new MoneyItem(new Item.Settings(), 5));
    public static final Item TEN_KARAT = registerItem("ten_karat", new MoneyItem(new Item.Settings(), 10));
    public static final Item TWENTY_KARAT = registerItem("twenty_karat", new MoneyItem(new Item.Settings(), 20));
    public static final Item FIFTY_KARAT = registerItem("fifty_karat", new MoneyItem(new Item.Settings(), 50));
    public static final Item ONE_HUNDRED_KARAT = registerItem("one_hundred_karat", new MoneyItem(new Item.Settings(), 100));
    public static final Item TWO_HUNDRED_KARAT = registerItem("two_hundred_karat", new MoneyItem(new Item.Settings(), 200));
    public static final Item FIVE_HUNDRED_KARAT = registerItem("five_hundred_karat", new MoneyItem(new Item.Settings(), 500));
    public static final Item TEN_HUNDRED_KARAT = registerItem("ten_hundred_karat", new MoneyItem(new Item.Settings(), 1000));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MainLogic.MOD_ID, name), item);
    }


    public static void registerModItems() {
        MainLogic.LOGGER.info("Registering Mod Items for {}", MainLogic.MOD_ID);
    }

}
