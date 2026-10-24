package net.mcreator.midnightlurker.fabric.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.midnightlurker.port.EffectVisibility;
import net.mcreator.midnightlurker.port.bus.LurkerBus;
import net.mcreator.midnightlurker.port.bus.RenderGuiEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** NeoForge's RenderGuiEvent.Pre (before every HUD layer) and isVisibleInGui of the mod's effects */
@Mixin(Gui.class)
abstract class GuiMixin {
	@Inject(method = "extractRenderState", at = @At("HEAD"))
	private void midnightlurker$renderPre(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
		LurkerBus.post(new RenderGuiEvent.Pre(guiGraphics));
	}

	@ModifyExpressionValue(method = "extractEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/MobEffectInstance;showIcon()Z"))
	private boolean midnightlurker$visibleInGui(boolean showIcon, @Local MobEffectInstance instance) {
		return showIcon && !(instance.getEffect().value() instanceof EffectVisibility visibility && !visibility.isVisibleInGui(instance));
	}
}
