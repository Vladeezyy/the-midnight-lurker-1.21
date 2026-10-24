
package net.mcreator.midnightlurker.entity;

import net.minecraft.server.level.ServerLevel;
import net.mcreator.midnightlurker.port.bus.RegisterSpawnPlacementsEvent;
import net.minecraft.world.entity.SpawnPlacementTypes;

import com.geckolib.util.GeckoLibUtil;
import com.geckolib.animation.object.PlayState;
import com.geckolib.animation.RawAnimation;
import com.geckolib.animation.state.AnimationTest;
import com.geckolib.animation.AnimationController;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.GeoEntity;

import net.mcreator.midnightlurker.port.GeoAnims;

import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.procedures.MidnightLurkerUnprovokedThisEntityKillsAnotherOneProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerUnprovokedOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerUnprovokedOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerEntityDiesProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveEntityIsHurtProcedure;
import net.mcreator.midnightlurker.procedures.LurkerinwaterconditionProcedure;
import net.mcreator.midnightlurker.procedures.LurkerKillAnimalsProcProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

import javax.annotation.Nullable;

public class MidnightLurkerUnprovokedEntity extends Monster implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(MidnightLurkerUnprovokedEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(MidnightLurkerUnprovokedEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(MidnightLurkerUnprovokedEntity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private long lastSwing;
	public String animationprocedure = "empty";


	public MidnightLurkerUnprovokedEntity(EntityType<MidnightLurkerUnprovokedEntity> type, Level world) {
		super(type, world);
		xpReward = 25;
		setNoAi(false);
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(SHOOT, false);
		builder.define(ANIMATION, "undefined");
		builder.define(TEXTURE, "midnightlurkervoidgate");
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}


	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < 2.25 && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth() && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, (float) 100));
		this.goalSelector.addGoal(6, new FloatGoal(this) {
			@Override
			public boolean canUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canUse() && LurkerinwaterconditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canContinueToUse() && LurkerinwaterconditionProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, Pig.class, false, false) {
			@Override
			public boolean canUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canUse() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canContinueToUse() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}
		});
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, Cow.class, false, false) {
			@Override
			public boolean canUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canUse() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canContinueToUse() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}
		});
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, Sheep.class, false, false) {
			@Override
			public boolean canUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canUse() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canContinueToUse() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}
		});
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, Chicken.class, false, false) {
			@Override
			public boolean canUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canUse() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				Level world = MidnightLurkerUnprovokedEntity.this.level();
				return super.canContinueToUse() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}
		});
	}


	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerchasesteps")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerhurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerdeath"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
		MidnightLurkerAggressiveEntityIsHurtProcedure.execute(this, source.getEntity());
		if (source.is(DamageTypes.IN_FIRE))
			return false;
		if (source.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (source.getDirectEntity() instanceof AbstractThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source.is(DamageTypes.FALL))
			return false;
		if (source.is(DamageTypes.CACTUS))
			return false;
		if (source.is(DamageTypes.DROWN))
			return false;
		if (source.is(DamageTypes.LIGHTNING_BOLT))
			return false;
		if (source.is(DamageTypes.EXPLOSION))
			return false;
		if (source.is(DamageTypes.TRIDENT))
			return false;
		if (source.is(DamageTypes.FALLING_ANVIL))
			return false;
		if (source.is(DamageTypes.DRAGON_BREATH))
			return false;
		if (source.is(DamageTypes.WITHER))
			return false;
		if (source.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurtServer(level, source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		MidnightLurkerEntityDiesProcedure.execute(this.level(), this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
		MidnightLurkerUnprovokedOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void awardKillScore(Entity entity, DamageSource damageSource) {
		super.awardKillScore(entity, damageSource);
		MidnightLurkerUnprovokedThisEntityKillsAnotherOneProcedure.execute(this.level(), entity);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkerUnprovokedOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose p_33597_) {
		return super.getDefaultDimensions(p_33597_).scale((float) 1);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return MidnightLurkerNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		}, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.42);
		builder = builder.add(Attributes.MAX_HEALTH, 60);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 100);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
		return builder;
	}

	private PlayState movementPredicate(AnimationTest<MidnightLurkerUnprovokedEntity> event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(this.walkAnimation.speed() > -0.15F && this.walkAnimation.speed() < 0.15F))

					&& !this.isAggressive()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("stalking5"));
			}
			if (this.isInWater()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim5"));
			}
			if (this.isShiftKeyDown()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("backturned5"));
			}
			if (this.isAggressive() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("running56"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle5"));
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationTest<MidnightLurkerUnprovokedEntity> event) {
		return GeoAnims.procedure(event, this.animationprocedure, animation -> this.animationprocedure = animation);
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(MidnightLurkerUnprovokedEntity.RemovalReason.KILLED);
			if (this.level() instanceof ServerLevel _serverLevel)
				this.dropExperience(_serverLevel, null);
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new GeoAnims.Controller<>("movement", 4, this::movementPredicate));
		data.add(new GeoAnims.Controller<>("procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
