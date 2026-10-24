
package net.mcreator.midnightlurker.potion;


import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class InsanityShowinInvMobEffect extends MobEffect {
	public InsanityShowinInvMobEffect() {
		super(MobEffectCategory.HARMFUL, -12708839);
	}

	@Override
	public String getDescriptionId() {
		return "effect.midnightlurker.insanity_showin_inv";
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

}
