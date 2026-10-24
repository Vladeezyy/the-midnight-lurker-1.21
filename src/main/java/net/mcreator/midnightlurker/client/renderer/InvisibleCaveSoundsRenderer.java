package net.mcreator.midnightlurker.client.renderer;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.model.InvisibleCaveSoundsModel;
import net.mcreator.midnightlurker.entity.InvisibleCaveSoundsEntity;

public class InvisibleCaveSoundsRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<InvisibleCaveSoundsEntity, R> {
	public InvisibleCaveSoundsRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new InvisibleCaveSoundsModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(R renderState, Identifier texture) {
		return RenderTypes.entityTranslucent(texture);
	}
}
