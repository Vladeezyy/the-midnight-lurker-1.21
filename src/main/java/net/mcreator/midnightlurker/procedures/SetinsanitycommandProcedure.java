package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class SetinsanitycommandProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			{
				double _setval = 0;
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.InsanityStage = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
