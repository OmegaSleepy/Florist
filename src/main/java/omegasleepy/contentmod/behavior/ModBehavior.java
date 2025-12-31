package omegasleepy.contentmod.behavior;

import net.minecraft.block.DispenserBlock;
import omegasleepy.contentmod.ContentMod;
import omegasleepy.contentmod.item.ModItems;

public class ModBehavior {

    public static void registerModBehavior () {
        ContentMod.LOGGER.info("Registering Mod Behavior for %s".formatted(ContentMod.MOD_ID));
        DispenserBlock.registerBehavior(ModItems.MAGIC_BONEMEAL, new CloneBoneMealBehavior());

    }
}
