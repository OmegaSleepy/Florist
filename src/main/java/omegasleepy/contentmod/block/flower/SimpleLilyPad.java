package omegasleepy.contentmod.block.flower;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.LilyPadBlock;
import omegasleepy.contentmod.block.ModBlocks;

public class SimpleLilyPad extends LilyPadBlock {
    public SimpleLilyPad () {
        super(FabricBlockSettings.copyOf(Blocks.LILY_PAD));
        ModBlocks.lilies.add(this);
        ModBlocks.flowers.add(this);
    }

}
