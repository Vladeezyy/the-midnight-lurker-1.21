package net.mcreator.midnightlurker.entity.model;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;

import javax.annotation.Nullable;

public class MidnightLurkerSeenAngressiveModel extends GeoModel<MidnightLurkerSeenAngressiveEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerSeenAngressiveEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkernormal");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkernormal");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(MidnightLurkerSeenAngressiveEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
