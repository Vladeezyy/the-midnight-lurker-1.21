package net.mcreator.midnightlurker.procedures;

import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.bus.FMLPaths;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.PlayerTickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@EventBusSubscriber
public class JumpscareTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		return execute(null, world, x, y, z, entity);
	}

	private static boolean execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("jumpscare_sound").getAsBoolean() == true) {
					if (MidnightlurkerModVariables.of(entity).JumpscareTimer == 31
							&& MidnightlurkerModVariables.of(entity).JumpscareActive > 0) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, Component.literal(""), _level.getServer()).withSuppressedOutput(),
									"/playsound midnightlurker:lurkerjumpscare neutral @p");
					}
				}
				if (mainjsonobject.get("pop_up_jumpscare").getAsBoolean() == true) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("pop_up_jumpscare").getAsBoolean() == false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (MidnightlurkerModVariables.of(entity).JumpscareActive == 1) {
			if (MidnightlurkerModVariables.of(entity).JumpscareTimer == 0) {
				{
					double _setval = 46;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.JumpscareTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (MidnightlurkerModVariables.of(entity).JumpscareActive == 1
				&& MidnightlurkerModVariables.of(entity).JumpscareTimer == 1) {
			{
				double _setval = 0;
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.JumpscareActive = _setval;
				_vars.syncPlayerVariables(entity);
			}
			{
				double _setval = Mth.nextInt(RandomSource.create(), 0, 2);
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.JumpscareRandom = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (MidnightlurkerModVariables.of(entity).JumpscareTimer > 0) {
			{
				double _setval = MidnightlurkerModVariables.of(entity).JumpscareTimer - 1;
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.JumpscareTimer = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (MidnightlurkerModVariables.of(entity).JumpscareActive == 1
				&& MidnightlurkerModVariables.of(entity).JumpscareTimer <= 29
				&& MidnightlurkerModVariables.of(entity).JumpscareTimer >= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY.holder(), 155, 0, false, false));
			world.addParticle((SimpleParticleType) (MidnightlurkerModParticleTypes.LURKERFACEPARTICLE.get()), (x + Mth.nextDouble(RandomSource.create(), -6, 6)), (y + Mth.nextDouble(RandomSource.create(), 0, 6)),
					(z + Mth.nextDouble(RandomSource.create(), -6, 6)), 0, 0, 0);
		}
		if (MidnightlurkerModVariables.of(entity).JumpscareTimer > 0 && mainjsonobject.get("pop_up_jumpscare").getAsBoolean() == true) {
			return true;
		} else if (MidnightlurkerModVariables.of(entity).JumpscareTimer > 0 && mainjsonobject.get("pop_up_jumpscare").getAsBoolean() == false) {
			return false;
		}
		return false;
	}
}
