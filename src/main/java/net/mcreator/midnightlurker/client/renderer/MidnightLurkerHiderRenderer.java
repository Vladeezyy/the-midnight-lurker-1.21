package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerHiderModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerHiderLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;

public class MidnightLurkerHiderRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<MidnightLurkerHiderEntity, R> {
	public MidnightLurkerHiderRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerHiderModel());
		this.shadowRadius = 0f;
		withScale(0.95f);
		withRenderLayer(new MidnightLurkerHiderLayer<>(this));
	}

	@Override
	public RenderType getRenderType(R renderState, Identifier texture) {
		return RenderTypes.entityTranslucent(texture);
	}
}
