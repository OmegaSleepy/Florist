package omegasleepy.contentmod.behavior;

import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import omegasleepy.contentmod.particle.ModParticles;
import omegasleepy.contentmod.util.ModTags;

public class CloneBoneMealBehavior extends ItemDispenserBehavior {


    @Override
    protected ItemStack dispenseSilently (BlockPointer pointer, ItemStack stack) {
        World world = pointer.getWorld();

        BlockPos pos = pointer.getPos().offset(pointer.getBlockState().get(DispenserBlock.FACING));

        Block blockClicked = world.getBlockState(pos).getBlock();

        var x = pos.getX();
        var y = pos.getY();
        var z = pos.getZ();

        if(!world.isClient){

            if(isValidBlock(blockClicked)) {

                world.spawnEntity(new ExperienceOrbEntity(world, x, y, z, 1));

                stack.decrement(1);
                world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS, 1.0F, 1.0F);

                for (int i = 0; i < 2; i++) {
                    world.spawnEntity(
                            new ItemEntity(
                                    world,
                                    x+0.5,y,z+0.5,
                                    blockClicked.getPickStack(world,pos,blockClicked.getDefaultState())));
                }


                ((ServerWorld) world).spawnParticles(
                        ModParticles.GREEN_SPARKLE,
                        x + 0.5, y + 2, z + 0.5,
                        300,
                        0, 1, 0, 0.01
                );
            } else{
                return stack;
            }
        }


        return stack;
    }


    private boolean isValidBlock (Block blockClicked) {
        return blockClicked.getDefaultState().isIn(ModTags.Blocks.FLOWERS) ||
                blockClicked.getDefaultState().isIn(BlockTags.FLOWERS) ||
                blockClicked.getDefaultState().isIn(BlockTags.TALL_FLOWERS);
    }
}
