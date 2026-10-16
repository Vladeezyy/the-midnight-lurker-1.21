package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class PlayerBlockingLurkernotinvulnerableProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainjsonobject.get("lurker_invulnerable").getAsBoolean() == false) {
					if (entity instanceof Player && (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerFakerEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerFakerAggroEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerFakerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerRuntrueEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerShadowEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerShadowEyesEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightlurkerNEEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())) {
						if (entity instanceof LivingEntity _livEnt ? _livEnt.isBlocking() : false) {
							if (entity instanceof Player _player)
								_player.getCooldowns().addCooldown(Items.SHIELD, 50);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
