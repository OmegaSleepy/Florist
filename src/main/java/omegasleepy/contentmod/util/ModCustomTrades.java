package omegasleepy.contentmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import omegasleepy.contentmod.block.ModBlocks;
import omegasleepy.contentmod.item.ModItems;
import omegasleepy.contentmod.villager.ModVillagers;

public class ModCustomTrades {

    public static void botanist() {
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
                    for(var that: ModBlocks.flowers){
                        factories.add((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 4),
                                new ItemStack(that, 4),
                                16,
                                10,
                                0.05f
                        ));
                    }
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.BOTANIC, 2,
                factories -> {
                    for(var that: ModBlocks.flowers){
                        factories.add((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 8),
                                new ItemStack(that, 16),
                                7,
                                10,
                                0.25f
                        ));
                    }
                });
    }


    public static void registerCustomTrades() {
        botanist();

    }

}
