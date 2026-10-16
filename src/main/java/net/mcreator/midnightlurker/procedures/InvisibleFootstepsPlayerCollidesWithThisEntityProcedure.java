package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

public class InvisibleFootstepsPlayerCollidesWithThisEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
