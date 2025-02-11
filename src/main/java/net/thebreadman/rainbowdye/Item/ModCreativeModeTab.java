package net.thebreadman.rainbowdye.Item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab RAINBOW_DYE_TAB = new CreativeModeTab("rainbow_dye_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RAINBOW_DYE.get());
        }
    };
}
