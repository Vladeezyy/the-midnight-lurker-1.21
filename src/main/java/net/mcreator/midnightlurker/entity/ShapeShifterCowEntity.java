
package net.mcreator.midnightlurker.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.procedures.ShapeshifterPigEntityIsHurtProcedure;
import net.mcreator.midnightlurker.procedures.ShapeShifterCowRightClickedOnEntityProcedure;
import net.mcreator.midnightlurker.procedures.ShapeShifterCowNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

public class ShapeShifterCowEntity extends PathfinderMob {
	public ShapeShifterCowEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(MidnightlurkerModEntities.SHAPE_SHIFTER_COW.get(), world);
	}

	public ShapeShifterCowEntity(EntityType<ShapeShifterCowEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, (float) 100));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		ShapeshifterPigEntityIsHurtProcedure.execute(this.level(), this);
		if (source.is(DamageTypes.IN_FIRE))
			return false;
		if (source.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
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
		return super.hurt(source, amount);
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		ShapeShifterCowRightClickedOnEntityProcedure.execute(world, entity, sourceentity);
		return retval;
	}

	public static void init() {
		SpawnPlacements.register(MidnightlurkerModEntities.SHAPE_SHIFTER_COW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return ShapeShifterCowNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
