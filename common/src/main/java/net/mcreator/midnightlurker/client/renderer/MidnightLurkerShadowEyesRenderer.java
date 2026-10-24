package net.mcreator.midnightlurker.client.renderer;

import com.geckolib.renderer.base.RenderPassInfo;
import com.geckolib.renderer.base.BoneSnapshots;
import com.geckolib.constant.DefaultAnimations;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerShadowEyesModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerShadowEyesLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;

public class MidnightLurkerShadowEyesRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<MidnightLurkerShadowEyesEntity, R> {
	public MidnightLurkerShadowEyesRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerShadowEyesModel());
		this.shadowRadius = 0.7f;
		withScale(0.95f);
		withRenderLayer(new MidnightLurkerShadowEyesLayer<>(this));
	}

	@Override
	public RenderType getRenderType(R renderState, Identifier texture) {
		return RenderTypes.entityTranslucent(texture);
	}

	@Override
	public void adjustModelBonesForRender(RenderPassInfo<R> renderPassInfo, BoneSnapshots snapshots) {
		DefaultAnimations.hardcodedHeadRotation(renderPassInfo, snapshots, "head");
	}
}
