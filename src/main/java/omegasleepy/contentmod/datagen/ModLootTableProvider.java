package omegasleepy.contentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import omegasleepy.contentmod.block.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider (FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate () {
        for(var that: ModBlocks.flowers) {
            addDrop(that);
        }
    }

}
