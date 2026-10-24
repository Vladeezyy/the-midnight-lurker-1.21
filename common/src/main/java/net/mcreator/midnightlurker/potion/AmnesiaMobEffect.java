
package net.mcreator.midnightlurker.potion;


import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.midnightlurker.procedures.AmnesiaOnEffectActiveTickProcedure;

public class AmnesiaMobEffect extends MobEffect implements net.mcreator.midnightlurker.port.EffectVisibility {
	public AmnesiaMobEffect() {
		super(MobEffectCategory.HARMFUL, -12708839);
	}

	@Override
	public String getDescriptionId() {
		return "effect.midnightlurker.amnesia";
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		AmnesiaOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean isVisibleInInventory(MobEffectInstance effect) {
		return false;
	}


	@Override
	public boolean isVisibleInGui(MobEffectInstance effect) {
		return false;
	}
}
