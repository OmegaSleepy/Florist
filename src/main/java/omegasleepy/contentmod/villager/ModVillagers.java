package omegasleepy.contentmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import omegasleepy.contentmod.MainLogic;

public class ModVillagers {

    public static final RegistryKey<PointOfInterestType> BOTANIC_POI_KEY = registerPoiKey("botanic_poi");
    public static final PointOfInterestType BOTANIC_POI = registerPOI("botanic_poi", Blocks.FLOWER_POT);

    public static final VillagerProfession BOTANIC = registerProfession("botanic", BOTANIC_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(MainLogic.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(MainLogic.MOD_ID, name),
                1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(MainLogic.MOD_ID, name));
    }

    //TODO find out why the villager has a strange texture issues
    public static void registerVillagers(){
        MainLogic.LOGGER.info("Registering Villagers for " + MainLogic.MOD_ID);
    }

}
