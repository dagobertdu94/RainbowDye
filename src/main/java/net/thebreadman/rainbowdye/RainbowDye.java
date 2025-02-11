package net.thebreadman.rainbowdye;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thebreadman.rainbowdye.Item.ModCreativeModeTab;
import net.thebreadman.rainbowdye.Item.ModItems;
import net.thebreadman.rainbowdye.block.ModBlocks;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RainbowDye.MOD_ID)
public class RainbowDye {
    public static final String MOD_ID = "rainbowdye";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RainbowDye() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTab.CREATIVE_MOD_TABS.register(modEventBus);
        //ModBlockEntities.register(modEventBus);

        /*EntityRenderers.register(EntityType.SHEEP, ModSheepRenderer::new);
        EntityRenderers.register(EntityType.WOLF, ModWolfRenderer::new);
        EntityRenderers.register(EntityType.HORSE, ModHorseRenderer::new);*/

        //BlockEntityRenderers.register(ModBlockEntities.RAINBOW_BED_BLOCK_ENTITY.get(), RainbowBedRenderer::new);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


        }
    }
}
