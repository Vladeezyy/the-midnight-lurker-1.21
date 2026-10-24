package net.mcreator.midnightlurker.procedures;

import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.mcreator.midnightlurker.port.bus.ICancellableEvent;

import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.bus.FMLPaths;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.LivingIncomingDamageEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@EventBusSubscriber
public class MidnightLurkerRuntrueEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("lurker_invulnerable").getAsBoolean() == true) {
					if ((entity instanceof MidnightLurkerAggressiveEntity || entity instanceof MidnightLurkerBackturnedEntity || entity instanceof MidnightLurkerHiderEntity || entity instanceof MidnightLurkerRuntrueEntity
							|| entity instanceof MidnightLurkerSeenAngressiveEntity || entity instanceof MidnightLurkerStalkingEntity || entity instanceof MidnightLurkerUnprovokedEntity || entity instanceof MidnightlurkerNEEntity)
							&& sourceentity instanceof Player) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
					}
				} else if (mainjsonobject.get("lurker_invulnerable").getAsBoolean() == false) {
					if ((entity instanceof MidnightLurkerUnprovokedEntity || entity instanceof MidnightlurkerNEEntity) && sourceentity instanceof Player) {
						if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getBooleanOr("Stunned", false) == false) {
							net.mcreator.midnightlurker.port.PortUtil.data(entity).putBoolean("Stunned", true);
						}
						if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("StunTimer", 0) > 0) {
							if (event instanceof ICancellableEvent _cancellable) {
								_cancellable.setCanceled(true);
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (entity instanceof MidnightLurkerRuntrueEntity && sourceentity instanceof Player) {
			if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).isEmpty()) {
				MidnightlurkerMod.queueServerWork(2, () -> {
					if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRuntrueEntity.class, AABB.ofSize(new Vec3(x, y, z), 23, 23, 23), e -> true).isEmpty()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				});
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRuntrueEntity.class, AABB.ofSize(new Vec3(x, y, z), 23, 23, 23), e -> true).isEmpty()) {
						if (!entity.level().isClientSide())
							entity.discard();
					}
				});
				if (entity instanceof MidnightLurkerRuntrueEntity) {
					((MidnightLurkerRuntrueEntity) entity).setAnimation("teleport6");
				}
				if (Math.random() > 0.5) {
					MidnightlurkerMod.queueServerWork(30, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/playsound midnightlurker:lurker_taunt neutral @a ~ ~ ~ 0.5 1");
					});
				}
			}
			for (int index0 = 0; index0 < 50; index0++) {
				world.addParticle((SimpleParticleType) (MidnightlurkerModParticleTypes.LURKERFACEPARTICLE.get()), (x + Mth.nextDouble(RandomSource.create(), -6, 6)), (y + Mth.nextDouble(RandomSource.create(), 0, 6)),
						(z + Mth.nextDouble(RandomSource.create(), -6, 6)), 0, 0, 0);
			}
		}
	}
}
