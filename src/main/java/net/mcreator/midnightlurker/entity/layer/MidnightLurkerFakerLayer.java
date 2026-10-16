package net.mcreator.midnightlurker.entity.layer;

import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkerFakerLayer extends GeoRenderLayer<MidnightLurkerFakerEntity> {
	private static final ResourceLocation LAYER = new ResourceLocation("midnightlurker", "textures/entities/midnightlurkerglow.png");

	public MidnightLurkerFakerLayer(GeoRenderer<MidnightLurkerFakerEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, MidnightLurkerFakerEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
		RenderType glowRenderType = RenderType.eyes(LAYER);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
	}
}
