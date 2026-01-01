package omegasleepy.contentmod.block.flower;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import omegasleepy.contentmod.block.ModBlocks;

public class SimpleFlower extends FlowerBlock {

    private final Item dye;

    public SimpleFlower (StatusEffect suspiciousStewEffect, int effectDuration, MapColor mapColor, Item dye) {
        super(suspiciousStewEffect, effectDuration,
                AbstractBlock.Settings.create()
                        .mapColor(mapColor)
                        .noCollision()
                        .breakInstantly()
                        .sounds(BlockSoundGroup.GRASS)
                        .offset(AbstractBlock.OffsetType.XZ)
                        .pistonBehavior(PistonBehavior.DESTROY));
        ModBlocks.oneTallFlowers.add(this);
        ModBlocks.flowers.add(this);
        this.dye = dye;
    }

    public Item getDye () {
        return dye;
    }
}
