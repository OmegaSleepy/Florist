package omegasleepy.contentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.MainLogic;
import omegasleepy.contentmod.block.ModBlocks;
import omegasleepy.contentmod.item.ModItems;

import static net.minecraft.data.client.BlockStateModelGenerator.createBlockStateWithRandomHorizontalRotations;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider (FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels (BlockStateModelGenerator blockStateModelGenerator) {
        generateFlowers(blockStateModelGenerator);
    }

    private static void generateFlowers (BlockStateModelGenerator blockModelGen) {
        for(var that: ModBlocks.flowersAndPots.keySet()) {
            blockModelGen.registerFlowerPotPlant(that, ModBlocks.flowersAndPots.get(that), BlockStateModelGenerator.TintType.NOT_TINTED);
        }

        for(var that: ModBlocks.twoTallFlowers) {
            blockModelGen.registerDoubleBlock(that, BlockStateModelGenerator.TintType.NOT_TINTED);
        }

        for(var that: ModBlocks.flowerbeds) {
            blockModelGen.registerFlowerbed(that);
        }

        MainLogic.LOGGER.info("Finished Generating Flowers and Flowerbed Blocks");
        MainLogic.LOGGER.info("ModBlocks.lilies dump{}", ModBlocks.lilies.toString());

        //check the BlockStateModelGenerator.registerLilypad for more of the logic, I don't get it either
        for(var that: ModBlocks.lilies) {
            MainLogic.LOGGER.info("Registering Lilies %s".formatted(that));
            blockModelGen.registerItemModel(that);

            blockModelGen.blockStateCollector.accept(createBlockStateWithRandomHorizontalRotations(that, ModelIds.getBlockModelId(that)));
        }

        //		this.registerItemModel(Blocks.LILY_PAD);
        //		this.blockStateCollector.accept(createBlockStateWithRandomHorizontalRotations(Blocks.LILY_PAD, ModelIds.getBlockModelId(Blocks.LILY_PAD)));

    }

    @Override
    public void generateItemModels (ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAGIC_BONEMEAL, Models.GENERATED);
    }
}
