package omegasleepy.contentmod.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import omegasleepy.contentmod.block.ModBlocks;

public class SimpleTallFlower extends TallFlowerBlock {

    public SimpleTallFlower (MapColor mapColor) {
        super(AbstractBlock.Settings.create()
                .mapColor(mapColor)
                .noCollision()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XZ)
                .pistonBehavior(PistonBehavior.DESTROY));
        ModBlocks.twoTallFlowers.add(this);
    }
}
