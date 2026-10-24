
package net.mcreator.midnightlurker.potion;

import net.minecraft.world.effect.MobEffectInstance;


import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AmnesiaShowInInvMobEffect extends MobEffect implements net.mcreator.midnightlurker.port.EffectVisibility {
	public AmnesiaShowInInvMobEffect() {
		super(MobEffectCategory.HARMFUL, -12708839);
	}

	@Override
	public String getDescriptionId() {
		return "effect.midnightlurker.amnesia_show_in_inv";
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean isVisibleInGui(MobEffectInstance effect) {
		return false;
	}
}
