package net.mcreator.midnightlurker.fabric.mixin.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.port.LurkerEntities;
import net.mcreator.midnightlurker.port.bus.EntityTickEvent;
import net.mcreator.midnightlurker.port.bus.LurkerBus;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** NeoForge's EntityTickEvent.Pre on the client, for this mod's entities only */
@Mixin(ClientLevel.class)
abstract class ClientLevelMixin {
	@Inject(method = "tickNonPassenger", at = @At("HEAD"))
	private void midnightlurker$entityTick(Entity entity, CallbackInfo ci) {
		if (LurkerEntities.ours(entity))
			LurkerBus.post(new EntityTickEvent.Pre(entity));
	}
}
