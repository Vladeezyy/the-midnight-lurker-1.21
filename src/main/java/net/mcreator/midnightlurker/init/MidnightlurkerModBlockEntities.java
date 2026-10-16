
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.midnightlurker.block.entity.ShatteredTCornerBlockEntity;
import net.mcreator.midnightlurker.block.entity.ShatteredPaneXCornerBlockEntity;
import net.mcreator.midnightlurker.block.entity.ShatteredPaneStraightBlockEntity;
import net.mcreator.midnightlurker.block.entity.ShatteredPaneNoneBlockEntity;
import net.mcreator.midnightlurker.block.entity.ShatteredPaneEndBlockEntity;
import net.mcreator.midnightlurker.block.entity.ShatteredCornerBlockEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MidnightlurkerMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SHATTERED_PANE_NONE = register("shattered_pane_none", MidnightlurkerModBlocks.SHATTERED_PANE_NONE, ShatteredPaneNoneBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SHATTERED_PANE_STRAIGHT = register("shattered_pane_straight", MidnightlurkerModBlocks.SHATTERED_PANE_STRAIGHT, ShatteredPaneStraightBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SHATTERED_CORNER = register("shattered_corner", MidnightlurkerModBlocks.SHATTERED_CORNER, ShatteredCornerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SHATTERED_T_CORNER = register("shattered_t_corner", MidnightlurkerModBlocks.SHATTERED_T_CORNER, ShatteredTCornerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SHATTERED_PANE_X_CORNER = register("shattered_pane_x_corner", MidnightlurkerModBlocks.SHATTERED_PANE_X_CORNER, ShatteredPaneXCornerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SHATTERED_PANE_END = register("shattered_pane_end", MidnightlurkerModBlocks.SHATTERED_PANE_END, ShatteredPaneEndBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
