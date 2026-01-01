package omegasleepy.contentmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import omegasleepy.contentmod.MainLogic;
import omegasleepy.contentmod.block.ModBlocks;
import omegasleepy.contentmod.item.ModItems;
import omegasleepy.contentmod.villager.ModVillagers;

import java.util.List;

public class ModCustomTrades {

    public static void botanist () {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.BOTANIC, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.MAGIC_BONEMEAL, 16),
                            16,
                            1,
                            0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.BONE_MEAL, 16),
                            new ItemStack(Items.EMERALD, 1),
                            16,
                            1,
                            0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.FLOWER_POT, 4),
                            16,
                            2,
                            0.05f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.BOTANIC, 2,
                factories -> ModCustomTrades.addBlocks(factories, ModBlocks.oneTallFlowers));

        TradeOfferHelper.registerVillagerOffers(ModVillagers.BOTANIC, 3,
                factories -> ModCustomTrades.addBlocks(factories, ModBlocks.flowerbeds));

        TradeOfferHelper.registerVillagerOffers(ModVillagers.BOTANIC, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.TORCHFLOWER_SEEDS, 16),
                            7,
                            10,
                            0.05f
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.PITCHER_POD, 16),
                            7,
                            10,
                            0.05f
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.SNIFFER_EGG, 1),
                            new ItemStack(Items.EMERALD, 32),
                            6,
                            20,
                            0.25f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.BOTANIC, 5,
                factories -> ModCustomTrades.addBlocks(factories, ModBlocks.twoTallFlowers));

    }

    private static void addBlocks (List<TradeOffers.Factory> factories, List<Block> blocks) {
        for (var that : blocks) {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(that, 8),
                    16,
                    2,
                    0.05f
            ));
        }
    }

    public static void registerCustomTrades () {
        MainLogic.LOGGER.info("Registering Custom Villager Trades for {}}", MainLogic.MOD_ID);
        botanist();
    }

}
