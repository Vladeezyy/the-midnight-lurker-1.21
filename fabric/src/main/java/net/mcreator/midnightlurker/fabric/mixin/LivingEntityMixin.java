package net.mcreator.midnightlurker.fabric.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import net.mcreator.midnightlurker.port.bus.LivingEntityUseItemEvent;
import net.mcreator.midnightlurker.port.bus.LurkerBus;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** NeoForge's LivingEntityUseItemEvent.Finish, with a copy of the stack before it was used up */
@Mixin(LivingEntity.class)
abstract class LivingEntityMixin {
	@Shadow
	protected ItemStack useItem;

	@Inject(method = "completeUsingItem", at = @At("HEAD"))
	private void midnightlurker$finishUsing(CallbackInfo ci) {
		LivingEntity self = (LivingEntity) (Object) this;
		if (!this.useItem.isEmpty() && self.isUsingItem())
			LurkerBus.post(new LivingEntityUseItemEvent.Finish(self, this.useItem.copy()));
	}
}
