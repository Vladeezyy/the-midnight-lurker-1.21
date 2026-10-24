package net.mcreator.midnightlurker.port;

import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.levelgen.presets.WorldPresets;
import net.minecraft.world.level.levelgen.WorldOptions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.WorldDataConfiguration;
import net.minecraft.world.level.LevelSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.CloudStatus;

import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;

/**
 * Server tick check ({@code ./gradlew runPerf}), inert unless {@code midnightlurker.perf} is set: a new world in
 * survival mode, then the average server tick time (MSPT) at night with natural spawning in the overworld, in the
 * nether (where players reported the worst lag), and with 20 Lurkers of every kind around the player. Logs
 * {@code [perf] PERF} lines, then quits; {@code -Pjfr} records a flight recording to run/perf.jfr.
 */
@EventBusSubscriber(value = Dist.CLIENT)
public final class PerfScene {
	private static final boolean ENABLED = System.getProperty("midnightlurker.perf") != null;
	private record Step(int at, Consumer<Minecraft> action) {
	}
	private static final List<Step> STEPS = new ArrayList<>();
	private static boolean opened, measuring;
	private static int tick, samples;
	private static long nanos, worst;

	private static void at(int t, Consumer<Minecraft> action) {
		STEPS.add(new Step(t, action));
	}

	private static void server(Minecraft mc, Consumer<ServerPlayer> action) {
		var server = mc.getSingleplayerServer();
		server.execute(() -> {
			try {
				action.accept(server.getPlayerList().getPlayer(mc.player.getUUID()));
			} catch (RuntimeException e) {
				MidnightlurkerMod.LOGGER.error("[perf] server step failed", e);
			}
		});
	}

	private static void start() {
		nanos = worst = 0;
		samples = 0;
		measuring = true;
	}

	private static void stop(Minecraft mc, String name) {
		measuring = false;
		var server = mc.getSingleplayerServer();
		int entities = 0;
		for (ServerLevel level : server.getAllLevels())
			for (Entity e : level.getAllEntities())
				entities++;
		MidnightlurkerMod.LOGGER.info(String.format("[perf] PERF %s: %.2f ms per server tick (worst 100-tick average %.2f ms), %d entities", name,
				nanos / (double) Math.max(1, samples) / 1e6, worst / 1e6, entities));
	}

