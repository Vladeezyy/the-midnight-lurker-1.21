package net.mcreator.midnightlurker.fabric.mixin;

import net.minecraft.world.entity.player.Player;

import net.mcreator.midnightlurker.port.bus.LurkerBus;
import net.mcreator.midnightlurker.port.bus.PlayerTickEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** NeoForge's PlayerTickEvent.Post (both sides) */
@Mixin(Player.class)
abstract class PlayerMixin {
	@Inject(method = "tick", at = @At("TAIL"))
	private void midnightlurker$tick(CallbackInfo ci) {
		LurkerBus.post(new PlayerTickEvent.Post((Player) (Object) this));
	}
}
