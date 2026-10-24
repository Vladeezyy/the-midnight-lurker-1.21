package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.LivingEntityUseItemEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import javax.annotation.Nullable;

import java.io.File;

@EventBusSubscriber
public class InsanityFoodReduceProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		File lurker = new File("");
		if (itemstack.getItem() == Items.GOLDEN_APPLE) {
			if (MidnightlurkerModVariables.of(entity).InsanityStage < 7
					&& MidnightlurkerModVariables.of(entity).InsanityStage > 0) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityStage - 1;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityStage = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
			if (MidnightlurkerModVariables.of(entity).InsanityStage < 7
					&& MidnightlurkerModVariables.of(entity).InsanityStage > 2) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityStage - 3;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityStage = _setval;
					_vars.syncPlayerVariables(entity);
				}
			} else if (MidnightlurkerModVariables.of(entity).InsanityStage < 7
					&& MidnightlurkerModVariables.of(entity).InsanityStage > 1) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityStage - 2;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityStage = _setval;
					_vars.syncPlayerVariables(entity);
				}
			} else if (MidnightlurkerModVariables.of(entity).InsanityStage < 7
					&& MidnightlurkerModVariables.of(entity).InsanityStage > 0) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityStage - 1;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityStage = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.GOLDEN_CARROT) {
			if (MidnightlurkerModVariables.of(entity).InsanityTimer >= 2200) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer - 2000;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.CARROT || itemstack.getItem() == Items.BREAD) {
			if (MidnightlurkerModVariables.of(entity).InsanityTimer >= 400) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer - 200;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.BAKED_POTATO || itemstack.getItem() == Items.POTATO) {
			if (MidnightlurkerModVariables.of(entity).InsanityTimer >= 300) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer - 100;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.PUMPKIN_PIE) {
			if (MidnightlurkerModVariables.of(entity).InsanityTimer >= 1800) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer - 1600;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.BEETROOT_SOUP || itemstack.getItem() == Items.MUSHROOM_STEW || itemstack.getItem() == Items.RABBIT_STEW) {
			if (MidnightlurkerModVariables.of(entity).InsanityTimer >= 1800) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer - 1600;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.GLOW_BERRIES || itemstack.getItem() == Items.SWEET_BERRIES || itemstack.getItem() == Items.MELON_SLICE || itemstack.getItem() == Items.DRIED_KELP || itemstack.getItem() == Items.BEETROOT) {
			if (MidnightlurkerModVariables.of(entity).InsanityTimer >= 300) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer - 100;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.APPLE) {
			if (MidnightlurkerModVariables.of(entity).InsanityTimer >= 4200) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer - 4000;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.PUFFERFISH) {
			{
				double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer + 2000;
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.InsanityTimer = _setval;
				_vars.syncPlayerVariables(entity);
			}
		} else if (itemstack.getItem() == Items.ROTTEN_FLESH || itemstack.getItem() == Items.SPIDER_EYE) {
			{
				double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer + 1000;
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.InsanityTimer = _setval;
				_vars.syncPlayerVariables(entity);
			}
		} else if (itemstack.getItem() == Items.POISONOUS_POTATO) {
			{
				double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer + 1500;
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.InsanityTimer = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
