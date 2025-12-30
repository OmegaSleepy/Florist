package omegasleepy.contentmod.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.sound.BlockSoundGroup;
import omegasleepy.contentmod.block.ModBlocks;

public class MagicFlower extends FlowerBlock {
    public MagicFlower (StatusEffect suspiciousStewEffect, int effectDuration, MapColor mapColor) {
        super(suspiciousStewEffect, effectDuration,
                AbstractBlock.Settings.create()
                        .mapColor(mapColor)
                        .noCollision()
                        .breakInstantly()
                        .sounds(BlockSoundGroup.GRASS)
                        .offset(AbstractBlock.OffsetType.XZ)
                        .pistonBehavior(PistonBehavior.DESTROY));
        ModBlocks.flowers.add(this);
    }
}
