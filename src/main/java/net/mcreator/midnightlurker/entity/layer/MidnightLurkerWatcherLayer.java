package net.mcreator.midnightlurker.entity.layer;

import com.geckolib.renderer.layer.builtin.TextureLayerGeoLayer;
import com.geckolib.renderer.base.GeoRenderer;
import com.geckolib.renderer.base.GeoRenderState;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;

/** The glowing eyes: the layer texture drawn again with the eyes render type (full bright). */
public class MidnightLurkerWatcherLayer<R extends LivingEntityRenderState & GeoRenderState> extends TextureLayerGeoLayer<MidnightLurkerWatcherEntity, Void, R> {
	private static final Identifier LAYER = Identifier.fromNamespaceAndPath("midnightlurker", "textures/entities/midnightlurkervoidgatenomouthglow.png");

	public MidnightLurkerWatcherLayer(GeoRenderer<MidnightLurkerWatcherEntity, Void, R> entityRenderer) {
		super(entityRenderer, LAYER, RenderTypes::eyes);
	}
}
