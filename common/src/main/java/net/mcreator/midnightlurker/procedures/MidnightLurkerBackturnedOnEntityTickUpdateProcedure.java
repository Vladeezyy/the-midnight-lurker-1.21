package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.PortUtil;

import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.bus.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.Map;
import java.util.List;
import java.util.Comparator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class MidnightLurkerBackturnedOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double raytrace_distance = 0;
		String found_entity_name = "";
		boolean entity_found = false;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivation") <= 0 && !net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).isEmpty()) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("PlayerActivation", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivation") + 1));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanePotionTimer") == 1) {
			if (entity instanceof MidnightLurkerBackturnedEntity && !(entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()))) {
				if (entity instanceof MidnightLurkerBackturnedEntity) {
					((MidnightLurkerBackturnedEntity) entity).setAnimation("snapstare5");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY.holder(), 80, 0, false, false));
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivation") >= 1) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanePotionTimer") < 2) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanePotionTimer", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanePotionTimer") + 1));
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SlownessEffect") < 1 && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivation") >= 1
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) <= 1
				&& entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("SlownessEffect", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SlownessEffect") + 1));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SlownessEffect") <= 0 && !(entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()))
				&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivation") <= 0) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("SlownessEffect", 0);
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SlownessEffect") <= 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 255, false, false));
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(700, () -> {
				if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SoundActivate") < 3 && !net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("SoundActivate", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SoundActivate") + 1));
				}
				if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SoundActivate") == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					});
				}
				if (entity instanceof MidnightLurkerBackturnedEntity) {
					((MidnightLurkerBackturnedEntity) entity).setAnimation("teleport5");
				}
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
				});
			});
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SlownessEffect") <= 0 && entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
			entity.setShiftKeyDown(true);
		} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SlownessEffect") >= 1 && entity instanceof LivingEntity _livEnt53 && _livEnt53.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
			MidnightlurkerMod.queueServerWork(2, () -> {
				entity.setShiftKeyDown(false);
			});
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_DOT.get()), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 23, 23, 23), e -> true).isEmpty()) {
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
			}.func(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 23, 23, 23), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)), 23)) instanceof MidnightLurkerBackturnedEntity) {
				if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getBoolean("DespawnActivated") == false) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putBoolean("DespawnActivated", true);
				}
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getBoolean("DespawnActivated") == true) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("DespawnTimer") == 0) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("DespawnTimer", 700);
			} else {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("DespawnTimer", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("DespawnTimer") - 1));
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("DespawnTimer") == 1) {
			if (entity instanceof MidnightLurkerBackturnedEntity) {
				((MidnightLurkerBackturnedEntity) entity).setAnimation("teleport5");
			}
			MidnightlurkerMod.queueServerWork(2, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			});
			MidnightlurkerMod.queueServerWork(13, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && !(world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, ResourceLocation.parse("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.EAST) {
			entity.setDeltaMovement(new Vec3(0.2, 0.2, (entity.getDeltaMovement().z())));
		} else if (world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && !(world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, ResourceLocation.parse("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.WEST) {
			entity.setDeltaMovement(new Vec3((-0.2), 0.2, (entity.getDeltaMovement().z())));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && !(world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, ResourceLocation.parse("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.SOUTH) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.2, 0.2));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && !(world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, ResourceLocation.parse("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.NORTH) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.2, (-0.2)));
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()) {
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
			}.func(entity, 80)) == ((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
				if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CaveSoundLurk") < 300) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("CaveSoundLurk", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CaveSoundLurk") + 1));
				}
				if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CaveSoundLurk") == 299) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.7");
				}
			}
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("encount") < 2) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("encount", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("encount") + 1));
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("encount") == 1) {
			if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
				if ((MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)))).encounternumber < 6) {
					{
						double _setval = (MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)))).encounternumber + 1;
						MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)));
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
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(70 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator.isPassenger() && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 15, 15, 15), e -> true).isEmpty())) {
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS) {
								PortUtil.enchant((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY), Enchantments.DEPTH_STRIDER, 1);
							}
						} else {
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS
									&& PortUtil.enchantmentLevel((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY), Enchantments.DEPTH_STRIDER) != 0) {
								{
									EnchantmentHelper.updateEnchantments((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY), _ench -> _ench.removeIf(_e -> _e.is(Enchantments.DEPTH_STRIDER)));
								}
							}
						}
					}
				}
			}
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			if ((((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.IRON_HELMET
					|| (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.IRON_CHESTPLATE
					|| (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.IRON_LEGGINGS
					|| (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3, 0, false, false));
			} else if ((((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.DIAMOND_HELMET
					|| (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.DIAMOND_CHESTPLATE
					|| (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.DIAMOND_LEGGINGS
					|| (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.DIAMOND_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3, 1, false, false));
			} else if ((((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.NETHERITE_HELMET
					|| (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.NETHERITE_CHESTPLATE
					|| (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.NETHERITE_LEGGINGS
					|| (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.NETHERITE_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3, 2, false, false));
			}
			if ((((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.IRON_HELMET
					&& (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.IRON_CHESTPLATE
					&& (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.IRON_LEGGINGS
					&& (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3, 0, false, false));
			} else if ((((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.DIAMOND_HELMET
					&& (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.DIAMOND_CHESTPLATE
					&& (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.DIAMOND_LEGGINGS
					&& (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.DIAMOND_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3, 2, false, false));
			} else if ((((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.NETHERITE_HELMET
					&& (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.NETHERITE_CHESTPLATE
					&& (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.NETHERITE_LEGGINGS
					&& (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.NETHERITE_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3, 3, false, false));
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getBoolean("Stunned") == true) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") <= 0) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("StunTimer", 1);
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") > 0 && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") < 200) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("StunTimer", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") + 1));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") >= 200) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("StunTimer", 0);
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") >= 98) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getBoolean("Stunned") == true) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putBoolean("Stunned", false);
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") > 0 && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") < 98) {
			entity.setDeltaMovement(new Vec3(0, 0, 0));
			if (entity instanceof MidnightLurkerBackturnedEntity) {
				((MidnightLurkerBackturnedEntity) entity).setAnimation("stunned5");
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") == 2) {
			if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurker_stunned neutral @a ~ ~ ~ 1 1");
			}
			MidnightlurkerMod.queueServerWork(30, () -> {
				if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/playsound midnightlurker:lurker_taunt neutral @a ~ ~ ~ 0.7 1");
				}
			});
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("StunTimer") == 88) {
			if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurker_stun_over neutral @a ~ ~ ~ 1 1");
			}
		}
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("lurker_persist_during_day").getAsBoolean() == false) {
					if ((world instanceof Level _lvl266 && _lvl266.isDay()) == true && y > 60) {
						if (entity instanceof MidnightLurkerBackturnedEntity) {
							if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).isEmpty()) {
								MidnightlurkerMod.queueServerWork(2, () -> {
									if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 23, 23, 23), e -> true).isEmpty()) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
								});
								MidnightlurkerMod.queueServerWork(13, () -> {
									if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 23, 23, 23), e -> true).isEmpty()) {
										if (!entity.level().isClientSide())
											entity.discard();
									}
								});
								if (entity instanceof MidnightLurkerBackturnedEntity) {
									((MidnightLurkerBackturnedEntity) entity).setAnimation("teleport5");
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
