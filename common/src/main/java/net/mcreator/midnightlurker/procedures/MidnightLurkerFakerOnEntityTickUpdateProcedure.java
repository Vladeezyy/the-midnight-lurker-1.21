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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
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
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.Comparator;

import java.io.File;

public class MidnightLurkerFakerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivation") <= 0 && !net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 25, 25, 25), e -> true).isEmpty()) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("PlayerActivation", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivation") + 1));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanePotionTimer") == 1) {
			if (entity instanceof MidnightLurkerFakerEntity && !(entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()))) {
				if (entity instanceof MidnightLurkerFakerEntity) {
					((MidnightLurkerFakerEntity) entity).setAnimation("snapstare4");
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
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (!entity.level().isClientSide())
				entity.discard();
			if ((MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)))).JumpscareActive < 1) {
				{
					double _setval = 1;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
					_vars.JumpscareActive = _setval;
					_vars.syncPlayerVariables(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
				}
			}
			if ((MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)))).InsanityStage < 7) {
				{
					double _setval = (MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)))).InsanityStage + 1;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
					_vars.InsanityStage = _setval;
					_vars.syncPlayerVariables(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
				}
				{
					double _setval = 0;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
				}
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SlownessEffect") >= 1 && !net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).isEmpty()
				&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivation") >= 1) {
			if (((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY.holder(), 55, 0, false, false));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SlownessEffect") <= 0 && entity instanceof LivingEntity _livEnt72 && _livEnt72.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
			entity.setShiftKeyDown(true);
		} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("SlownessEffect") >= 1 && entity instanceof LivingEntity _livEnt75 && _livEnt75.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
			MidnightlurkerMod.queueServerWork(2, () -> {
				entity.setShiftKeyDown(false);
			});
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_DOT.get()), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
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
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.6");
				}
			}
		}
	}
}
