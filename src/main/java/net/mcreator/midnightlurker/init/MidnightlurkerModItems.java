
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.midnightlurker.item.LurkerBookItem;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, MidnightlurkerMod.MODID);
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_AGGRESSIVE_SPAWN_EGG = REGISTRY.register("midnight_lurker_aggressive_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE, -13421773, -9624788, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKERTPOSE_SPAWN_EGG = REGISTRY.register("midnight_lurkertpose_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKERTPOSE, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_STALKING_SPAWN_EGG = REGISTRY.register("midnight_lurker_stalking_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_STALKING, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_INVISIBLE_SPAWN_EGG = REGISTRY.register("midnight_lurker_invisible_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_INVISIBLE, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> SPOOKYAMBIENCEENTITY_SPAWN_EGG = REGISTRY.register("spookyambienceentity_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.SPOOKYAMBIENCEENTITY, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_SEEN_ANGRESSIVE_SPAWN_EGG = REGISTRY.register("midnight_lurker_seen_angressive_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_SEEN_ANGRESSIVE, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DESTROYTEX_SPAWN_EGG = REGISTRY.register("destroytex_spawn_egg", () -> new DeferredSpawnEggItem(MidnightlurkerModEntities.DESTROYTEX, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DESTROYTEX_2_SPAWN_EGG = REGISTRY.register("destroytex_2_spawn_egg", () -> new DeferredSpawnEggItem(MidnightlurkerModEntities.DESTROYTEX_2, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DESTROYTEX_3_SPAWN_EGG = REGISTRY.register("destroytex_3_spawn_egg", () -> new DeferredSpawnEggItem(MidnightlurkerModEntities.DESTROYTEX_3, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DESTROYTEX_4_SPAWN_EGG = REGISTRY.register("destroytex_4_spawn_egg", () -> new DeferredSpawnEggItem(MidnightlurkerModEntities.DESTROYTEX_4, -1, -1, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_FAKER_AGGRO_SPAWN_EGG = REGISTRY.register("midnight_lurker_faker_aggro_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_AGGRO, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_FAKER_SPAWN_EGG = REGISTRY.register("midnight_lurker_faker_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_FAKER_WATCHER_SPAWN_EGG = REGISTRY.register("midnight_lurker_faker_watcher_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_WATCHER, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> VOID_GATEWAY_SPAWN_EGG = REGISTRY.register("void_gateway_spawn_egg", () -> new DeferredSpawnEggItem(MidnightlurkerModEntities.VOID_GATEWAY, -16777216, -16777216, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_BACKTURNED_SPAWN_EGG = REGISTRY.register("midnight_lurker_backturned_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_BACKTURNED, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_SHADOW_EYES_SPAWN_EGG = REGISTRY.register("midnight_lurker_shadow_eyes_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHADOW_EYES, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_SHADOW_SPAWN_EGG = REGISTRY.register("midnight_lurker_shadow_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHADOW, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_UNPROVOKED_SPAWN_EGG = REGISTRY.register("midnight_lurker_unprovoked_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_RUNAWAY_SPAWN_EGG = REGISTRY.register("midnight_lurker_runaway_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNAWAY, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_RUNTRUE_SPAWN_EGG = REGISTRY.register("midnight_lurker_runtrue_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNTRUE, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_HIDER_SPAWN_EGG = REGISTRY.register("midnight_lurker_hider_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_HIDER, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_STARE_SPAWN_EGG = REGISTRY.register("midnight_lurker_stare_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_STARE, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHTLURKER_NE_SPAWN_EGG = REGISTRY.register("midnightlurker_ne_spawn_egg", () -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHTLURKER_NE, -13421773, -12708839, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_WATCHER_SPAWN_EGG = REGISTRY.register("midnight_lurker_watcher_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_WATCHER, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> VOID_HANDS_SPAWN_EGG = REGISTRY.register("void_hands_spawn_egg", () -> new DeferredSpawnEggItem(MidnightlurkerModEntities.VOID_HANDS, -16777216, -16777216, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MIDNIGHT_LURKER_CREEP_SPAWN_EGG = REGISTRY.register("midnight_lurker_creep_spawn_egg",
			() -> new DeferredSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_CREEP, -13421773, -3355444, new Item.Properties()));
	public static final DeferredHolder<Item, Item> LURKER_BOOK = REGISTRY.register("lurker_book", () -> new LurkerBookItem());
	public static final DeferredHolder<Item, Item> TOUGH_DOOR = doubleBlock(MidnightlurkerModBlocks.TOUGH_DOOR);
	public static final DeferredHolder<Item, Item> SHATTERED_GLASS = block(MidnightlurkerModBlocks.SHATTERED_GLASS);
	public static final DeferredHolder<Item, Item> SHATTERED_PANE_NONE = block(MidnightlurkerModBlocks.SHATTERED_PANE_NONE);
	public static final DeferredHolder<Item, Item> SHATTERED_PANE_STRAIGHT = block(MidnightlurkerModBlocks.SHATTERED_PANE_STRAIGHT);
	public static final DeferredHolder<Item, Item> SHATTERED_CORNER = block(MidnightlurkerModBlocks.SHATTERED_CORNER);
	public static final DeferredHolder<Item, Item> SHATTERED_T_CORNER = block(MidnightlurkerModBlocks.SHATTERED_T_CORNER);
	public static final DeferredHolder<Item, Item> SHATTERED_PANE_X_CORNER = block(MidnightlurkerModBlocks.SHATTERED_PANE_X_CORNER);
	public static final DeferredHolder<Item, Item> SHATTERED_PANE_END = block(MidnightlurkerModBlocks.SHATTERED_PANE_END);

	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static DeferredHolder<Item, Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
