package omegasleepy.contentmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.MainLogic;
import omegasleepy.contentmod.block.blockEntities.PedestalBlock;
import omegasleepy.contentmod.block.flower.SimpleFlower;
import omegasleepy.contentmod.block.flower.SimpleFlowerBed;
import omegasleepy.contentmod.block.flower.SimpleLilyPad;
import omegasleepy.contentmod.block.flower.SimpleTallFlower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {

    public static List<Block> oneTallFlowers = new ArrayList<>();
    public static List<Block> twoTallFlowers = new ArrayList<>();
    public static List<Block> flowerbeds = new ArrayList<>();
    public static List<Block> lilies = new ArrayList<>();
    public static List<Block> flowers = new ArrayList<>();
    public static Map<Block, Block> flowersAndPots = new HashMap<>();
    public static List<Block> flowerPots = new ArrayList<>();

    /* ===== FLOWERS ===== */

    public static final Block ORCHID = registerFlower("orchid",
            new SimpleFlower(StatusEffects.FIRE_RESISTANCE, 100, MapColor.PALE_PURPLE, Items.MAGENTA_DYE));

    public static final Block CHRYSANTHEMUM = registerFlower("chrysanthemum",
            new SimpleFlower(StatusEffects.FIRE_RESISTANCE, 100, MapColor.YELLOW, Items.YELLOW_DYE));

    public static final Block AMARYLLIS = registerFlower("amaryllis",
            new SimpleFlower(StatusEffects.FIRE_RESISTANCE, 100, MapColor.DARK_RED, Items.RED_DYE));

    public static final Block VIOLET = registerFlower("violet",
            new SimpleFlower(StatusEffects.BLINDNESS, 100, MapColor.PURPLE, Items.PURPLE_DYE));

    public static final Block BLUEBELL = registerFlower("bluebell",
            new  SimpleFlower(StatusEffects.REGENERATION, 100, MapColor.TERRACOTTA_PURPLE, Items.BLUE_DYE));


    /* ===== LILIES ===== */

    public static final Block FLOWER_LILY = registerBlock("flower_lily", new SimpleLilyPad());


    /* ===== FLOWERBEDS ===== */

    public static final Block IVY = registerBlock("ivy",
            new SimpleFlowerBed(MapColor.DARK_GREEN, Items.GREEN_DYE));


    /* ===== TALL FLOWERS ===== */

    public static final Block RED_GINGER = registerBlock("red_ginger",
            new SimpleTallFlower(MapColor.RED, Items.RED_DYE));


    /* ===== OTHER ===== */

    public static final Block BANKOMAT = registerBlock("bank_terminal",
            new PedestalBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR)));

    /* ===== Utility ===== */

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MainLogic.MOD_ID, name), block);
    }

    private static Block registerFlower(String name, Block block) {
        registerBlockItem(name, block);
        flowersAndPots.put(block, registerFlowerPot(name, block));
        return Registry.register(Registries.BLOCK, Identifier.of(MainLogic.MOD_ID, name), block);
    }

    private static Block registerFlowerPot(String flowerName, Block flower) {
        var result = Registry.register(Registries.BLOCK,
                new Identifier(MainLogic.MOD_ID, "potted_" +  flowerName),
                new FlowerPotBlock(flower, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
        flowerPots.add(result);
        return result;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(MainLogic.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MainLogic.LOGGER.info("Registering Mod Blocks for {}}", MainLogic.MOD_ID);
    }

    public static List<List<Block>> getLists(){
        return List.of(oneTallFlowers, twoTallFlowers, flowerbeds);
    }
}
