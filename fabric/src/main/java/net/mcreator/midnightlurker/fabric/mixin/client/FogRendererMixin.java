package net.mcreator.midnightlurker.fabric.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;

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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * NeoForge's ViewportEvent.RenderFog (the environmental fog distances, where NeoForge fires it: before the fog buffer is
 * written) and ComputeFogColor (the colour vanilla computed)
 */
@Mixin(FogRenderer.class)
abstract class FogRendererMixin {
	@Inject(method = "setupFog", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;getDevice()Lcom/mojang/blaze3d/systems/GpuDevice;"))
	private void midnightlurker$renderFog(Camera camera, int renderDistance, DeltaTracker deltaTracker, float darkenWorld, ClientLevel level, CallbackInfoReturnable<Vector4f> cir,
			@Local FogData fogData, @Local FogType fogType) {
		if (!LurkerBus.hasListeners(ViewportEvent.RenderFog.class))
			return;
		ViewportEvent.RenderFog event = new ViewportEvent.RenderFog(fogType, camera, deltaTracker.getGameTimeDeltaPartialTick(false), fogData.environmentalStart, fogData.environmentalEnd);
		LurkerBus.post(event);
		fogData.environmentalStart = event.getNearPlaneDistance();
		fogData.environmentalEnd = event.getFarPlaneDistance();
	}

	@Inject(method = "computeFogColor", at = @At("RETURN"))
	private void midnightlurker$fogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorld, CallbackInfoReturnable<Vector4f> cir) {
		if (!LurkerBus.hasListeners(ViewportEvent.ComputeFogColor.class))
			return;
		Vector4f color = cir.getReturnValue();
		ViewportEvent.ComputeFogColor event = new ViewportEvent.ComputeFogColor(camera, partialTick, color.x, color.y, color.z);
		LurkerBus.post(event);
		color.set(event.getRed(), event.getGreen(), event.getBlue(), color.w);
	}
}
