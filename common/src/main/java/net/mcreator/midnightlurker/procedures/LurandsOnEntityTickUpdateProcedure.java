package net.mcreator.midnightlurker.procedures;

import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.entity.VoidHandsEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.Comparator;

import java.io.File;

public class LurandsOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivationGateway") <= 0 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 10) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("PlayerActivationGateway", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivationGateway") + 1));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("PlayerActivationGateway") >= 1) {
			if (entity instanceof VoidHandsEntity) {
				((VoidHandsEntity) entity).setAnimation("animation.lurands.disappear");
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("CloseTime") >= 9) {
			if (!entity.level().isClientSide())
				entity.discard();
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
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE.get()), x, y, z, 1, 0.18, 0.2, 0.18, 0.1);
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("Faking") == 0) {
			entity.setShiftKeyDown(true);
		} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("Faking") == 1) {
			entity.setShiftKeyDown(false);
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty() && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("Faking") == 0) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("Faking", 1);
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("Reveal") < 3) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("Reveal", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("Reveal") + 1));
			}
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 65, 65, 65), e -> true).isEmpty()) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == ((Entity) net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 65, 65, 65), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
				if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("AggroSounds") < 50) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("AggroSounds", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("AggroSounds") + 1));
				}
			}
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("AggroSounds") >= 50) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("AggroSounds", 0);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/playsound midnightlurker:voidhands_aggro hostile @a ~ ~ ~ 1 1");
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("Reveal") == 1) {
			if (entity instanceof VoidHandsEntity) {
				((VoidHandsEntity) entity).setAnimation("animation.lurands.reveal");
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/playsound midnightlurker:voidhands_shriek hostile @a ~ ~ ~ 1 1");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 255, false, false));
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, ResourceLocation.parse("minecraft:doors"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.IRON_DOOR)) {
			if (((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp73
					&& (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getbp73)) == false) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound minecraft:block.wooden_door.open block @a ~ ~ ~ 1 1");
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, ResourceLocation.parse("minecraft:doors"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.IRON_DOOR)) {
			if (((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp81
					&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getbp81)) == false) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound minecraft:block.wooden_door.open block @a ~ ~ ~ 1 1");
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, ResourceLocation.parse("minecraft:doors"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.IRON_DOOR)) {
			if (((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp89
					&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getbp89)) == false) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 1)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound minecraft:block.wooden_door.open block @a ~ ~ ~ 1 1");
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, ResourceLocation.parse("minecraft:doors"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.IRON_DOOR)) {
			if (((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp97
					&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getbp97)) == false) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 1)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound minecraft:block.wooden_door.open block @a ~ ~ ~ 1 1");
			}
		}
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
	}
}
