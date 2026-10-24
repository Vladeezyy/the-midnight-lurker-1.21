package net.mcreator.midnightlurker.port;

import net.minecraft.resources.Identifier;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import net.minecraft.client.renderer.RenderPipelines;

/** The 1.20 ImageButton (one texture, hovered / disabled states stacked vertically), which 1.21 replaced by sprites. */
public class PortImageButton extends ImageButton {
	private final Identifier texture;
	private final int xTexStart;
	private final int yTexStart;
	private final int yDiffTex;
	private final int textureWidth;
	private final int textureHeight;

	public PortImageButton(int x, int y, int width, int height, int xTexStart, int yTexStart, int yDiffTex, Identifier texture, int textureWidth, int textureHeight, OnPress onPress) {
		super(x, y, width, height, new WidgetSprites(texture, texture), onPress);
		this.texture = texture;
		this.xTexStart = xTexStart;
		this.yTexStart = yTexStart;
		this.yDiffTex = yDiffTex;
		this.textureWidth = textureWidth;
		this.textureHeight = textureHeight;
	}

	@Override
	public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTick) {
		int v = this.yTexStart;
		if (!this.isActive())
			v += this.yDiffTex * 2;
		else if (this.isHoveredOrFocused())
			v += this.yDiffTex;
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, this.texture, this.getX(), this.getY(), (float) this.xTexStart, (float) v, this.width, this.height, this.textureWidth, this.textureHeight);
	}
}
