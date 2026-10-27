package net.jeff.primeiromod.client.screen;

import net.jeff.primeiromod.PrimeiroMod;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;

public final class SkillInfoPanel {
	public static final int WIDTH = 112;
	public static final int HEIGHT = 142;
	private static final Identifier TEXTURE = PrimeiroMod.id("textures/gui/skill_info_panel.png");

	private boolean visible;

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void extractRenderState(GuiGraphicsExtractor graphics, int x, int y) {
		if (!visible) {
			return;
		}
		graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, WIDTH, HEIGHT, WIDTH, HEIGHT);
	}
}
