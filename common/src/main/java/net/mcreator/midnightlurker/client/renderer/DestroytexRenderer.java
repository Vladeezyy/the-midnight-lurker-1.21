package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;

public class DestroytexRenderer extends MobRenderer<DestroytexEntity, LivingEntityRenderState, Modeldestroytex> {
	private static final Identifier TEXTURE = Identifier.parse("midnightlurker:textures/entities/destroytex1.png");

	public DestroytexRenderer(EntityRendererProvider.Context context) {
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
