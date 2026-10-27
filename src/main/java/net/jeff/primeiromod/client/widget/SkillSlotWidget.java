package net.jeff.primeiromod.client.widget;

import net.jeff.primeiromod.PrimeiroMod;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public final class SkillSlotWidget extends AbstractWidget {
	public static final int SIZE = 18;
	private static final Identifier TEXTURE = PrimeiroMod.id("textures/gui/skill_slot.png");

	public SkillSlotWidget(int x, int y) {
		super(x, y, SIZE, SIZE, Component.translatable("widget.primeiro-mod.empty_skill_slot"));
	}

	@Override
	protected void extractWidgetRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
		graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, getX(), getY(), 0, 0, SIZE, SIZE, SIZE, SIZE);
		if (isHoveredOrFocused()) {
			graphics.outline(getX(), getY(), SIZE, SIZE, 0xFF8F5BFF);
		}
	}

	@Override
	protected void updateWidgetNarration(NarrationElementOutput output) {
		output.add(NarratedElementType.TITLE, getMessage());
	}
}
