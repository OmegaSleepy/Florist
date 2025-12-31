package omegasleepy.contentmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import omegasleepy.contentmod.block.ModBlocks;

import java.util.List;

public class ContentModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient () {

        createCutOut(ModBlocks.oneTallFlowers);
        createCutOut(ModBlocks.flowerPots);
        createCutOut(ModBlocks.twoTallFlowers);
        createCutOut(ModBlocks.flowerbeds);

    }

    public static void createCutOut(List<Block> blocks){
        for(var that: blocks){
            BlockRenderLayerMap.INSTANCE.putBlock(that, RenderLayer.getCutout());
        }
    }


}
