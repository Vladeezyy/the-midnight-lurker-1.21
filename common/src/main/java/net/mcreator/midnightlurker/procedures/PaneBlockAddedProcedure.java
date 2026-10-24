package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class PaneBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String groupTag = "";
		String gateTag = "";
		groupTag = "forge" + ":" + "custom_pane";
		gateTag = "forge" + ":" + "custom_gate";
		if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(BlockPos.containing(x, y, z - 1))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((gateTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			PaneMainScriptProcedure.execute(world, x, y, (z - 1));
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(BlockPos.containing(x + 1, y, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((gateTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			PaneMainScriptProcedure.execute(world, (x + 1), y, z);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(BlockPos.containing(x, y, z + 1))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((gateTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			PaneMainScriptProcedure.execute(world, x, y, (z + 1));
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(BlockPos.containing(x - 1, y, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((gateTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			PaneMainScriptProcedure.execute(world, (x - 1), y, z);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((groupTag).toLowerCase(java.util.Locale.ENGLISH))))
				&& !(world.getBlockState(BlockPos.containing(x, y, z))).is(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.BLOCK, Identifier.parse((gateTag).toLowerCase(java.util.Locale.ENGLISH))))) {
			PaneMainScriptProcedure.execute(world, x, y, z);
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return net.mcreator.midnightlurker.port.PortUtil.data(blockEntity).getDoubleOr(tag, 0);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "Regen") < 600) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					net.mcreator.midnightlurker.port.PortUtil.data(_blockEntity).putDouble("Regen", (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return net.mcreator.midnightlurker.port.PortUtil.data(blockEntity).getDoubleOr(tag, 0);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "Regen") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return net.mcreator.midnightlurker.port.PortUtil.data(blockEntity).getDoubleOr(tag, 0);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "Regen") >= 600) {
			if (!world.isClientSide()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = Blocks.GLASS_PANE.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property.Value<?> entry : _bso.getValues().toList()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.property().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.value());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				if (world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("east") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
				}
				if (world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("west") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
				}
				if (world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("south") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
				}
				if (world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("north") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
				}
			}
		}
	}
}
