package net.mcreator.midnightlurker.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import net.mcreator.midnightlurker.port.PortUtil;
import net.mcreator.midnightlurker.port.bus.ClientEventIndex;
import net.mcreator.midnightlurker.port.bus.ClientTickEvent;
import net.mcreator.midnightlurker.port.bus.EntityJoinLevelEvent;
import net.mcreator.midnightlurker.port.bus.EntityLeaveLevelEvent;
import net.mcreator.midnightlurker.port.bus.EntityRenderersEvent;
import net.mcreator.midnightlurker.port.bus.LurkerBus;
import net.mcreator.midnightlurker.port.bus.RegisterMenuScreensEvent;
import net.mcreator.midnightlurker.port.bus.RegisterParticleProvidersEvent;
import net.mcreator.midnightlurker.port.bus.ScreenEvent;

/** Fabric client entry point: renderers, screens, packets and the client events posted on {@link LurkerBus} */
public final class MidnightlurkerFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientEventIndex.register();
		PortUtil.clientRegistries = () -> Minecraft.getInstance().level == null ? null : Minecraft.getInstance().level.registryAccess();
		PortUtil.clientPlayer = () -> Minecraft.getInstance().player;
		FabricPlatform.CLIENTBOUND.forEach(MidnightlurkerFabricClient::receive);

		LurkerBus.post(new EntityRenderersEvent.RegisterRenderers(new EntityRenderersEvent.RegisterRenderers.Sink() {
			@Override
			public <T extends Entity> void register(EntityType<? extends T> type, EntityRendererProvider<T> provider) {
				EntityRendererRegistry.register(type, provider);
			}
		}));
		LurkerBus.post(new EntityRenderersEvent.RegisterLayerDefinitions((location, definition) -> EntityModelLayerRegistry.registerModelLayer(location, definition::get)));
		LurkerBus.post(new RegisterParticleProvidersEvent(new RegisterParticleProvidersEvent.Sink() {
			@Override
			public <T extends ParticleOptions> void register(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> registration) {
				ParticleFactoryRegistry.getInstance().register(type, registration::create);
			}
		}));
		LurkerBus.post(new RegisterMenuScreensEvent(MenuScreens::register));

		ClientTickEvents.END_CLIENT_TICK.register(minecraft -> LurkerBus.post(new ClientTickEvent.Post()));
		ScreenEvents.AFTER_INIT.register((minecraft, screen, width, height) -> ScreenEvents.afterRender(screen)
				.register((s, guiGraphics, mouseX, mouseY, partialTick) -> LurkerBus.post(new ScreenEvent.Render.Post(s, guiGraphics))));
		ClientEntityEvents.ENTITY_LOAD.register((entity, level) -> LurkerBus.post(new EntityJoinLevelEvent(entity, level)));
		ClientEntityEvents.ENTITY_UNLOAD.register((entity, level) -> LurkerBus.post(new EntityLeaveLevelEvent(entity, level)));
	}

	private static <T extends CustomPacketPayload> void receive(FabricPlatform.Clientbound<T> packet) {
		ClientPlayNetworking.registerGlobalReceiver(packet.type(), (payload, context) -> packet.handler().accept(payload));
	}
}
