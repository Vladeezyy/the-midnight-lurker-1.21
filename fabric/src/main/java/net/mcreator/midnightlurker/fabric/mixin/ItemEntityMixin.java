package net.mcreator.midnightlurker.fabric.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;

import net.mcreator.midnightlurker.port.bus.ItemEntityPickupEvent;
import net.mcreator.midnightlurker.port.bus.LurkerBus;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** NeoForge's ItemEntityPickupEvent.Pre (server) */
@Mixin(ItemEntity.class)
abstract class ItemEntityMixin {
	@Inject(method = "playerTouch", at = @At("HEAD"))
	private void midnightlurker$pickup(Player player, CallbackInfo ci) {
		ItemEntity self = (ItemEntity) (Object) this;
		if (!self.level().isClientSide)
			LurkerBus.post(new ItemEntityPickupEvent.Pre(player, self));
	}
}
