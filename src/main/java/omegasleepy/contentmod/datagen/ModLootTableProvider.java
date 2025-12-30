package omegasleepy.contentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import omegasleepy.contentmod.block.ModBlocks;
import omegasleepy.contentmod.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider (FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate () {
        addDrop(ModBlocks.ORCHID);
        addDrop(ModBlocks.CHRYSANTHEMUM);
    }
}
