
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.mcreator.midnightlurker.port.platform.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.platform.Registrar;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.block.ToughDoorBlock;
import net.mcreator.midnightlurker.block.ShatteredTCornerBlock;
import net.mcreator.midnightlurker.block.ShatteredPaneXCornerBlock;
import net.mcreator.midnightlurker.block.ShatteredPaneStraightBlock;
import net.mcreator.midnightlurker.block.ShatteredPaneNoneBlock;
import net.mcreator.midnightlurker.block.ShatteredPaneEndBlock;
import net.mcreator.midnightlurker.block.ShatteredGlassBlock;
import net.mcreator.midnightlurker.block.ShatteredCornerBlock;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModBlocks {
	public static final Registrar<Block> REGISTRY = Registrar.create(Registries.BLOCK, MidnightlurkerMod.MODID);
	public static final RegistryEntry<Block, Block> TOUGH_DOOR = REGISTRY.register("tough_door", id -> new ToughDoorBlock(properties(id)));
	public static final RegistryEntry<Block, Block> SHATTERED_GLASS = REGISTRY.register("shattered_glass", id -> new ShatteredGlassBlock(properties(id)));
	public static final RegistryEntry<Block, Block> SHATTERED_PANE_NONE = REGISTRY.register("shattered_pane_none", id -> new ShatteredPaneNoneBlock(properties(id)));
	public static final RegistryEntry<Block, Block> SHATTERED_PANE_STRAIGHT = REGISTRY.register("shattered_pane_straight", id -> new ShatteredPaneStraightBlock(properties(id)));
	public static final RegistryEntry<Block, Block> SHATTERED_CORNER = REGISTRY.register("shattered_corner", id -> new ShatteredCornerBlock(properties(id)));
	public static final RegistryEntry<Block, Block> SHATTERED_T_CORNER = REGISTRY.register("shattered_t_corner", id -> new ShatteredTCornerBlock(properties(id)));
	public static final RegistryEntry<Block, Block> SHATTERED_PANE_X_CORNER = REGISTRY.register("shattered_pane_x_corner", id -> new ShatteredPaneXCornerBlock(properties(id)));
	public static final RegistryEntry<Block, Block> SHATTERED_PANE_END = REGISTRY.register("shattered_pane_end", id -> new ShatteredPaneEndBlock(properties(id)));

	// 1.21.2: a block knows its id from construction
	private static BlockBehaviour.Properties properties(Identifier id) {
		return BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, id));
	}
}
