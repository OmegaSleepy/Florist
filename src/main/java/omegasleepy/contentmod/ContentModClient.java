package omegasleepy.contentmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import omegasleepy.contentmod.block.ModBlocks;
import omegasleepy.contentmod.particle.GreenSparkleParticle;
import omegasleepy.contentmod.particle.ModParticles;

import java.util.List;

public class ContentModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient () {

        createCutOut(ModBlocks.flowers);
        createCutOut(ModBlocks.flowerPots);

        ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_SPARKLE, GreenSparkleParticle.Factory::new);

    }

    public static void createCutOut(List<Block> blocks){
        for(var that: blocks){
            BlockRenderLayerMap.INSTANCE.putBlock(that, RenderLayer.getCutout());
        }
    }


}
