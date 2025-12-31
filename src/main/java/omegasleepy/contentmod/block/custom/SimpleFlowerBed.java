package omegasleepy.contentmod.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import omegasleepy.contentmod.block.ModBlocks;

public class SimpleFlowerBed extends FlowerbedBlock {

    private final Item dye;

    public SimpleFlowerBed (MapColor mapColor, Item dye) {
        super(AbstractBlock.Settings.create()
                .mapColor(mapColor)
                .noCollision()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
                .pistonBehavior(PistonBehavior.DESTROY));

        ModBlocks.flowerbeds.add(this);
        ModBlocks.flowers.add(this);
        this.dye = dye;
    }

    public Item getDye () {
        return dye;
    }
}
