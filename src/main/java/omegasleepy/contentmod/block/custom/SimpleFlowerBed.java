package omegasleepy.contentmod.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import omegasleepy.contentmod.block.ModBlocks;

public class SimpleFlowerBed extends FlowerbedBlock {
    public SimpleFlowerBed (MapColor mapColor) {
        super(AbstractBlock.Settings.create()
                .mapColor(mapColor)
                .noCollision()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
                .pistonBehavior(PistonBehavior.DESTROY));

        ModBlocks.oneTallFlowers.add(this);
        ModBlocks.flowerbeds.add(this);
    }

}
