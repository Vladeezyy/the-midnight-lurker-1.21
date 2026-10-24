package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class InsanitysoundsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanitySounds") < 159) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanitySounds", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanitySounds") + 1));
		} else if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanitySounds") >= 159) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanitySounds", 0);
		}
		if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())) && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanitySounds") > 0) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanitySounds", 0);
		}
		if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())
				&& MidnightlurkerModVariables.of(entity).InsanityStage < 7) {
			if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanitySounds") == 1
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) > 20) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:insanityambience neutral @p");
			}
		} else if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())
				&& MidnightlurkerModVariables.of(entity).InsanityStage >= 7) {
			if (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanitySounds") == 1
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) > 20) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:insanitychase neutral @p");
			}
		}
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("show_insanity_effect_in_inv").getAsBoolean() == true) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_SHOWIN_INV.holder(), 8, 0, false, false));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
