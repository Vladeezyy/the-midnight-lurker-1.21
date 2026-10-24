package net.mcreator.midnightlurker.entity.model;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;

import javax.annotation.Nullable;

public class MidnightLurkerWatcherModel extends GeoModel<MidnightLurkerWatcherEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerWatcherEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkerrunaway");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkerrunaway");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(MidnightLurkerWatcherEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
