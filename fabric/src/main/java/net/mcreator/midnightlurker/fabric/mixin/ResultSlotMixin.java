package net.mcreator.midnightlurker.fabric.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.item.ItemStack;

import net.mcreator.midnightlurker.port.bus.LurkerBus;
import net.mcreator.midnightlurker.port.bus.PlayerEvent;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** NeoForge's PlayerEvent.ItemCraftedEvent (fired where NeoForge fires it) */
@Mixin(ResultSlot.class)
abstract class ResultSlotMixin {
	@Shadow
	@Final
	private Player player;

	@Inject(method = "checkTakeAchievements", at = @At("HEAD"))
	private void midnightlurker$crafted(ItemStack stack, CallbackInfo ci) {
		LurkerBus.post(new PlayerEvent.ItemCraftedEvent(this.player, stack));
	}
}
