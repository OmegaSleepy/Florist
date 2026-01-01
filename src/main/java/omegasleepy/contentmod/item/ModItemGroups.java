package omegasleepy.contentmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.MainLogic;
import omegasleepy.contentmod.block.ModBlocks;

import java.util.ArrayList;
import java.util.List;

public class ModItemGroups {

    public static final ItemGroup MARTINICA = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MainLogic.MOD_ID, "martinica"),
            FabricItemGroup.builder().icon(() ->  new ItemStack(ModItems.MAGIC_BONEMEAL))
                    .displayName(Text.translatable("itemgroup.contentmod.martinica"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.MAGIC_BONEMEAL);
                      entries.addAll(getBlocks(ModBlocks.flowers));
                    }).build());


    public static void registerItemGroups() {
        MainLogic.LOGGER.info("Registering Mod Item Groups for %s".formatted(MainLogic.MOD_ID));
    }

    private static List<ItemStack> getBlocks(List<Block> blocks) {
        List<ItemStack> itemStacks = new ArrayList<>();
        for (Block block : blocks) {
            itemStacks.add(new ItemStack(block));
        }
        return itemStacks;
    }

    private static List<ItemStack> getItems(List<Item> items) {
        List<ItemStack> itemStacks = new ArrayList<>();
        for (Item item : items) {
            items.add(item.asItem());
        }
        return itemStacks;
    }
}
