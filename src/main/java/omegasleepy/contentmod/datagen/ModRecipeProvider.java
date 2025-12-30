package omegasleepy.contentmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import omegasleepy.contentmod.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider (FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate (Consumer<RecipeJsonProvider> consumer) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGIC_BONEMEAL, 8)
                .pattern("fff")
                .pattern("fbf")
                .pattern("fff")
                .input('f', ItemTags.FLOWERS)
                .input('b', Items.BONE_MEAL)
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(ModItems.MAGIC_BONEMEAL))
                .offerTo(consumer);
    }


}
