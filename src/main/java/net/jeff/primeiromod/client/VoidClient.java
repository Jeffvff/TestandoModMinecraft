package net.jeff.primeiromod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.jeff.primeiromod.client.keybind.VoidKeyBindings;
import net.jeff.primeiromod.client.screen.VoidSkillScreen;

public final class VoidClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		VoidKeyBindings.initialize();
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.gui.screen() == null && client.level != null && VoidKeyBindings.OPEN_MENU.consumeClick()) {
				VoidKeyBindings.discardMenuClicks();
				client.setScreenAndShow(new VoidSkillScreen());
			}
		});
	}
}
