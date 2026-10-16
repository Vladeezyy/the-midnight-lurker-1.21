
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerInvisibleModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerInvisibleLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkerInvisibleRenderer extends GeoEntityRenderer<MidnightLurkerInvisibleEntity> {
	public MidnightLurkerInvisibleRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerInvisibleModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new MidnightLurkerInvisibleLayer(this));
	}

	@Override
	public RenderType getRenderType(MidnightLurkerInvisibleEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, MidnightLurkerInvisibleEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
