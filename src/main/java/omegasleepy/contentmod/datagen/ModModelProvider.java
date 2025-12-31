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
        generateFlowers(blockStateModelGenerator);

    }

    private static void generateFlowers (BlockStateModelGenerator blockStateModelGenerator) {
        for(var that: ModBlocks.flowersAndPots.keySet()) {
            blockStateModelGenerator.registerFlowerPotPlant(that, ModBlocks.flowersAndPots.get(that), BlockStateModelGenerator.TintType.NOT_TINTED);
        }

        for(var that: ModBlocks.twoTallFlowers) {
            blockStateModelGenerator.registerDoubleBlock(that, BlockStateModelGenerator.TintType.NOT_TINTED);
        }

        for(var that: ModBlocks.flowerbeds) {
            blockStateModelGenerator.registerFlowerbed(that);
        }
    }

    @Override
    public void generateItemModels (ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAGIC_BONEMEAL, Models.GENERATED);
    }
}
