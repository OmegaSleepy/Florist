package omegasleepy.contentmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.ContentMod;
import omegasleepy.contentmod.block.custom.MagicFlower;
import omegasleepy.contentmod.item.ModItems;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static List<Block> flowers = new ArrayList<>();

    public static final Block ORCHID = registerBlock("orchid",
            new MagicFlower(StatusEffects.FIRE_RESISTANCE, 100, MapColor.PALE_PURPLE));

    public static final Block POTTED_ORCHID = Registry.register(Registries.BLOCK,
            new Identifier(ContentMod.MOD_ID, "potted_orchid"),
            new FlowerPotBlock(ORCHID, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block CHRYSANTHEMUM = registerBlock("chrysanthemum",
            new MagicFlower(StatusEffects.FIRE_RESISTANCE, 100, MapColor.YELLOW));

    public static final Block POTTED_CHRYSANTHEMUM = Registry.register(Registries.BLOCK,
            new Identifier(ContentMod.MOD_ID, "potted_chrysanthemum"),
            new FlowerPotBlock(CHRYSANTHEMUM, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block AMARYLLIS = registerBlock("amaryllis",
            new MagicFlower(StatusEffects.FIRE_RESISTANCE, 100, MapColor.DARK_RED));

    public static final Block POTTED_AMARYLLIS = Registry.register(Registries.BLOCK,
            new Identifier(ContentMod.MOD_ID, "potted_amaryllis"),
            new FlowerPotBlock(AMARYLLIS, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));





















    //end

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ContentMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(ContentMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ContentMod.LOGGER.info("Registering Mod Blocks for %s".formatted(ContentMod.MOD_ID));
    }
}
