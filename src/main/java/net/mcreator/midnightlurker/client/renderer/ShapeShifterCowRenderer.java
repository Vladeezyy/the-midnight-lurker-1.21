package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.animal.cow.CowModel;

import net.mcreator.midnightlurker.entity.ShapeShifterCowEntity;

public class ShapeShifterCowRenderer extends MobRenderer<ShapeShifterCowEntity, LivingEntityRenderState, CowModel> {
	private static final Identifier TEXTURE = Identifier.parse("midnightlurker:textures/entities/shapeshiftercow.png");

	public ShapeShifterCowRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0.7f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return TEXTURE;
	}
}
