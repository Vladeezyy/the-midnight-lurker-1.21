package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.mcreator.midnightlurker.entity.Destroytex3Entity;
import net.mcreator.midnightlurker.entity.Destroytex2Entity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class DestroytexOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double getblockx = 0;
		double getblocky = 0;
		double getblockz = 0;
		BlockState blockz = Blocks.AIR.defaultBlockState();
		BlockState blocky = Blocks.AIR.defaultBlockState();
		BlockState blockx = Blocks.AIR.defaultBlockState();
		MidnightlurkerMod.queueServerWork(20, () -> {
			if (!world.getEntitiesOfClass(DestroytexEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty() || !world.getEntitiesOfClass(Destroytex2Entity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()
					|| !world.getEntitiesOfClass(Destroytex3Entity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()
					|| !world.getEntitiesOfClass(Destroytex4Entity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		});
	}
}
