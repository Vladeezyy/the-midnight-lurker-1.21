
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.platform.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.platform.Registrar;
import net.mcreator.midnightlurker.port.bus.RegisterSpawnPlacementsEvent;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.entity.VoidHandsEntity;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;
import net.mcreator.midnightlurker.entity.VillagerOutcastEntity;
import net.mcreator.midnightlurker.entity.SpookyambienceentityEntity;
import net.mcreator.midnightlurker.entity.ShapeshifterPigEntity;
import net.mcreator.midnightlurker.entity.ShapeShifterCowEntity;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightPhantomHeadEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.entity.InvisibleStaticEntity;
import net.mcreator.midnightlurker.entity.InvisibleShadowEntity;
import net.mcreator.midnightlurker.entity.InvisibleLurkerFootstepsEntity;
import net.mcreator.midnightlurker.entity.InvisibleFootstepsEntity;
import net.mcreator.midnightlurker.entity.InvisibleCaveSoundsEntity;
import net.mcreator.midnightlurker.entity.InvisibleAnimalKillerEntity;
import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.mcreator.midnightlurker.entity.Destroytex3Entity;
import net.mcreator.midnightlurker.entity.Destroytex2Entity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

@EventBusSubscriber
public class MidnightlurkerModEntities {
	public static final Registrar<EntityType<?>> REGISTRY = Registrar.create(Registries.ENTITY_TYPE, MidnightlurkerMod.MODID);
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerAggressiveEntity>> MIDNIGHT_LURKER_AGGRESSIVE = register("midnight_lurker_aggressive",
			EntityType.Builder.<MidnightLurkerAggressiveEntity>of(MidnightLurkerAggressiveEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkertposeEntity>> MIDNIGHT_LURKERTPOSE = register("midnight_lurkertpose", EntityType.Builder.<MidnightLurkertposeEntity>of(MidnightLurkertposeEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerStalkingEntity>> MIDNIGHT_LURKER_STALKING = register("midnight_lurker_stalking",
			EntityType.Builder.<MidnightLurkerStalkingEntity>of(MidnightLurkerStalkingEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerInvisibleEntity>> MIDNIGHT_LURKER_INVISIBLE = register("midnight_lurker_invisible",
			EntityType.Builder.<MidnightLurkerInvisibleEntity>of(MidnightLurkerInvisibleEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<SpookyambienceentityEntity>> SPOOKYAMBIENCEENTITY = register("spookyambienceentity", EntityType.Builder.<SpookyambienceentityEntity>of(SpookyambienceentityEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerSeenAngressiveEntity>> MIDNIGHT_LURKER_SEEN_ANGRESSIVE = register("midnight_lurker_seen_angressive",
			EntityType.Builder.<MidnightLurkerSeenAngressiveEntity>of(MidnightLurkerSeenAngressiveEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<DestroytexEntity>> DESTROYTEX = register("destroytex", EntityType.Builder.<DestroytexEntity>of(DestroytexEntity::new, MobCategory.CREATURE).clientTrackingRange(64)
			.updateInterval(3).fireImmune().sized(0.7f, 3f));
	public static final RegistryEntry<EntityType<?>, EntityType<Destroytex2Entity>> DESTROYTEX_2 = register("destroytex_2", EntityType.Builder.<Destroytex2Entity>of(Destroytex2Entity::new, MobCategory.CREATURE)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 3f));
	public static final RegistryEntry<EntityType<?>, EntityType<Destroytex3Entity>> DESTROYTEX_3 = register("destroytex_3", EntityType.Builder.<Destroytex3Entity>of(Destroytex3Entity::new, MobCategory.CREATURE)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 3f));
	public static final RegistryEntry<EntityType<?>, EntityType<Destroytex4Entity>> DESTROYTEX_4 = register("destroytex_4", EntityType.Builder.<Destroytex4Entity>of(Destroytex4Entity::new, MobCategory.CREATURE)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 3f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerFakerAggroEntity>> MIDNIGHT_LURKER_FAKER_AGGRO = register("midnight_lurker_faker_aggro",
			EntityType.Builder.<MidnightLurkerFakerAggroEntity>of(MidnightLurkerFakerAggroEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerFakerEntity>> MIDNIGHT_LURKER_FAKER = register("midnight_lurker_faker", EntityType.Builder.<MidnightLurkerFakerEntity>of(MidnightLurkerFakerEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerFakerWatcherEntity>> MIDNIGHT_LURKER_FAKER_WATCHER = register("midnight_lurker_faker_watcher",
			EntityType.Builder.<MidnightLurkerFakerWatcherEntity>of(MidnightLurkerFakerWatcherEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<VoidGatewayEntity>> VOID_GATEWAY = register("void_gateway", EntityType.Builder.<VoidGatewayEntity>of(VoidGatewayEntity::new, MobCategory.AMBIENT)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.6f, 1.4f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerBackturnedEntity>> MIDNIGHT_LURKER_BACKTURNED = register("midnight_lurker_backturned",
			EntityType.Builder.<MidnightLurkerBackturnedEntity>of(MidnightLurkerBackturnedEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerShadowEyesEntity>> MIDNIGHT_LURKER_SHADOW_EYES = register("midnight_lurker_shadow_eyes",
			EntityType.Builder.<MidnightLurkerShadowEyesEntity>of(MidnightLurkerShadowEyesEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerShadowEntity>> MIDNIGHT_LURKER_SHADOW = register("midnight_lurker_shadow", EntityType.Builder.<MidnightLurkerShadowEntity>of(MidnightLurkerShadowEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerUnprovokedEntity>> MIDNIGHT_LURKER_UNPROVOKED = register("midnight_lurker_unprovoked",
			EntityType.Builder.<MidnightLurkerUnprovokedEntity>of(MidnightLurkerUnprovokedEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerRunawayEntity>> MIDNIGHT_LURKER_RUNAWAY = register("midnight_lurker_runaway", EntityType.Builder.<MidnightLurkerRunawayEntity>of(MidnightLurkerRunawayEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerRuntrueEntity>> MIDNIGHT_LURKER_RUNTRUE = register("midnight_lurker_runtrue", EntityType.Builder.<MidnightLurkerRuntrueEntity>of(MidnightLurkerRuntrueEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerHiderEntity>> MIDNIGHT_LURKER_HIDER = register("midnight_lurker_hider", EntityType.Builder.<MidnightLurkerHiderEntity>of(MidnightLurkerHiderEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerShapeshifterEntity>> MIDNIGHT_LURKER_SHAPESHIFTER = register("midnight_lurker_shapeshifter",
			EntityType.Builder.<MidnightLurkerShapeshifterEntity>of(MidnightLurkerShapeshifterEntity::new, MobCategory.AMBIENT).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.6f, 1.95f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerStareEntity>> MIDNIGHT_LURKER_STARE = register("midnight_lurker_stare", EntityType.Builder.<MidnightLurkerStareEntity>of(MidnightLurkerStareEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightlurkerNEEntity>> MIDNIGHTLURKER_NE = register("midnightlurker_ne", EntityType.Builder.<MidnightlurkerNEEntity>of(MidnightlurkerNEEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerWatcherEntity>> MIDNIGHT_LURKER_WATCHER = register("midnight_lurker_watcher", EntityType.Builder.<MidnightLurkerWatcherEntity>of(MidnightLurkerWatcherEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<VoidHandsEntity>> VOID_HANDS = register("void_hands", EntityType.Builder.<VoidHandsEntity>of(VoidHandsEntity::new, MobCategory.AMBIENT).clientTrackingRange(64)
			.updateInterval(3).fireImmune().sized(0.6f, 1.4f));
	public static final RegistryEntry<EntityType<?>, EntityType<InvisibleFootstepsEntity>> INVISIBLE_FOOTSTEPS = register("invisible_footsteps", EntityType.Builder.<InvisibleFootstepsEntity>of(InvisibleFootstepsEntity::new, MobCategory.AMBIENT)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.5f, 0.4f).eyeHeight(1.4f));
	public static final RegistryEntry<EntityType<?>, EntityType<InvisibleShadowEntity>> INVISIBLE_SHADOW = register("invisible_shadow", EntityType.Builder.<InvisibleShadowEntity>of(InvisibleShadowEntity::new, MobCategory.AMBIENT)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.5f, 0.4f).eyeHeight(1.4f));
	public static final RegistryEntry<EntityType<?>, EntityType<InvisibleStaticEntity>> INVISIBLE_STATIC = register("invisible_static", EntityType.Builder.<InvisibleStaticEntity>of(InvisibleStaticEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.5f, 0.4f).eyeHeight(1.4f));
	public static final RegistryEntry<EntityType<?>, EntityType<InvisibleLurkerFootstepsEntity>> INVISIBLE_LURKER_FOOTSTEPS = register("invisible_lurker_footsteps",
			EntityType.Builder.<InvisibleLurkerFootstepsEntity>of(InvisibleLurkerFootstepsEntity::new, MobCategory.AMBIENT).clientTrackingRange(64).updateInterval(3)
					.fireImmune().sized(0.5f, 0.4f).eyeHeight(1.4f));
	public static final RegistryEntry<EntityType<?>, EntityType<InvisibleCaveSoundsEntity>> INVISIBLE_CAVE_SOUNDS = register("invisible_cave_sounds", EntityType.Builder.<InvisibleCaveSoundsEntity>of(InvisibleCaveSoundsEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.5f, 0.4f).eyeHeight(1.4f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightLurkerCreepEntity>> MIDNIGHT_LURKER_CREEP = register("midnight_lurker_creep", EntityType.Builder.<MidnightLurkerCreepEntity>of(MidnightLurkerCreepEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<MidnightPhantomHeadEntity>> MIDNIGHT_PHANTOM_HEAD = register("midnight_phantom_head", EntityType.Builder.<MidnightPhantomHeadEntity>of(MidnightPhantomHeadEntity::new, MobCategory.MONSTER)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.4f, 0.5f));
	public static final RegistryEntry<EntityType<?>, EntityType<InvisibleAnimalKillerEntity>> INVISIBLE_ANIMAL_KILLER = register("invisible_animal_killer", EntityType.Builder.<InvisibleAnimalKillerEntity>of(InvisibleAnimalKillerEntity::new, MobCategory.AMBIENT)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.5f, 0.4f).eyeHeight(1.4f));
	public static final RegistryEntry<EntityType<?>, EntityType<ShapeshifterPigEntity>> SHAPESHIFTER_PIG = register("shapeshifter_pig", EntityType.Builder.<ShapeshifterPigEntity>of(ShapeshifterPigEntity::new, MobCategory.CREATURE)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.9f, 0.9f));
	public static final RegistryEntry<EntityType<?>, EntityType<ShapeShifterCowEntity>> SHAPE_SHIFTER_COW = register("shape_shifter_cow", EntityType.Builder.<ShapeShifterCowEntity>of(ShapeShifterCowEntity::new, MobCategory.CREATURE)
			.clientTrackingRange(64).updateInterval(3).fireImmune().sized(0.9f, 1.4f));
	public static final RegistryEntry<EntityType<?>, EntityType<VillagerOutcastEntity>> VILLAGER_OUTCAST = register("villager_outcast",
			EntityType.Builder.<VillagerOutcastEntity>of(VillagerOutcastEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3)

					.sized(0.6f, 1.95f));

	private static <T extends Entity> RegistryEntry<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MidnightlurkerMod.MODID, registryname))));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		MidnightLurkerAggressiveEntity.init(event);
		MidnightLurkertposeEntity.init(event);
		MidnightLurkerStalkingEntity.init(event);
		MidnightLurkerInvisibleEntity.init(event);
		SpookyambienceentityEntity.init(event);
		MidnightLurkerSeenAngressiveEntity.init(event);
		DestroytexEntity.init(event);
		Destroytex2Entity.init(event);
		Destroytex3Entity.init(event);
		Destroytex4Entity.init(event);
		MidnightLurkerFakerAggroEntity.init(event);
		MidnightLurkerFakerEntity.init(event);
		MidnightLurkerFakerWatcherEntity.init(event);
		VoidGatewayEntity.init(event);
		MidnightLurkerBackturnedEntity.init(event);
		MidnightLurkerShadowEyesEntity.init(event);
		MidnightLurkerShadowEntity.init(event);
		MidnightLurkerUnprovokedEntity.init(event);
		MidnightLurkerRunawayEntity.init(event);
		MidnightLurkerRuntrueEntity.init(event);
		MidnightLurkerHiderEntity.init(event);
		MidnightLurkerShapeshifterEntity.init(event);
		MidnightLurkerStareEntity.init(event);
		MidnightlurkerNEEntity.init(event);
		MidnightLurkerWatcherEntity.init(event);
		VoidHandsEntity.init(event);
		InvisibleFootstepsEntity.init(event);
		InvisibleShadowEntity.init(event);
		InvisibleStaticEntity.init(event);
		InvisibleLurkerFootstepsEntity.init(event);
		InvisibleCaveSoundsEntity.init(event);
		MidnightLurkerCreepEntity.init(event);
		MidnightPhantomHeadEntity.init(event);
		InvisibleAnimalKillerEntity.init(event);
		ShapeshifterPigEntity.init(event);
		ShapeShifterCowEntity.init(event);
		VillagerOutcastEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MIDNIGHT_LURKER_AGGRESSIVE.get(), MidnightLurkerAggressiveEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKERTPOSE.get(), MidnightLurkertposeEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_STALKING.get(), MidnightLurkerStalkingEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_INVISIBLE.get(), MidnightLurkerInvisibleEntity.createAttributes().build());
		event.put(SPOOKYAMBIENCEENTITY.get(), SpookyambienceentityEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_SEEN_ANGRESSIVE.get(), MidnightLurkerSeenAngressiveEntity.createAttributes().build());
		event.put(DESTROYTEX.get(), DestroytexEntity.createAttributes().build());
		event.put(DESTROYTEX_2.get(), Destroytex2Entity.createAttributes().build());
		event.put(DESTROYTEX_3.get(), Destroytex3Entity.createAttributes().build());
		event.put(DESTROYTEX_4.get(), Destroytex4Entity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_FAKER_AGGRO.get(), MidnightLurkerFakerAggroEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_FAKER.get(), MidnightLurkerFakerEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_FAKER_WATCHER.get(), MidnightLurkerFakerWatcherEntity.createAttributes().build());
		event.put(VOID_GATEWAY.get(), VoidGatewayEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_BACKTURNED.get(), MidnightLurkerBackturnedEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_SHADOW_EYES.get(), MidnightLurkerShadowEyesEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_SHADOW.get(), MidnightLurkerShadowEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_UNPROVOKED.get(), MidnightLurkerUnprovokedEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_RUNAWAY.get(), MidnightLurkerRunawayEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_RUNTRUE.get(), MidnightLurkerRuntrueEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_HIDER.get(), MidnightLurkerHiderEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_SHAPESHIFTER.get(), MidnightLurkerShapeshifterEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_STARE.get(), MidnightLurkerStareEntity.createAttributes().build());
		event.put(MIDNIGHTLURKER_NE.get(), MidnightlurkerNEEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_WATCHER.get(), MidnightLurkerWatcherEntity.createAttributes().build());
		event.put(VOID_HANDS.get(), VoidHandsEntity.createAttributes().build());
		event.put(INVISIBLE_FOOTSTEPS.get(), InvisibleFootstepsEntity.createAttributes().build());
		event.put(INVISIBLE_SHADOW.get(), InvisibleShadowEntity.createAttributes().build());
		event.put(INVISIBLE_STATIC.get(), InvisibleStaticEntity.createAttributes().build());
		event.put(INVISIBLE_LURKER_FOOTSTEPS.get(), InvisibleLurkerFootstepsEntity.createAttributes().build());
		event.put(INVISIBLE_CAVE_SOUNDS.get(), InvisibleCaveSoundsEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_CREEP.get(), MidnightLurkerCreepEntity.createAttributes().build());
		event.put(MIDNIGHT_PHANTOM_HEAD.get(), MidnightPhantomHeadEntity.createAttributes().build());
		event.put(INVISIBLE_ANIMAL_KILLER.get(), InvisibleAnimalKillerEntity.createAttributes().build());
		event.put(SHAPESHIFTER_PIG.get(), ShapeshifterPigEntity.createAttributes().build());
		event.put(SHAPE_SHIFTER_COW.get(), ShapeShifterCowEntity.createAttributes().build());
		event.put(VILLAGER_OUTCAST.get(), VillagerOutcastEntity.createAttributes().build());
	}
}
