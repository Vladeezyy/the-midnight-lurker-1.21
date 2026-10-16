
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerHiderModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerHiderLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkerHiderRenderer extends GeoEntityRenderer<MidnightLurkerHiderEntity> {
	public MidnightLurkerHiderRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerHiderModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new MidnightLurkerHiderLayer(this));
	}

	@Override
	public RenderType getRenderType(MidnightLurkerHiderEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, MidnightLurkerHiderEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
