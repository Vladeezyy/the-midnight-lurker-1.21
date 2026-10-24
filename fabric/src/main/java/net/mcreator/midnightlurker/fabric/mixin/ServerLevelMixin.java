package net.mcreator.midnightlurker.fabric.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.port.LurkerEntities;
import net.mcreator.midnightlurker.port.bus.EntityTickEvent;
import net.mcreator.midnightlurker.port.bus.LurkerBus;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** NeoForge's EntityTickEvent.Pre, for this mod's entities only (its only listener handles those) */
@Mixin(ServerLevel.class)
abstract class ServerLevelMixin {
	@Inject(method = "tickNonPassenger", at = @At("HEAD"))
	private void midnightlurker$entityTick(Entity entity, CallbackInfo ci) {
		if (LurkerEntities.ours(entity))
			LurkerBus.post(new EntityTickEvent.Pre(entity));
	}
}
