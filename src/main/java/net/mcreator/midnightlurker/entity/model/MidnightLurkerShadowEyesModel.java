package net.mcreator.midnightlurker.entity.model;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;

import javax.annotation.Nullable;

public class MidnightLurkerShadowEyesModel extends GeoModel<MidnightLurkerShadowEyesEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerShadowEyesEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkershadow");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkershadow");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(MidnightLurkerShadowEyesEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
