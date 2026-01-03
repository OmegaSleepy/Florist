package omegasleepy.contentmod.mixin;

import net.minecraft.entity.player.PlayerEntity;
import omegasleepy.contentmod.MainLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class ExampleMixin {

	@Shadow
	protected abstract void dropInventory ();

	@Shadow
	public abstract float getMovementSpeed ();

	@Inject(method = "jump", at = @At("HEAD"))
	private void jump(CallbackInfo ci) {
		if(getMovementSpeed() > 0.11){
			dropInventory();
		}

        MainLogic.LOGGER.info("THE PLAYER JUMPED {}", getMovementSpeed());
	}

}