package omegasleepy.contentmod.util;

import net.minecraft.block.ComposterBlock;
import omegasleepy.contentmod.MainLogic;
import omegasleepy.contentmod.block.ModBlocks;

public class ModCompostable {

    public static void registerCompostable(){

        MainLogic.LOGGER.info("Registering Compostable Items for {}}", MainLogic.MOD_ID);

        for (var that: ModBlocks.oneTallFlowers){
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(that.asItem(), 0.65F);
        }

        for (var that: ModBlocks.flowerbeds){
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(that.asItem(), 0.35F);
        }

        for (var that: ModBlocks.twoTallFlowers){
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(that.asItem(), 0.7F);
        }

        for(var that: ModBlocks.lilies){
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(that.asItem(), 0.65F);
        }

    }
}
