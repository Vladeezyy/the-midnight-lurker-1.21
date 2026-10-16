package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

import java.util.Comparator;

public class MidnightLurkerShadowEyesOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double raytrace_distance = 0;
		String found_entity_name = "";
		boolean entity_found = false;
		if (entity.getPersistentData().getDouble("LightLevelRandom") < 8 && world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 1) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 25, 25, 25), e -> true).isEmpty()) {
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
			}
		} else if (entity.getPersistentData().getDouble("LightLevelRandom") > 7 && world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(entity.getYRot());
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setXRot(entity.getXRot());
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty() && entity.getPersistentData().getDouble("LightLevelRandom") < 8
				&& ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET)) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 25, 25, 25), e -> true).isEmpty()) {
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
			}
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty() && entity.getPersistentData().getDouble("LightLevelRandom") > 7
				&& ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET
						|| (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET)) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(entity.getYRot());
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setXRot(entity.getXRot());
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 25, 25, 25), e -> true).isEmpty()) {
			entity.getPersistentData().putDouble("LightLevelRandom", (Mth.nextDouble(RandomSource.create(), 1, 10)));
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
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.5");
				}
			}
		}
	}
}
