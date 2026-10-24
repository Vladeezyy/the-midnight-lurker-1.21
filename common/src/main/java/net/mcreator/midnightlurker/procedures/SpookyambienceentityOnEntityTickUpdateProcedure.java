package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.io.File;

public class SpookyambienceentityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		MidnightlurkerMod.queueServerWork(2, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
