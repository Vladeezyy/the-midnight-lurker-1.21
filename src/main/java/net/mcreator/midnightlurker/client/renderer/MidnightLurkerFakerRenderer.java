package net.mcreator.midnightlurker.client.renderer;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerFakerModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerFakerLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;

public class MidnightLurkerFakerRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<MidnightLurkerFakerEntity, R> {
	public MidnightLurkerFakerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerFakerModel());
		this.shadowRadius = 0.7f;
		withScale(0.95f);
		withRenderLayer(new MidnightLurkerFakerLayer<>(this));
	}

	@Override
	public RenderType getRenderType(R renderState, Identifier texture) {
		return RenderTypes.entityTranslucent(texture);
	}
}
