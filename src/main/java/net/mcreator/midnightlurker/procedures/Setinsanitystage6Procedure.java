package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class Setinsanitystage6Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			{
				double _setval = 6;
				entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InsanityStage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
