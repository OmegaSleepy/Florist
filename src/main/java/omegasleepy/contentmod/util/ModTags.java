package omegasleepy.contentmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.ContentMod;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ContentMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> MAGIC_FLOWERS = createTag("magic_flowers");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ContentMod.MOD_ID, name));
        }
    }
}
