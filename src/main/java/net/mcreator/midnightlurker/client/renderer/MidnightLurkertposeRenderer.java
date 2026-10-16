
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightLurkertposeModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkertposeLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkertposeRenderer extends GeoEntityRenderer<MidnightLurkertposeEntity> {
	public MidnightLurkertposeRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkertposeModel());
		this.shadowRadius = 0.7f;
		this.addRenderLayer(new MidnightLurkertposeLayer(this));
	}

	@Override
	public RenderType getRenderType(MidnightLurkertposeEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, MidnightLurkertposeEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
