package omegasleepy.contentmod.block.custom;

import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import omegasleepy.contentmod.block.ModBlocks;

public class MagicFlower extends FlowerBlock {
    public MagicFlower (StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
        ModBlocks.flowers.add(this);
    }
}
