package net.mcreator.midnightlurker.client.renderer;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.model.VoidHandsModel;
import net.mcreator.midnightlurker.entity.VoidHandsEntity;

public class VoidHandsRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<VoidHandsEntity, R> {
	public VoidHandsRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new VoidHandsModel());
		this.shadowRadius = 0f;
		withScale(0.95f);
	}

	@Override
	public RenderType getRenderType(R renderState, Identifier texture) {
		return RenderTypes.entityTranslucent(texture);
	}
}
