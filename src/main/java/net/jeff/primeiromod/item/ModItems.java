package net.jeff.primeiromod.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import net.jeff.primeiromod.PrimeiroMod;

public final class ModItems {
	public static final Item VOID_POWER_ICON = register("void_power_icon");

	private ModItems() {
	}

	private static Item register(String name) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, PrimeiroMod.id(name));
		Item.Properties properties = new Item.Properties().setId(key).stacksTo(1);
		return Registry.register(BuiltInRegistries.ITEM, key, new Item(properties));
	}

	public static void initialize() {
		PrimeiroMod.LOGGER.info("Registro de itens do VOID POWER inicializado.");
	}
}
