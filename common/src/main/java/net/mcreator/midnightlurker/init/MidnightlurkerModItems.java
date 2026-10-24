
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.mcreator.midnightlurker.port.platform.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.platform.Registrar;
import net.minecraft.world.item.SpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.midnightlurker.item.LurkerBookItem;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModItems {
	public static final Registrar<Item> REGISTRY = Registrar.create(Registries.ITEM, MidnightlurkerMod.MODID);
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_AGGRESSIVE_SPAWN_EGG = REGISTRY.register("midnight_lurker_aggressive_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE.get(), -13421773, -9624788, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKERTPOSE_SPAWN_EGG = REGISTRY.register("midnight_lurkertpose_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKERTPOSE.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_STALKING_SPAWN_EGG = REGISTRY.register("midnight_lurker_stalking_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_STALKING.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_INVISIBLE_SPAWN_EGG = REGISTRY.register("midnight_lurker_invisible_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_INVISIBLE.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> SPOOKYAMBIENCEENTITY_SPAWN_EGG = REGISTRY.register("spookyambienceentity_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.SPOOKYAMBIENCEENTITY.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_SEEN_ANGRESSIVE_SPAWN_EGG = REGISTRY.register("midnight_lurker_seen_angressive_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_SEEN_ANGRESSIVE.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> DESTROYTEX_SPAWN_EGG = REGISTRY.register("destroytex_spawn_egg", () -> new SpawnEggItem(MidnightlurkerModEntities.DESTROYTEX.get(), -1, -1, new Item.Properties()));
	public static final RegistryEntry<Item, Item> DESTROYTEX_2_SPAWN_EGG = REGISTRY.register("destroytex_2_spawn_egg", () -> new SpawnEggItem(MidnightlurkerModEntities.DESTROYTEX_2.get(), -1, -1, new Item.Properties()));
	public static final RegistryEntry<Item, Item> DESTROYTEX_3_SPAWN_EGG = REGISTRY.register("destroytex_3_spawn_egg", () -> new SpawnEggItem(MidnightlurkerModEntities.DESTROYTEX_3.get(), -1, -1, new Item.Properties()));
	public static final RegistryEntry<Item, Item> DESTROYTEX_4_SPAWN_EGG = REGISTRY.register("destroytex_4_spawn_egg", () -> new SpawnEggItem(MidnightlurkerModEntities.DESTROYTEX_4.get(), -1, -1, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_FAKER_AGGRO_SPAWN_EGG = REGISTRY.register("midnight_lurker_faker_aggro_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_AGGRO.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_FAKER_SPAWN_EGG = REGISTRY.register("midnight_lurker_faker_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_FAKER_WATCHER_SPAWN_EGG = REGISTRY.register("midnight_lurker_faker_watcher_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_WATCHER.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> VOID_GATEWAY_SPAWN_EGG = REGISTRY.register("void_gateway_spawn_egg", () -> new SpawnEggItem(MidnightlurkerModEntities.VOID_GATEWAY.get(), -16777216, -16777216, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_BACKTURNED_SPAWN_EGG = REGISTRY.register("midnight_lurker_backturned_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_BACKTURNED.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_SHADOW_EYES_SPAWN_EGG = REGISTRY.register("midnight_lurker_shadow_eyes_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHADOW_EYES.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_SHADOW_SPAWN_EGG = REGISTRY.register("midnight_lurker_shadow_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHADOW.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_UNPROVOKED_SPAWN_EGG = REGISTRY.register("midnight_lurker_unprovoked_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_RUNAWAY_SPAWN_EGG = REGISTRY.register("midnight_lurker_runaway_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNAWAY.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_RUNTRUE_SPAWN_EGG = REGISTRY.register("midnight_lurker_runtrue_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNTRUE.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_HIDER_SPAWN_EGG = REGISTRY.register("midnight_lurker_hider_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_HIDER.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_STARE_SPAWN_EGG = REGISTRY.register("midnight_lurker_stare_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_STARE.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHTLURKER_NE_SPAWN_EGG = REGISTRY.register("midnightlurker_ne_spawn_egg", () -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHTLURKER_NE.get(), -13421773, -12708839, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_WATCHER_SPAWN_EGG = REGISTRY.register("midnight_lurker_watcher_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_WATCHER.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> VOID_HANDS_SPAWN_EGG = REGISTRY.register("void_hands_spawn_egg", () -> new SpawnEggItem(MidnightlurkerModEntities.VOID_HANDS.get(), -16777216, -16777216, new Item.Properties()));
	public static final RegistryEntry<Item, Item> MIDNIGHT_LURKER_CREEP_SPAWN_EGG = REGISTRY.register("midnight_lurker_creep_spawn_egg",
			() -> new SpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_CREEP.get(), -13421773, -3355444, new Item.Properties()));
	public static final RegistryEntry<Item, Item> LURKER_BOOK = REGISTRY.register("lurker_book", () -> new LurkerBookItem());
	public static final RegistryEntry<Item, Item> TOUGH_DOOR = doubleBlock(MidnightlurkerModBlocks.TOUGH_DOOR);
	public static final RegistryEntry<Item, Item> SHATTERED_GLASS = block(MidnightlurkerModBlocks.SHATTERED_GLASS);
	public static final RegistryEntry<Item, Item> SHATTERED_PANE_NONE = block(MidnightlurkerModBlocks.SHATTERED_PANE_NONE);
	public static final RegistryEntry<Item, Item> SHATTERED_PANE_STRAIGHT = block(MidnightlurkerModBlocks.SHATTERED_PANE_STRAIGHT);
	public static final RegistryEntry<Item, Item> SHATTERED_CORNER = block(MidnightlurkerModBlocks.SHATTERED_CORNER);
	public static final RegistryEntry<Item, Item> SHATTERED_T_CORNER = block(MidnightlurkerModBlocks.SHATTERED_T_CORNER);
	public static final RegistryEntry<Item, Item> SHATTERED_PANE_X_CORNER = block(MidnightlurkerModBlocks.SHATTERED_PANE_X_CORNER);
	public static final RegistryEntry<Item, Item> SHATTERED_PANE_END = block(MidnightlurkerModBlocks.SHATTERED_PANE_END);

	private static RegistryEntry<Item, Item> block(RegistryEntry<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static RegistryEntry<Item, Item> doubleBlock(RegistryEntry<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
