
package net.mcreator.midnightlurker.entity;

import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.procedures.VoidFloatProcProcedure;
import net.mcreator.midnightlurker.procedures.InvisibleFootstepsNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.procedures.InvisibleCaveSoundsOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.procedures.FootstepsWalkToPlayerProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

public class InvisibleCaveSoundsEntity extends Monster implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(InvisibleCaveSoundsEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(InvisibleCaveSoundsEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(InvisibleCaveSoundsEntity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private long lastSwing;
	public String animationprocedure = "empty";


	public InvisibleCaveSoundsEntity(EntityType<InvisibleCaveSoundsEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(SHOOT, false);
		builder.define(ANIMATION, "undefined");
		builder.define(TEXTURE, "nothing");
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
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				Entity entity = InvisibleCaveSoundsEntity.this;
				Level world = InvisibleCaveSoundsEntity.this.level();
				return super.canUse() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				Entity entity = InvisibleCaveSoundsEntity.this;
				Level world = InvisibleCaveSoundsEntity.this.level();
				return super.canContinueToUse() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}
		});
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth() && this.mob.getSensing().hasLineOfSight(entity);
			}

			@Override
			public boolean canUse() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				Entity entity = InvisibleCaveSoundsEntity.this;
				Level world = InvisibleCaveSoundsEntity.this.level();
				return super.canUse() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				Entity entity = InvisibleCaveSoundsEntity.this;
				Level world = InvisibleCaveSoundsEntity.this.level();
				return super.canContinueToUse() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}

		});
		this.goalSelector.addGoal(3, new FloatGoal(this) {
			@Override
			public boolean canUse() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				Entity entity = InvisibleCaveSoundsEntity.this;
				Level world = InvisibleCaveSoundsEntity.this.level();
				return super.canUse() && VoidFloatProcProcedure.execute();
			}

			@Override
			public boolean canContinueToUse() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				Entity entity = InvisibleCaveSoundsEntity.this;
				Level world = InvisibleCaveSoundsEntity.this.level();
				return super.canContinueToUse() && VoidFloatProcProcedure.execute();
			}
		});
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				Entity entity = InvisibleCaveSoundsEntity.this;
				Level world = InvisibleCaveSoundsEntity.this.level();
				return super.canUse() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				Entity entity = InvisibleCaveSoundsEntity.this;
				Level world = InvisibleCaveSoundsEntity.this.level();
				return super.canContinueToUse() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}
		});
	}


	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:nostepsound")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse(""));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse(""));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
		if (source.is(DamageTypes.IN_FIRE))
			return false;
		if (source.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (source.getDirectEntity() instanceof Player)
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
	public void baseTick() {
		super.baseTick();
		InvisibleCaveSoundsOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose p_33597_) {
		return super.getDefaultDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	@Override
	protected void pushEntities() {
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(MidnightlurkerModEntities.INVISIBLE_CAVE_SOUNDS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return InvisibleFootstepsNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		}, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 5);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 100);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 5);
		return builder;
	}

	private PlayState movementPredicate(AnimationTest<InvisibleCaveSoundsEntity> event) {
		if (this.animationprocedure.equals("empty")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("gatewaydarkness"));
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationTest<InvisibleCaveSoundsEntity> event) {
		return GeoAnims.procedure(event, this.animationprocedure, animation -> this.animationprocedure = animation);
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(InvisibleCaveSoundsEntity.RemovalReason.KILLED);
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
