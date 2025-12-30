package omegasleepy.contentmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import omegasleepy.contentmod.util.ModTags;

public class MagicBoneMealItem extends Item {

    public MagicBoneMealItem (Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock (ItemUsageContext context) {
        World world = context.getWorld();
        Block blockClicked = world.getBlockState(context.getBlockPos()).getBlock();

        if(!world.isClient){
            assert context.getPlayer() != null;

            if(isValidBlock(blockClicked)) {
                context.getPlayer().giveItemStack(blockClicked.getPickStack(world,context.getBlockPos(),blockClicked.getDefaultState()));
                context.getPlayer().addExperience(5);
                context.getStack().decrement(1);
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            } else{
                return ActionResult.PASS;
            }

            context.getPlayer().getItemCooldownManager().set(this, 2);
        }


        return ActionResult.SUCCESS;
    }

    private boolean isValidBlock (Block blockClicked) {
        return blockClicked.getDefaultState().isIn(ModTags.Blocks.FLOWERS);
    }
}
