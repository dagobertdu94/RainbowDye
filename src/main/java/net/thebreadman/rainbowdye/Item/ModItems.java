package net.thebreadman.rainbowdye.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thebreadman.rainbowdye.Item.custom.RainbowDyeItem;
import net.thebreadman.rainbowdye.RainbowDye;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RainbowDye.MOD_ID);

    public static final RegistryObject<Item> RAINBOW_DYE = ITEMS.register("rainbow_dye",
            () -> new RainbowDyeItem(new Item.Properties().tab(ModCreativeModeTab.RAINBOW_DYE_TAB)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
