package net.mcreator.midnightlurker.procedures;

import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.Comparator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class MidnightLurkerCreepOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double spawnx = 0;
		double spawnz = 0;
		double spawny = 0;
		double yaw = 0;
		double yawlurker = 0;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty()) {
			spawnx = ((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() + Mth.nextInt(RandomSource.create(), -10, 10);
			spawnz = ((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ() + Mth.nextInt(RandomSource.create(), -10, 10);
		}
		if (world.isEmptyBlock(BlockPos.containing(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 0, spawnz))
				&& world.isEmptyBlock(BlockPos.containing(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 2, spawnz))
				&& world.isEmptyBlock(BlockPos.containing(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 3, spawnz))
				&& !world.isEmptyBlock(BlockPos.containing(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) - 1, spawnz))) {
			if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty() && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty())) {
				if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MobEffects.INVISIBILITY)) {
					{
						Entity _ent = entity;
						_ent.teleportTo(spawnx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz)), spawnz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(spawnx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz)), spawnz, _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MobEffects.INVISIBILITY)) {
			if (entity.getPersistentData().getDoubleOr("Disalol", 0) < 2) {
				entity.getPersistentData().putDouble("Disalol", (entity.getPersistentData().getDoubleOr("Disalol", 0) + 1));
			}
			if (entity.getPersistentData().getDoubleOr("Disalol", 0) == 1) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerdisappear neutral @a ~ ~ ~ 1 1");
				if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).isEmpty()) {
					if (Math.random() > 0.7) {
						if (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.STATIC_EFFECT, 46, 0, false, false));
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.INVISIBILITY) ? _livEnt.getEffect(MobEffects.INVISIBILITY).getDuration() : 0) == 1) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerdisappear neutral @a ~ ~ ~ 1 1");
			}
		}
		if (!(entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(MobEffects.INVISIBILITY))) {
			if (entity.getPersistentData().getDoubleOr("Disalol", 0) > 0) {
				entity.getPersistentData().putDouble("Disalol", 0);
			}
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty() && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty())) {
			if (entity.getPersistentData().getBooleanOr("InvisLogic", false) == false) {
				if ((new Object() {
					public Entity func(Entity player, double entityReach) {
						double distance = entityReach * entityReach;
						Vec3 eyePos = player.getEyePosition(1.0f);
						HitResult hitResult = entity.pick(entityReach, 1.0f, false);
						if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
							distance = hitResult.getLocation().distanceToSqr(eyePos);
							double blockReach = 5;
							if (distance > blockReach * blockReach) {
								Vec3 pos = hitResult.getLocation();
								hitResult = BlockHitResult.miss(pos, Direction.getApproximateNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
							}
						}
						Vec3 viewVec = player.getViewVector(1.0F);
						Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
						AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
						EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
							return !p_234237_.isSpectator();
						}, distance);
						if (entityhitresult != null) {
							Entity entity1 = entityhitresult.getEntity();
							Vec3 targetPos = entityhitresult.getLocation();
							double distanceToTarget = eyePos.distanceToSqr(targetPos);
							if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
								hitResult = BlockHitResult.miss(targetPos, Direction.getApproximateNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
							} else if (distanceToTarget < distance) {
								hitResult = entityhitresult;
							}
						}
						if (hitResult.getType() == HitResult.Type.ENTITY) {
							return ((EntityHitResult) hitResult).getEntity();
						}
						return null;
					}
				}.func(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)), 300)) instanceof MidnightLurkerCreepEntity) {
					if (entity instanceof MidnightLurkerCreepEntity) {
						((MidnightLurkerCreepEntity) entity).setAnimation("releport1122");
					}
					MidnightlurkerMod.queueServerWork(13, () -> {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 25, 0, false, false));
					});
				}
			}
		}
		if (entity.getPersistentData().getDoubleOr("CreepDespawn", 0) >= 3) {
			if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 4, 4, 4), e -> true).isEmpty()) {
				if (entity.getPersistentData().getDoubleOr("SoundActivate", 0) < 3 && !net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					entity.getPersistentData().putDouble("SoundActivate", (entity.getPersistentData().getDoubleOr("SoundActivate", 0) + 1));
				}
				if (entity.getPersistentData().getDoubleOr("SoundActivate", 0) == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					});
				}
				if (entity instanceof MidnightLurkerCreepEntity) {
					((MidnightLurkerCreepEntity) entity).setAnimation("teleport11");
				}
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
				});
			}
		}
		if (entity.getPersistentData().getDoubleOr("CreepDespawn", 0) <= 2) {
			if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 4, 4, 4), e -> true).isEmpty()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), EntitySpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(entity.getYRot());
						entityToSpawn.setYBodyRot(entity.getYRot());
						entityToSpawn.setYHeadRot(entity.getYRot());
						entityToSpawn.setXRot(entity.getXRot());
					}
				}
			}
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_DOT.get()), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			if (entity.getPersistentData().getDoubleOr("encount", 0) < 2) {
				entity.getPersistentData().putDouble("encount", (entity.getPersistentData().getDoubleOr("encount", 0) + 1));
			}
		}
		if (entity.getPersistentData().getDoubleOr("encount", 0) == 1) {
			if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
				if ((((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getData(MidnightlurkerModVariables.PLAYER_VARIABLES)).encounternumber < 6) {
					{
						double _setval = (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getData(MidnightlurkerModVariables.PLAYER_VARIABLES)).encounternumber + 1;
						MidnightlurkerModVariables.PlayerVariables _vars = ((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
						_vars.encounternumber = _setval;
						_vars.syncPlayerVariables(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)));
					}
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt87 && _livEnt87.hasEffect(MobEffects.INVISIBILITY)) {
			entity.getPersistentData().putBoolean("InvisLogic", true);
		} else if (!(entity instanceof LivingEntity _livEnt89 && _livEnt89.hasEffect(MobEffects.INVISIBILITY))) {
			entity.getPersistentData().putBoolean("InvisLogic", false);
		}
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("lurker_persist_during_day").getAsBoolean() == false) {
					if ((world instanceof Level _lvl94 && _lvl94.isBrightOutside()) == true && y > 60) {
						if (entity instanceof MidnightLurkerCreepEntity) {
							if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).isEmpty()) {
								MidnightlurkerMod.queueServerWork(2, () -> {
									if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 23, 23, 23), e -> true).isEmpty()) {
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
									if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 23, 23, 23), e -> true).isEmpty()) {
										if (!entity.level().isClientSide())
											entity.discard();
									}
								});
								if (entity instanceof MidnightLurkerCreepEntity) {
									((MidnightLurkerCreepEntity) entity).setAnimation("teleport11");
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
