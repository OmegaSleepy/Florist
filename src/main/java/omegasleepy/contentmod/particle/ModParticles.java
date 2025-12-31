package omegasleepy.contentmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import omegasleepy.contentmod.ContentMod;

public class ModParticles {

    public static final DefaultParticleType GREEN_SPARKLE =
            createParticleType("green_sparkle_particle", FabricParticleTypes.simple(true));

    private static DefaultParticleType createParticleType (String particleName, DefaultParticleType defaultParticleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(ContentMod.MOD_ID, particleName), defaultParticleType);
    }


    public static void registerParticles() {
        ContentMod.LOGGER.info("Registering Particles for " + ContentMod.MOD_ID);
    }


}
