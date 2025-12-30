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

    public static final ItemGroup PINK_GARNET_ITEM_GROUPS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() ->  new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.contentmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.PINK_GARNET);
                      entries.add(ModBlocks.PINK_GARNET_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        ContentMod.LOGGER.info("Registering Mod Item Groups for %s".formatted(ContentMod.MOD_ID));
    }
}
