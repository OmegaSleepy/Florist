package omegasleepy.contentmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.MainLogic;
import omegasleepy.contentmod.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<ATMBlockEntity> ATM_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MainLogic.MOD_ID, "bank_terminal"),
                    FabricBlockEntityTypeBuilder.create(ATMBlockEntity::new,
                            ModBlocks.BANKOMAT).build());

    public static void init() {
        MainLogic.LOGGER.info("Registering Block Entities for {}", MainLogic.MOD_ID);
    }

}

