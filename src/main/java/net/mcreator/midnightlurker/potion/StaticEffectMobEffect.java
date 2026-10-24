
package net.mcreator.midnightlurker.potion;

import net.minecraft.server.level.ServerLevel;
import net.mcreator.midnightlurker.port.PortUtil;


import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.midnightlurker.procedures.StaticEffectOnEffectActiveTickProcedure;
import net.mcreator.midnightlurker.procedures.StaticEffectEffectExpiresProcedure;

public class StaticEffectMobEffect extends MobEffect implements PortUtil.EffectRemovedListener {
	public StaticEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -10066330);
	}

	@Override
	public String getDescriptionId() {
		return "effect.midnightlurker.static_effect";
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		StaticEffectOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(level, entity, amplifier);
	}

	@Override
	public void onEffectRemoved(LivingEntity entity, int amplifier) {
		StaticEffectEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

}
