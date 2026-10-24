package net.mcreator.midnightlurker.procedures;

import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.Comparator;

import java.io.File;

public class VoidGatewayOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivationGateway") >= 1) {
			if (entity instanceof VoidGatewayEntity) {
				((VoidGatewayEntity) entity).setAnimation("gatewayclose");
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CloseTime") >= 9) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivationGateway") <= 0 && !net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("PlayerActivationGateway", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivationGateway") + 1));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivationGateway") >= 1 && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CloseTime") < 9) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("CloseTime", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CloseTime") + 1));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CloseTime") == 4) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivationGateway") >= 1 && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CloseTime") == 6) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom = Mth.nextDouble(RandomSource.create(), 1, 10);
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivationGateway") >= 1 && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CloseTime") == 8) {
			if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom < 8 && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CloseTime") == 8) {
				MidnightlurkerMod.queueServerWork(10, () -> {
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
					if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
						if (Math.random() > 0.7) {
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
						}
					}
				});
			} else if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom > 7 && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CloseTime") == 8) {
				MidnightlurkerMod.queueServerWork(10, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:insanitygoesbacksound")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:insanitygoesbacksound")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).isEmpty()) {
						if ((MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)))).InsanityStage > 0) {
							{
								double _setval = (MidnightlurkerModVariables.of(((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)))).InsanityStage - 1;
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
						}
					}
				});
			}
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE.get()), x, y, z, 1, 0.18, 0.2, 0.18, 0.1);
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 255, false, false));
	}
}
