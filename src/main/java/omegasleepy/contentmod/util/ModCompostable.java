package omegasleepy.contentmod.util;

import net.minecraft.block.ComposterBlock;
import omegasleepy.contentmod.block.ModBlocks;

public class ModCompostable {

    public static void registerCompostable(){

        for (var that: ModBlocks.oneTallFlowers){
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(that.asItem(), 0.65F);
        }

        for (var that: ModBlocks.twoTallFlowers){
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(that.asItem(), 0.7F);
        }

    }
}
