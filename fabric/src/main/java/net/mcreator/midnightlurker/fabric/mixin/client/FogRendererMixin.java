package net.mcreator.midnightlurker.fabric.mixin.client;

import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.world.level.material.FogType;

import net.mcreator.midnightlurker.port.bus.LurkerBus;
import net.mcreator.midnightlurker.port.bus.ViewportEvent;

import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** NeoForge's ViewportEvent.RenderFog (the environmental fog distances of the fog data vanilla returns) and ComputeFogColor */
@Mixin(FogRenderer.class)
abstract class FogRendererMixin {
	@Inject(method = "setupFog", at = @At("RETURN"))
	private void midnightlurker$renderFog(Camera camera, int renderDistance, DeltaTracker deltaTracker, float darkenWorld, ClientLevel level, CallbackInfoReturnable<FogData> cir) {
		if (!LurkerBus.hasListeners(ViewportEvent.RenderFog.class))
			return;
		FogData fogData = cir.getReturnValue();
		FogType fogType = camera.getFluidInCamera() == FogType.NONE ? FogType.ATMOSPHERIC : camera.getFluidInCamera();
		ViewportEvent.RenderFog event = new ViewportEvent.RenderFog(fogType, camera, deltaTracker.getGameTimeDeltaPartialTick(false), fogData.environmentalStart, fogData.environmentalEnd);
		LurkerBus.post(event);
		fogData.environmentalStart = event.getNearPlaneDistance();
		fogData.environmentalEnd = event.getFarPlaneDistance();
	}

	@Inject(method = "computeFogColor", at = @At("RETURN"))
	private void midnightlurker$fogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorld, Vector4f dest, CallbackInfo ci) {
		if (!LurkerBus.hasListeners(ViewportEvent.ComputeFogColor.class))
			return;
		ViewportEvent.ComputeFogColor event = new ViewportEvent.ComputeFogColor(camera, partialTick, dest.x, dest.y, dest.z);
		LurkerBus.post(event);
		dest.set(event.getRed(), event.getGreen(), event.getBlue(), dest.w);
	}
}
