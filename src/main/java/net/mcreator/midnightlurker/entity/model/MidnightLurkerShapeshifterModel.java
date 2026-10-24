package net.mcreator.midnightlurker.entity.model;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;

import javax.annotation.Nullable;

public class MidnightLurkerShapeshifterModel extends GeoModel<MidnightLurkerShapeshifterEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerShapeshifterEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkershapeshifter");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkershapeshifter");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(MidnightLurkerShapeshifterEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
