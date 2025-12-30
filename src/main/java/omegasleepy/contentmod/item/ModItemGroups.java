package omegasleepy.contentmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.ContentMod;
import omegasleepy.contentmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup MARTINICA = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentMod.MOD_ID, "martinica"),
            FabricItemGroup.builder().icon(() ->  new ItemStack(ModItems.MAGIC_BONEMEAL))
                    .displayName(Text.translatable("itemgroup.contentmod.martinica"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.MAGIC_BONEMEAL);
                      entries.add(ModBlocks.ORCHID);
                      entries.add(ModBlocks.CHRYSANTHEMUM);
                    }).build());

    public static void registerItemGroups() {
        ContentMod.LOGGER.info("Registering Mod Item Groups for %s".formatted(ContentMod.MOD_ID));
    }
}
