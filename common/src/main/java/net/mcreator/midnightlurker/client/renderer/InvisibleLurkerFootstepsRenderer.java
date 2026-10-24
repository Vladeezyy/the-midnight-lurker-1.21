package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.model.InvisibleLurkerFootstepsModel;
import net.mcreator.midnightlurker.entity.InvisibleLurkerFootstepsEntity;

public class InvisibleLurkerFootstepsRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<InvisibleLurkerFootstepsEntity, R> {
	public InvisibleLurkerFootstepsRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new InvisibleLurkerFootstepsModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(R renderState, Identifier texture) {
		return RenderTypes.entityTranslucent(texture);
	}
}
