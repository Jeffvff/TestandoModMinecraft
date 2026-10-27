package net.jeff.primeiromod.client.screen;

import net.jeff.primeiromod.PrimeiroMod;
import net.jeff.primeiromod.client.keybind.VoidKeyBindings;
import net.jeff.primeiromod.client.widget.SkillSlotWidget;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public final class VoidSkillScreen extends Screen {
	private static final Identifier BACKGROUND = PrimeiroMod.id("textures/gui/void_skill_inventory.png");
	private static final int MAIN_WIDTH = 194;
	private static final int MAIN_HEIGHT = 142;
	private static final int PANEL_GAP = 8;
	private static final int TOP_SLOT_X = 16;
	private static final int TOP_SLOT_Y = 26;
	private static final int TOP_SLOT_STEP = 37;
	private static final int GRID_X = 16;
	private static final int GRID_Y = 78;

	private final SkillInfoPanel infoPanel = new SkillInfoPanel();
	private int mainX;
	private int mainY;

	public VoidSkillScreen() {
		super(Component.translatable("screen.primeiro-mod.void_skills"));
	}

	@Override
	protected void init() {
		int completeWidth = MAIN_WIDTH + PANEL_GAP + SkillInfoPanel.WIDTH;
		mainX = width >= completeWidth + 16 ? (width - completeWidth) / 2 : (width - MAIN_WIDTH) / 2;
		mainY = (height - MAIN_HEIGHT) / 2;

		for (int index = 0; index < 5; index++) {
			addRenderableWidget(new SkillSlotWidget(mainX + TOP_SLOT_X + index * TOP_SLOT_STEP, mainY + TOP_SLOT_Y));
		}

		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				addRenderableWidget(new SkillSlotWidget(
						mainX + GRID_X + column * SkillSlotWidget.SIZE,
						mainY + GRID_Y + row * SkillSlotWidget.SIZE
				));
			}
		}

		infoPanel.setVisible(false);
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
		graphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, mainX, mainY, 0, 0, MAIN_WIDTH, MAIN_HEIGHT, MAIN_WIDTH, MAIN_HEIGHT);
		super.extractRenderState(graphics, mouseX, mouseY, partialTick);

		for (int index = 0; index < 5; index++) {
			Component keyName = VoidKeyBindings.skill(index).getTranslatedKeyMessage();
			int centerX = mainX + TOP_SLOT_X + index * TOP_SLOT_STEP + SkillSlotWidget.SIZE / 2;
			graphics.centeredText(font, keyName, centerX, mainY + 12, 0xFF3F245E);
		}

		infoPanel.extractRenderState(graphics, mainX + MAIN_WIDTH + PANEL_GAP, mainY);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		if (VoidKeyBindings.OPEN_MENU.matches(event)) {
			VoidKeyBindings.discardMenuClicks();
			onClose();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}
}
