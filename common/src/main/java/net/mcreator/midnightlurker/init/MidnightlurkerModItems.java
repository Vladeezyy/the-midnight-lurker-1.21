
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.mcreator.midnightlurker.port.platform.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.platform.Registrar;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EntityType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.midnightlurker.item.LurkerBookItem;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModItems {
	public static final Registrar<Item> REGISTRY = Registrar.create(Registries.ITEM, MidnightlurkerMod.MODID);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_AGGRESSIVE_SPAWN_EGG = spawnEgg("midnight_lurker_aggressive_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKERTPOSE_SPAWN_EGG = spawnEgg("midnight_lurkertpose_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKERTPOSE);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_STALKING_SPAWN_EGG = spawnEgg("midnight_lurker_stalking_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_STALKING);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_INVISIBLE_SPAWN_EGG = spawnEgg("midnight_lurker_invisible_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_INVISIBLE);
	public static final RegistryEntry<Item, Item> SPOOKYAMBIENCEENTITY_SPAWN_EGG = spawnEgg("spookyambienceentity_spawn_egg", MidnightlurkerModEntities.SPOOKYAMBIENCEENTITY);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_SEEN_ANGRESSIVE_SPAWN_EGG = spawnEgg("midnight_lurker_seen_angressive_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_SEEN_ANGRESSIVE);
	public static final RegistryEntry<Item, Item> DESTROYTEX_SPAWN_EGG = spawnEgg("destroytex_spawn_egg", MidnightlurkerModEntities.DESTROYTEX);
	public static final RegistryEntry<Item, Item> DESTROYTEX_2_SPAWN_EGG = spawnEgg("destroytex_2_spawn_egg", MidnightlurkerModEntities.DESTROYTEX_2);
	public static final RegistryEntry<Item, Item> DESTROYTEX_3_SPAWN_EGG = spawnEgg("destroytex_3_spawn_egg", MidnightlurkerModEntities.DESTROYTEX_3);
	public static final RegistryEntry<Item, Item> DESTROYTEX_4_SPAWN_EGG = spawnEgg("destroytex_4_spawn_egg", MidnightlurkerModEntities.DESTROYTEX_4);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_FAKER_AGGRO_SPAWN_EGG = spawnEgg("midnight_lurker_faker_aggro_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_AGGRO);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_FAKER_SPAWN_EGG = spawnEgg("midnight_lurker_faker_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_FAKER_WATCHER_SPAWN_EGG = spawnEgg("midnight_lurker_faker_watcher_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_WATCHER);
	public static final RegistryEntry<Item, Item> VOID_GATEWAY_SPAWN_EGG = spawnEgg("void_gateway_spawn_egg", MidnightlurkerModEntities.VOID_GATEWAY);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_BACKTURNED_SPAWN_EGG = spawnEgg("midnight_lurker_backturned_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_BACKTURNED);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_SHADOW_EYES_SPAWN_EGG = spawnEgg("midnight_lurker_shadow_eyes_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_SHADOW_EYES);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_SHADOW_SPAWN_EGG = spawnEgg("midnight_lurker_shadow_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_SHADOW);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_UNPROVOKED_SPAWN_EGG = spawnEgg("midnight_lurker_unprovoked_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_RUNAWAY_SPAWN_EGG = spawnEgg("midnight_lurker_runaway_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNAWAY);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_RUNTRUE_SPAWN_EGG = spawnEgg("midnight_lurker_runtrue_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNTRUE);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_HIDER_SPAWN_EGG = spawnEgg("midnight_lurker_hider_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_HIDER);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_STARE_SPAWN_EGG = spawnEgg("midnight_lurker_stare_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_STARE);
	public static final RegistryEntry<Item, Item> MIDNIGHTLURKER_NE_SPAWN_EGG = spawnEgg("midnightlurker_ne_spawn_egg", MidnightlurkerModEntities.MIDNIGHTLURKER_NE);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_WATCHER_SPAWN_EGG = spawnEgg("midnight_lurker_watcher_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_WATCHER);
	public static final RegistryEntry<Item, Item> VOID_HANDS_SPAWN_EGG = spawnEgg("void_hands_spawn_egg", MidnightlurkerModEntities.VOID_HANDS);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_CREEP_SPAWN_EGG = spawnEgg("midnight_lurker_creep_spawn_egg", MidnightlurkerModEntities.MIDNIGHT_LURKER_CREEP);
	public static final RegistryEntry<Item, Item> LURKER_BOOK = REGISTRY.register("lurker_book", id -> new LurkerBookItem(properties(id)));
	public static final RegistryEntry<Item, Item> TOUGH_DOOR = doubleBlock(MidnightlurkerModBlocks.TOUGH_DOOR);
	public static final RegistryEntry<Item, Item> SHATTERED_GLASS = block(MidnightlurkerModBlocks.SHATTERED_GLASS);
	public static final RegistryEntry<Item, Item> SHATTERED_PANE_NONE = block(MidnightlurkerModBlocks.SHATTERED_PANE_NONE);
	public static final RegistryEntry<Item, Item> SHATTERED_PANE_STRAIGHT = block(MidnightlurkerModBlocks.SHATTERED_PANE_STRAIGHT);
	public static final RegistryEntry<Item, Item> SHATTERED_CORNER = block(MidnightlurkerModBlocks.SHATTERED_CORNER);
	public static final RegistryEntry<Item, Item> SHATTERED_T_CORNER = block(MidnightlurkerModBlocks.SHATTERED_T_CORNER);
	public static final RegistryEntry<Item, Item> SHATTERED_PANE_X_CORNER = block(MidnightlurkerModBlocks.SHATTERED_PANE_X_CORNER);
	public static final RegistryEntry<Item, Item> SHATTERED_PANE_END = block(MidnightlurkerModBlocks.SHATTERED_PANE_END);

	private static RegistryEntry<Item, Item> block(RegistryEntry<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), id -> new BlockItem(block.get(), properties(id).useBlockDescriptionPrefix()));
	}

	private static RegistryEntry<Item, Item> doubleBlock(RegistryEntry<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), id -> new DoubleHighBlockItem(block.get(), properties(id).useBlockDescriptionPrefix()));
	}

	// 1.21.5: one texture per spawn egg (assets/midnightlurker/textures/item/<name>.png, made from the old colors by
	// tools/spawn_eggs.py) and the entity type in the properties
	private static RegistryEntry<Item, Item> spawnEgg(String name, RegistryEntry<EntityType<?>, ? extends EntityType<?>> type) {
		return REGISTRY.register(name, id -> new SpawnEggItem(properties(id).spawnEgg(type.get())));
	}

	// 1.21.2: an item knows its id from construction
	private static Item.Properties properties(Identifier id) {
		return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id));
	}
}
