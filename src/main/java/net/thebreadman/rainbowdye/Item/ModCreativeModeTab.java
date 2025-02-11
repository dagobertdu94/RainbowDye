package net.thebreadman.rainbowdye.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.thebreadman.rainbowdye.RainbowDye;
import net.thebreadman.rainbowdye.block.ModBlocks;

public class ModCreativeModeTab {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RainbowDye.MOD_ID);
	public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MOD_TABS.register("rainbow_dye_tab", () -> CreativeModeTab.builder()
			.withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> new ItemStack(ModItems.RAINBOW_DYE.get()))
			.displayItems((param, out) -> ModItems.ITEMS.getEntries().forEach((obj) -> obj.ifPresent((item) -> {
				if (!(item instanceof BlockItem) || (item instanceof BlockItem bi && bi.getBlock() != ModBlocks.RAINBOW_CANDLE_CAKE.get())) {
					out.accept(item);
				}
			}))).build());
	
}
