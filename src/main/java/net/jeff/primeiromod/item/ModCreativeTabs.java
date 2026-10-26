package net.jeff.primeiromod.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.jeff.primeiromod.PrimeiroMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModCreativeTabs {
	public static final ResourceKey<CreativeModeTab> VOID_POWER = ResourceKey.create(
			Registries.CREATIVE_MODE_TAB,
			PrimeiroMod.id("void_power")
	);

	private ModCreativeTabs() {
	}

	public static void initialize() {
		Registry.register(
				BuiltInRegistries.CREATIVE_MODE_TAB,
				VOID_POWER,
				FabricCreativeModeTab.builder()
						.title(Component.literal("VOID"))
						.icon(() -> new ItemStack(ModItems.VOID_POWER_ICON))
						.displayItems((parameters, output) -> output.accept(ModItems.VOID_POWER_ICON))
						.build()
		);

		PrimeiroMod.LOGGER.info("Aba criativa do VOID POWER registrada.");
	}
}
