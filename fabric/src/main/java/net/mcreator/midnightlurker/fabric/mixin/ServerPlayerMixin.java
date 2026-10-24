package net.mcreator.midnightlurker.fabric.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

import net.mcreator.midnightlurker.port.bus.ItemTossEvent;
import net.mcreator.midnightlurker.port.bus.LurkerBus;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** NeoForge's ItemTossEvent (the server player creates the dropped item; 26.3: with a Prediction) */
@Mixin(ServerPlayer.class)
abstract class ServerPlayerMixin {
	@Inject(method = "drop(Lnet/minecraft/world/item/ItemStack;ZLnet/minecraft/util/Prediction;)Lnet/minecraft/world/entity/item/ItemEntity;", at = @At("RETURN"))
	private void midnightlurker$drop(ItemStack stack, boolean randomly, net.minecraft.util.Prediction prediction, CallbackInfoReturnable<ItemEntity> cir) {
		if (cir.getReturnValue() != null)
			LurkerBus.post(new ItemTossEvent(cir.getReturnValue(), (ServerPlayer) (Object) this));
	}
}
