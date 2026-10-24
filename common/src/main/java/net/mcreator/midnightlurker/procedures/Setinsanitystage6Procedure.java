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
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.InsanityStage = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
