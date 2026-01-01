package omegasleepy.contentmod.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.MainLogic;
import omegasleepy.contentmod.item.custom.MagicBoneMealItem;

public class ModItems {

    public static final Item MAGIC_BONEMEAL = registerItem("magic_bonemeal", new MagicBoneMealItem(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MainLogic.MOD_ID, name), item);
    }


    public static void registerModItems() {
        MainLogic.LOGGER.info("Registering Mod Items for %s".formatted(MainLogic.MOD_ID));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
//            fabricItemGroupEntries.add(PINK_GARNET);
//            fabricItemGroupEntries.add(MAGIC_BONEMEAL);
//        });

    }

}
