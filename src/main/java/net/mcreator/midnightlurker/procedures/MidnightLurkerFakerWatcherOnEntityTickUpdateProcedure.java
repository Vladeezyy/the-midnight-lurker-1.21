package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;

import java.util.Comparator;

import java.io.File;

public class MidnightLurkerFakerWatcherOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		double raytrace_distance = 0;
		String found_entity_name = "";
		boolean entity_found = false;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (!entity.level().isClientSide())
				entity.discard();
			if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MidnightlurkerModVariables.PlayerVariables())).JumpscareActive < 1) {
				{
					double _setval = 1;
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.JumpscareActive = _setval;
						capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
					});
				}
			}
			if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7) {
				{
					double _setval = (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage + 1;
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityStage = _setval;
						capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
					});
				}
				{
					double _setval = 0;
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsanityTimer = _setval;
						capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
					});
				}
			}
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_DOT.get()), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 18, 18, 18), e -> true).isEmpty()) {
			if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 18, 18, 18), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY.get(), 55, 0, false, false));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
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
							hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
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
							hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
						} else if (distanceToTarget < distance) {
							hitResult = entityhitresult;
						}
					}
					if (hitResult.getType() == HitResult.Type.ENTITY) {
						return ((EntityHitResult) hitResult).getEntity();
					}
					return null;
				}
			}.func(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)), 20)) instanceof MidnightLurkerFakerWatcherEntity) {
				if (!entity.level().isClientSide())
					entity.discard();
				if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).JumpscareActive < 1) {
					{
						double _setval = 1;
						((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.JumpscareActive = _setval;
							capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)));
						});
					}
				}
				if (Math.random() > 0.5) {
					if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7) {
						{
							double _setval = (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage + 1;
							((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityStage = _setval;
								capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)));
							});
						}
						{
							double _setval = 0;
							((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityTimer = _setval;
								capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)));
							});
						}
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()) {
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
							hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
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
							hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
						} else if (distanceToTarget < distance) {
							hitResult = entityhitresult;
						}
					}
					if (hitResult.getType() == HitResult.Type.ENTITY) {
						return ((EntityHitResult) hitResult).getEntity();
					}
					return null;
				}
			}.func(entity, 80)) == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
				if (entity.getPersistentData().getDouble("CaveSoundLurk") < 300) {
					entity.getPersistentData().putDouble("CaveSoundLurk", (entity.getPersistentData().getDouble("CaveSoundLurk") + 1));
				}
				if (entity.getPersistentData().getDouble("CaveSoundLurk") == 299) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.6");
				}
			}
		}
	}
}
