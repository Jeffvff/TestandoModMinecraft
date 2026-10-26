package net.jeff.primeiromod.item;

import net.jeff.primeiromod.PrimeiroMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item PICARETA_TESTE = register("picareta_teste");

    private static Item register(String name) {

        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                PrimeiroMod.id(name)
        );

        Item.Properties properties = new Item.Properties()
                .setId(key);

        return Registry.register(
                BuiltInRegistries.ITEM,
                key,
                new PicaretaTesteItem(properties)
        );
    }

    public static void initialize() {
        PrimeiroMod.LOGGER.info("Registrando itens do mod!");
    }
}