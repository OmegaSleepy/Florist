package omegasleepy.contentmod;

import net.fabricmc.api.ModInitializer;

import omegasleepy.contentmod.block.ModBlocks;
import omegasleepy.contentmod.item.ModItemGroups;
import omegasleepy.contentmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentMod implements ModInitializer {
	public static final String MOD_ID = "contentmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}