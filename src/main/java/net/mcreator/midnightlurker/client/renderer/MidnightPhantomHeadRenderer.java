
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightPhantomHeadModel;
import net.mcreator.midnightlurker.entity.MidnightPhantomHeadEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightPhantomHeadRenderer extends GeoEntityRenderer<MidnightPhantomHeadEntity> {
	public MidnightPhantomHeadRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightPhantomHeadModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(MidnightPhantomHeadEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, MidnightPhantomHeadEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
