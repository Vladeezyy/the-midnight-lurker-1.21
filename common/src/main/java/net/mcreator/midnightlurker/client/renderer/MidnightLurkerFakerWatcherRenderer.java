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

import net.mcreator.midnightlurker.entity.model.MidnightLurkerFakerWatcherModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerFakerWatcherLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;

public class MidnightLurkerFakerWatcherRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<MidnightLurkerFakerWatcherEntity, R> {
	public MidnightLurkerFakerWatcherRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerFakerWatcherModel());
		this.shadowRadius = 0.7f;
		withScale(0.95f);
		withRenderLayer(new MidnightLurkerFakerWatcherLayer<>(this));
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
