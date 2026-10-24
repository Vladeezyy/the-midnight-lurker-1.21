package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;

public class Destroytex4Renderer extends MobRenderer<Destroytex4Entity, LivingEntityRenderState, Modeldestroytex> {
	private static final Identifier TEXTURE = Identifier.parse("midnightlurker:textures/entities/destroytex4.png");

	public Destroytex4Renderer(EntityRendererProvider.Context context) {
		super(context, new Modeldestroytex(context.bakeLayer(Modeldestroytex.LAYER_LOCATION)), 0f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return TEXTURE;
	}
}