	static {
		int t = 40;
		at(t, mc -> server(mc, p -> {
			ServerLevel level = p.level();
			level.getGameRules().set(GameRules.ADVANCE_TIME, false, level.getServer());
			level.getGameRules().set(GameRules.ADVANCE_WEATHER, false, level.getServer());
			level.getGameRules().set(GameRules.SPAWN_MOBS, true, level.getServer());
			level.getServer().getCommands().performPrefixedCommand(level.getServer().createCommandSourceStack().withSuppressedOutput(), "time set 18000");
			// creative: natural spawning happens around the player (not around spectators), nothing hurts the player
			p.setGameMode(GameType.CREATIVE);
			p.setInvulnerable(true);
			BlockPos spawn = level.getRespawnData().pos();
			p.teleportTo(level, spawn.getX() + 0.5, level.getHeight(net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING, spawn.getX(), spawn.getZ()) + 2, spawn.getZ() + 0.5, java.util.Set.of(), 0, 20, true);
		}));
		// chunks load and the first spawns settle before measuring
		at(t += 600, mc -> start());
		at(t += 1200, mc -> {
			stop(mc, "overworld, night, natural spawning");
			// the natural spawn checks themselves (run once per spawn attempt of these entities), timed directly
			server(mc, p -> {
				ServerLevel level = p.level();
				double x = p.getX() + 24, y = p.getY(), z = p.getZ() + 24;
				String[] names = {"MidnightLurker", "MidnightLurkerFakerWatcher", "VoidGateway", "MidnightLurkerShadow"};
				for (String name : names) {
					try {
						var m = Class.forName("net.mcreator.midnightlurker.procedures." + name + "NaturalEntitySpawningConditionProcedure")
								.getMethod("execute", net.minecraft.world.level.LevelAccessor.class, double.class, double.class, double.class);
						for (int i = 0; i < 50; i++)
							m.invoke(null, level, x, y, z);
						long start = System.nanoTime();
						for (int i = 0; i < 200; i++)
							m.invoke(null, level, x + (i % 7), y, z + (i % 5));
						MidnightlurkerMod.LOGGER.info(String.format("[perf] PERF spawn check %s: %.1f us per call", name, (System.nanoTime() - start) / 200.0 / 1000.0));
					} catch (ReflectiveOperationException e) {
						MidnightlurkerMod.LOGGER.error("[perf] spawn check {} failed", name, e);
					}
				}
			});
			server(mc, p -> {
				ServerLevel nether = p.level().getServer().getLevel(Level.NETHER);
				nether.getGameRules().set(GameRules.SPAWN_MOBS, true, nether.getServer());
				BlockPos pos = new BlockPos(0, 64, 0);
				for (BlockPos q : BlockPos.betweenClosed(pos.offset(-2, -1, -2), pos.offset(2, 3, 2)))
					nether.setBlock(q, q.getY() == pos.getY() - 1 ? Blocks.NETHERRACK.defaultBlockState() : Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS);
				p.teleportTo(nether, 0.5, 64, 0.5, java.util.Set.of(), 0, 20, true);
			});
		});
		// the nether chunks generate first
		at(t += 900, mc -> start());
		at(t += 1200, mc -> {
			stop(mc, "nether, natural spawning");
			server(mc, p -> {
				ServerLevel level = p.level().getServer().overworld();
				level.getGameRules().set(GameRules.SPAWN_MOBS, false, level.getServer());
				// above the spawn: chunks already generated in the first phase
				BlockPos base = new BlockPos(level.getRespawnData().pos().getX(), 200, level.getRespawnData().pos().getZ());
				for (BlockPos q : BlockPos.betweenClosed(base.offset(-12, -1, -12), base.offset(12, 4, 12)))
					level.setBlock(q, q.getY() == base.getY() - 1 ? Blocks.STONE.defaultBlockState() : Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS);
				p.teleportTo(level, base.getX() + 0.5, base.getY() + 8, base.getZ() + 0.5, java.util.Set.of(), 0, 60, true);
				List<EntityType<?>> types = new ArrayList<>();
				for (EntityType<?> type : BuiltInRegistries.ENTITY_TYPE)
					if (BuiltInRegistries.ENTITY_TYPE.getKey(type).getPath().startsWith("midnight_lurker") || BuiltInRegistries.ENTITY_TYPE.getKey(type).getPath().startsWith("midnightlurker"))
						types.add(type);
				for (int i = 0; i < 20; i++) {
					Entity e = types.get(i % types.size()).create(level, EntitySpawnReason.COMMAND);
					if (e == null)
						continue;
					e.snapTo(base.getX() - 9.5 + (i % 5) * 4, base.getY(), base.getZ() - 8.5 + (i / 5) * 4, 0, 0);
					if (e instanceof Mob mob) {
						mob.finalizeSpawn(level, level.getCurrentDifficultyAt(base), EntitySpawnReason.COMMAND, null);
						mob.setPersistenceRequired();
					}
					level.addFreshEntity(e);
				}
				MidnightlurkerMod.LOGGER.info("[perf] {} Lurker kinds placed", types.size());
			});
		});
		at(t += 400, mc -> start());
		at(t += 1200, mc -> stop(mc, "20 Lurkers around the player"));
		at(t += 20, mc -> {
			MidnightlurkerMod.LOGGER.info("[perf] DONE");
			mc.level.disconnect(net.minecraft.network.chat.Component.empty());
			mc.disconnect(new TitleScreen(), false);
			mc.stop();
		});
	}

	@SubscribeEvent
	public static void onClientTick(ClientTickEvent.Post event) {
		if (!ENABLED)
			return;
		Minecraft mc = Minecraft.getInstance();
		if (!opened && mc.screen instanceof net.minecraft.client.gui.screens.AccessibilityOnboardingScreen) {
			mc.options.onboardAccessibility = false;
			mc.options.save();
			mc.setScreen(new TitleScreen());
			return;
		}
		if (!opened && mc.getOverlay() != null)
			return;
		if (!opened && mc.screen instanceof TitleScreen) {
			opened = true;
			mc.options.cloudStatus().set(CloudStatus.OFF);
			mc.options.pauseOnLostFocus = false;
			LevelSettings settings = new LevelSettings("ml_perf", GameType.SURVIVAL, new LevelSettings.DifficultySettings(Difficulty.NORMAL, false, false), true, WorldDataConfiguration.DEFAULT);
			mc.createWorldOpenFlows().createFreshLevel("ml_perf", settings, new WorldOptions(20261017L, true, false), WorldPresets::createNormalWorldDimensions, new TitleScreen());
			return;
		}
		if (mc.player == null || mc.getSingleplayerServer() == null)
			return;
		mc.options.pauseOnLostFocus = false;
		if (mc.screen instanceof PauseScreen)
			mc.setScreen(null);
		if (measuring) {
			long avg = mc.getSingleplayerServer().getAverageTickTimeNanos();
			nanos += avg;
			worst = Math.max(worst, avg);
			samples++;
		}
		tick++;
		for (Step step : STEPS)
			if (step.at() == tick)
				try {
					step.action().accept(mc);
				} catch (RuntimeException e) {
					MidnightlurkerMod.LOGGER.error("[perf] step at tick {} failed", tick, e);
				}
	}

	private PerfScene() {
	}
}
