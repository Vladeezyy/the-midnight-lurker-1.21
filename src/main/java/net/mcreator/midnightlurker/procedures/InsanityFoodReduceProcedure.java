package net.mcreator.midnightlurker.procedures;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

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
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7
					&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage > 0) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage - 1;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityStage = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7
					&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage > 2) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage - 3;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityStage = _setval;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7
					&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage > 1) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage - 2;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityStage = _setval;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7
					&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage > 0) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage - 1;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityStage = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.GOLDEN_CARROT) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 2200) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer - 2000;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.CARROT || itemstack.getItem() == Items.BREAD) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 400) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer - 200;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.BAKED_POTATO || itemstack.getItem() == Items.POTATO) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 300) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer - 100;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.PUMPKIN_PIE) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 1800) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer - 1600;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.BEETROOT_SOUP || itemstack.getItem() == Items.MUSHROOM_STEW || itemstack.getItem() == Items.RABBIT_STEW) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 1800) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer - 1600;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.GLOW_BERRIES || itemstack.getItem() == Items.SWEET_BERRIES || itemstack.getItem() == Items.MELON_SLICE || itemstack.getItem() == Items.DRIED_KELP || itemstack.getItem() == Items.BEETROOT) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 300) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer - 100;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.APPLE) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 4200) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer - 4000;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (itemstack.getItem() == Items.PUFFERFISH) {
			{
				double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer + 2000;
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.InsanityTimer = _setval;
				_vars.syncPlayerVariables(entity);
			}
		} else if (itemstack.getItem() == Items.ROTTEN_FLESH || itemstack.getItem() == Items.SPIDER_EYE) {
			{
				double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer + 1000;
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.InsanityTimer = _setval;
				_vars.syncPlayerVariables(entity);
			}
		} else if (itemstack.getItem() == Items.POISONOUS_POTATO) {
			{
				double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer + 1500;
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.InsanityTimer = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
