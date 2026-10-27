package net.jeff.primeiromod.client.keybind;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.jeff.primeiromod.PrimeiroMod;
import net.minecraft.client.KeyMapping;

import java.util.List;

public final class VoidKeyBindings {
	private static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(PrimeiroMod.id("void"));

	public static final KeyMapping OPEN_MENU = key("open_void", InputConstants.KEY_P);
	public static final KeyMapping SKILL_1 = key("skill_1", InputConstants.KEY_Z);
	public static final KeyMapping SKILL_2 = key("skill_2", InputConstants.KEY_X);
	public static final KeyMapping SKILL_3 = key("skill_3", InputConstants.KEY_C);
	public static final KeyMapping SKILL_4 = key("skill_4", InputConstants.KEY_V);
	public static final KeyMapping SKILL_5 = key("skill_5", InputConstants.KEY_B);

	private static final List<KeyMapping> SKILL_KEYS = List.of(SKILL_1, SKILL_2, SKILL_3, SKILL_4, SKILL_5);

	private VoidKeyBindings() {
	}

	private static KeyMapping key(String name, int defaultKey) {
		return new KeyMapping(
				"key." + PrimeiroMod.MOD_ID + "." + name,
				InputConstants.Type.KEYBOARD,
				defaultKey,
				CATEGORY
		);
	}

	public static void initialize() {
		KeyMappingHelper.registerKeyMapping(OPEN_MENU);
		SKILL_KEYS.forEach(KeyMappingHelper::registerKeyMapping);
	}

	public static KeyMapping skill(int index) {
		return SKILL_KEYS.get(index);
	}

	public static void discardMenuClicks() {
		while (OPEN_MENU.consumeClick()) {
			// Remove cliques acumulados para a mesma tecla não reabrir a tela imediatamente.
		}
	}
}
