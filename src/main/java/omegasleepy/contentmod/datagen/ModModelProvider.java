package omegasleepy.contentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import omegasleepy.contentmod.block.ModBlocks;
import omegasleepy.contentmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider (FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels (BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ORCHID, ModBlocks.POTTED_ORCHID, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CHRYSANTHEMUM, ModBlocks.POTTED_CHRYSANTHEMUM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.AMARYLLIS, ModBlocks.POTTED_AMARYLLIS, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels (ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAGIC_BONEMEAL, Models.GENERATED);
    }
}
