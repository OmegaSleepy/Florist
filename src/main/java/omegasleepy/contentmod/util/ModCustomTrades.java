package omegasleepy.contentmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
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
                            5,
                            0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.FLOWER_POT, 4),
                            16,
                            10,
                            0.05f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.BOTANIC, 2,
                ModCustomTrades::addAllFlowers);

        TradeOfferHelper.registerVillagerOffers(ModVillagers.BOTANIC, 3,
                ModCustomTrades::addAllFlowers);

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

    }

    private static void addAllFlowers (List<TradeOffers.Factory> factories) {
        for (var that : ModBlocks.oneTallFlowers) {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(that, 16),
                    16,
                    10,
                    0.05f
            ));
        }
    }


    public static void registerCustomTrades () {
        botanist();

    }

}
