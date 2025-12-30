package omegasleepy.contentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelProvider;
import net.minecraft.data.client.Models;
import omegasleepy.contentmod.block.ModBlocks;
import omegasleepy.contentmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider (FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels (BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
    }

    @Override
    public void generateItemModels (ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAGIC_BONEMEAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
    }
}
