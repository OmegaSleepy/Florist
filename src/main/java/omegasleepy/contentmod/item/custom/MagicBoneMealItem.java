package omegasleepy.contentmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import omegasleepy.contentmod.particle.ModParticles;
import omegasleepy.contentmod.util.ModTags;

public class MagicBoneMealItem extends Item {

    public MagicBoneMealItem (Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock (ItemUsageContext context) {
        World world = context.getWorld();
        Block blockClicked = world.getBlockState(context.getBlockPos()).getBlock();

        var x = context.getBlockPos().getX();
        var y = context.getBlockPos().getY();
        var z = context.getBlockPos().getZ();

        if(!world.isClient){
            assert context.getPlayer() != null;

            if(isValidBlock(blockClicked)) {
                context.getPlayer().addExperience(1);
                context.getStack().decrement(1);
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS, 1.0F, 1.0F);

                for (int i = 0; i < 2; i++) {
                    world.spawnEntity(
                            new ItemEntity(
                                    world,
                                    x+0.5,y,z+0.5,
                                    blockClicked.getPickStack(world,context.getBlockPos(),blockClicked.getDefaultState())));
                }
                for (int i = 0; i < 300; i++) {((ServerWorld) world).spawnParticles(
                        ModParticles.GREEN_SPARKLE,
                        x + 0.5,
                        y + 2,
                        z + 0.5,
                        1, 0, 1, 0, 0.01
                );}

            } else{
                return ActionResult.FAIL;
            }

        }


        return ActionResult.SUCCESS;
    }


    private boolean isValidBlock (Block blockClicked) {
        return blockClicked.getDefaultState().isIn(ModTags.Blocks.FLOWERS) ||
                blockClicked.getDefaultState().isIn(BlockTags.FLOWERS) ||
                blockClicked.getDefaultState().isIn(BlockTags.TALL_FLOWERS);
    }
}
