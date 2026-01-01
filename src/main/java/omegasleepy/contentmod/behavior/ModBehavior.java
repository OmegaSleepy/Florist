package omegasleepy.contentmod.behavior;

import net.minecraft.block.DispenserBlock;
import omegasleepy.contentmod.MainLogic;
import omegasleepy.contentmod.item.ModItems;

public class ModBehavior {

    public static void registerModBehavior () {
        MainLogic.LOGGER.info("Registering Mod Behavior for %s".formatted(MainLogic.MOD_ID));
        DispenserBlock.registerBehavior(ModItems.MAGIC_BONEMEAL, new CloneBoneMealBehavior());

    }
}
