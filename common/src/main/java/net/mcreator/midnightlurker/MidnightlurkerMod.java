/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package net.mcreator.midnightlurker;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.util.Tuple;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModTabs;
import net.mcreator.midnightlurker.init.MidnightlurkerModSounds;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModMenus;
import net.mcreator.midnightlurker.init.MidnightlurkerModItems;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModBlocks;
import net.mcreator.midnightlurker.init.MidnightlurkerModBlockEntities;
import net.mcreator.midnightlurker.port.bus.EventIndex;
import net.mcreator.midnightlurker.port.bus.EventPriority;
import net.mcreator.midnightlurker.port.bus.LurkerBus;
import net.mcreator.midnightlurker.port.bus.ServerTickEvent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

/** The mod's common init; the NeoForge and Fabric entry points call {@link #init()} first */
public class MidnightlurkerMod {
	public static final Logger LOGGER = LogManager.getLogger(MidnightlurkerMod.class);
	public static final String MODID = "midnightlurker";

	private static boolean initialized;

	public static void init() {
		if (initialized)
			return;
		initialized = true;
		// the registry classes queue their entries (Registrar) when loaded, in MCreator's order
		MidnightlurkerModSounds.REGISTRY.getRegistryKey();
		MidnightlurkerModBlocks.REGISTRY.getRegistryKey();
		MidnightlurkerModBlockEntities.REGISTRY.getRegistryKey();
		MidnightlurkerModItems.REGISTRY.getRegistryKey();
		MidnightlurkerModEntities.REGISTRY.getRegistryKey();
		MidnightlurkerModTabs.REGISTRY.getRegistryKey();
		MidnightlurkerModMobEffects.REGISTRY.getRegistryKey();
		MidnightlurkerModParticleTypes.REGISTRY.getRegistryKey();
		MidnightlurkerModMenus.REGISTRY.getRegistryKey();
		MidnightlurkerModVariables.registerPackets();
		EventIndex.register();
		LurkerBus.add(ServerTickEvent.Post.class, EventPriority.NORMAL, MidnightlurkerMod::tick);
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	/** Runs {@code action} after {@code tick} server ticks (only when called on the server thread, as in MCreator) */
	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getName().equals("Server thread"))
			workQueue.add(new Tuple<>(action, tick));
	}

	private static void tick(ServerTickEvent.Post event) {
		List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setB(work.getB() - 1);
			if (work.getB() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getA().run());
		workQueue.removeAll(actions);
	}
}
