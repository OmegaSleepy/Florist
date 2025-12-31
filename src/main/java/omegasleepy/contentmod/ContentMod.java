package omegasleepy.contentmod;

import net.fabricmc.api.ModInitializer;

import omegasleepy.contentmod.behavior.ModBehavior;
import omegasleepy.contentmod.block.ModBlocks;
import omegasleepy.contentmod.item.ModItemGroups;
import omegasleepy.contentmod.item.ModItems;
import omegasleepy.contentmod.particle.ModParticles;
import omegasleepy.contentmod.util.ModCompostable;
import omegasleepy.contentmod.util.ModCustomTrades;
import omegasleepy.contentmod.villager.ModVillagers;
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

		ModParticles.registerParticles();

		ModBehavior.registerModBehavior();

		ModCompostable.registerCompostable();

		ModVillagers.registerVillagers();
		ModCustomTrades.registerCustomTrades();

	}
}