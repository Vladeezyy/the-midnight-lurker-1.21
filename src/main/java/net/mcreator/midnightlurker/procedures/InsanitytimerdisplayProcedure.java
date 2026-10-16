package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class InsanitytimerdisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("####").format((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer) + "";
	}
}
