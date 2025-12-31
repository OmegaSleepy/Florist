package omegasleepy.contentmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.ContentMod;
import omegasleepy.contentmod.block.custom.SimpleFlower;
import omegasleepy.contentmod.block.custom.SimpleFlowerBed;
import omegasleepy.contentmod.block.custom.SimpleTallFlower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {

    public static List<Block> oneTallFlowers = new ArrayList<>();
    public static List<Block> twoTallFlowers = new ArrayList<>();
    public static List<Block> flowerbeds = new ArrayList<>();
    public static Map<Block, Block> flowersAndPots = new HashMap<>();
    public static List<Block> flowerPots = new ArrayList<>();

    public static final Block ORCHID = registerBlock("orchid",
            new SimpleFlower(StatusEffects.FIRE_RESISTANCE, 100, MapColor.PALE_PURPLE));

    public static final Block POTTED_ORCHID = registerFlowerPot(ORCHID, "orchid");

    public static final Block CHRYSANTHEMUM = registerBlock("chrysanthemum",
            new SimpleFlower(StatusEffects.FIRE_RESISTANCE, 100, MapColor.YELLOW));

    public static final Block POTTED_CHRYSANTHEMUM = registerFlowerPot(CHRYSANTHEMUM, "chrysanthemum");

    public static final Block AMARYLLIS = registerBlock("amaryllis",
            new SimpleFlower(StatusEffects.FIRE_RESISTANCE, 100, MapColor.DARK_RED));

    public static final Block POTTED_AMARYLLIS = registerFlowerPot(AMARYLLIS, "amaryllis");

    public static final Block EVY = registerBlock("evy",
            new SimpleFlowerBed(MapColor.DARK_GREEN));

    public static final Block RED_GINGER = registerBlock("red_ginger",
            new SimpleTallFlower(MapColor.RED));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ContentMod.MOD_ID, name), block);
    }

    private static Block registerFlowerPot(Block flower, String flowerName) {
        var result = Registry.register(Registries.BLOCK,
                new Identifier(ContentMod.MOD_ID, "potted_" +  flowerName),
                new FlowerPotBlock(flower, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
        flowerPots.add(result);
        flowersAndPots.put(flower, result);
        return result;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(ContentMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ContentMod.LOGGER.info("Registering Mod Blocks for %s".formatted(ContentMod.MOD_ID));
    }
}
