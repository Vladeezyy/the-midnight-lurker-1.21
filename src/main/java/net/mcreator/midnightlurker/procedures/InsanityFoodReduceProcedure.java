package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import javax.annotation.Nullable;

import java.io.File;

@Mod.EventBusSubscriber
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
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7
					&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage > 0) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage - 1;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityStage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (itemstack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7
					&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage > 2) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage - 3;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityStage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7
					&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage > 1) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage - 2;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityStage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7
					&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage > 0) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage - 1;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityStage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (itemstack.getItem() == Items.GOLDEN_CARROT) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 2200) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer - 2000;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (itemstack.getItem() == Items.CARROT || itemstack.getItem() == Items.BREAD) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 400) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer - 200;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (itemstack.getItem() == Items.BAKED_POTATO || itemstack.getItem() == Items.POTATO) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 300) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer - 100;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (itemstack.getItem() == Items.PUMPKIN_PIE) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 1800) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer - 1600;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (itemstack.getItem() == Items.BEETROOT_SOUP || itemstack.getItem() == Items.MUSHROOM_STEW || itemstack.getItem() == Items.RABBIT_STEW) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 1800) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer - 1600;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (itemstack.getItem() == Items.GLOW_BERRIES || itemstack.getItem() == Items.SWEET_BERRIES || itemstack.getItem() == Items.MELON_SLICE || itemstack.getItem() == Items.DRIED_KELP || itemstack.getItem() == Items.BEETROOT) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 300) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer - 100;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (itemstack.getItem() == Items.APPLE) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 4200) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer - 4000;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (itemstack.getItem() == Items.PUFFERFISH) {
			{
				double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer + 2000;
				entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InsanityTimer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (itemstack.getItem() == Items.ROTTEN_FLESH || itemstack.getItem() == Items.SPIDER_EYE) {
			{
				double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer + 1000;
				entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InsanityTimer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (itemstack.getItem() == Items.POISONOUS_POTATO) {
			{
				double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer + 1500;
				entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InsanityTimer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
