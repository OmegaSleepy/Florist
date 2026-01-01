package omegasleepy.contentmod.block.flower;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import omegasleepy.contentmod.block.ModBlocks;

public class SimpleTallFlower extends TallFlowerBlock {

    private final Item dye;

    public SimpleTallFlower (MapColor mapColor, Item dye) {
        super(AbstractBlock.Settings.create()
                .mapColor(mapColor)
                .noCollision()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
                .pistonBehavior(PistonBehavior.DESTROY));
        ModBlocks.twoTallFlowers.add(this);
        ModBlocks.flowers.add(this);
        this.dye = dye;
    }

    public Item getDye () {
        return dye;
    }
}
