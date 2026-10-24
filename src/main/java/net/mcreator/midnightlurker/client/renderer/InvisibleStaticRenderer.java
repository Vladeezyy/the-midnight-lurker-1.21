package net.mcreator.midnightlurker.client.renderer;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.model.InvisibleStaticModel;
import net.mcreator.midnightlurker.entity.InvisibleStaticEntity;

public class InvisibleStaticRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<InvisibleStaticEntity, R> {
	public InvisibleStaticRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new InvisibleStaticModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(R renderState, Identifier texture) {
		return RenderTypes.entityTranslucent(texture);
	}
}
