package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.VillagerRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.npc.VillagerModel;
import net.minecraft.client.model.geom.ModelLayers;

import net.mcreator.midnightlurker.entity.VillagerOutcastEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class VillagerOutcastRenderer extends MobRenderer<VillagerOutcastEntity, VillagerRenderState, VillagerModel> {
	private static final Identifier TEXTURE = Identifier.parse("midnightlurker:textures/entities/outcast_villager.png");

	public VillagerOutcastRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
	}

	@Override
	public VillagerRenderState createRenderState() {
		return new VillagerRenderState();
	}

	@Override
	protected void scale(VillagerRenderState state, PoseStack poseStack) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public Identifier getTextureLocation(VillagerRenderState state) {
		return TEXTURE;
	}
}
