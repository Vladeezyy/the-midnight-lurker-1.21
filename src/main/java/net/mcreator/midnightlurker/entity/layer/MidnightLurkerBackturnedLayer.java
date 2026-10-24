package net.mcreator.midnightlurker.entity.layer;

import com.geckolib.renderer.layer.builtin.TextureLayerGeoLayer;
import com.geckolib.renderer.base.GeoRenderer;
import com.geckolib.renderer.base.GeoRenderState;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

/** The glowing eyes: the layer texture drawn again with the eyes render type (full bright). */
public class MidnightLurkerBackturnedLayer<R extends LivingEntityRenderState & GeoRenderState> extends TextureLayerGeoLayer<MidnightLurkerBackturnedEntity, Void, R> {
	private static final Identifier LAYER = Identifier.fromNamespaceAndPath("midnightlurker", "textures/entities/midnightlurkervoidgateemissive.png");

	public MidnightLurkerBackturnedLayer(GeoRenderer<MidnightLurkerBackturnedEntity, Void, R> entityRenderer) {
		super(entityRenderer, LAYER, RenderTypes::eyes);
	}
}
