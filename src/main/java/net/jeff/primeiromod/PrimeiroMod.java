package net.jeff.primeiromod;

import net.fabricmc.api.ModInitializer;

import net.jeff.primeiromod.item.ModItems;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimeiroMod implements ModInitializer {
	public static final String MOD_ID = "primeiro-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
