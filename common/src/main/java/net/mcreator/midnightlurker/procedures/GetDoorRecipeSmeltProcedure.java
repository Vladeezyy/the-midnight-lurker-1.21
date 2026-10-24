package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.PlayerEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GetDoorRecipeSmeltProcedure {
	@SubscribeEvent
	public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
		execute(event, event.getEntity(), event.getSmelting());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player && (itemstack.getItem() == Items.IRON_INGOT || itemstack.getItem() == Items.IRON_NUGGET || itemstack.getItem() == Blocks.IRON_BLOCK.asItem())) {
			if (!(new Object() {
				public boolean hasRecipe(Entity _ent, Identifier recipe) {
					// 1.21.2: recipes are keys, and the client no longer knows the unlocked recipes (it only asks to award them on the server)
					if (_ent instanceof ServerPlayer _player)
						return _player.getRecipeBook().contains(ResourceKey.create(Registries.RECIPE, recipe));
					return true;
				}
			}.hasRecipe(entity, Identifier.parse("midnightlurker:metal_door_recipe")))) {
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(java.util.List.of(ResourceKey.create(Registries.RECIPE, Identifier.parse("midnightlurker:metal_door_recipe"))));
			}
		}
	}
}
