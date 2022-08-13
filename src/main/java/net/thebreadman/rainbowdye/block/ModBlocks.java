package net.thebreadman.rainbowdye.block;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thebreadman.rainbowdye.Item.ModCreativeModeTab;
import net.thebreadman.rainbowdye.Item.ModItems;
import net.thebreadman.rainbowdye.RainbowDye;

import java.util.function.Supplier;

public class ModBlocks extends Block{

    private BlockState defaultBlockState;

    public ModBlocks(Properties properties) {
        super(properties);
    }

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RainbowDye.MOD_ID);

    public static final RegistryObject<Block> RAINBOW_WOOL = registerBlock("rainbow_wool",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)), ModCreativeModeTab.RAINBOW_DYE_TAB);

    public static final RegistryObject<Block> RAINBOW_CARPET = registerBlock("rainbow_carpet",
            () -> new WoolCarpetBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)),
            ModCreativeModeTab.RAINBOW_DYE_TAB);

    public static final RegistryObject<Block> RAINBOW_TERRACOTTA = registerBlock("rainbow_terracotta",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)), ModCreativeModeTab.RAINBOW_DYE_TAB);

    public static final RegistryObject<Block> RAINBOW_CONCRETE = registerBlock("rainbow_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)), ModCreativeModeTab.RAINBOW_DYE_TAB);

    public static final RegistryObject<Block> RAINBOW_CONCRETE_POWDER = registerBlock("rainbow_concrete_powder",
            () -> new ConcretePowderBlock(ModBlocks.RAINBOW_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE_POWDER)),
            ModCreativeModeTab.RAINBOW_DYE_TAB);

    public static final RegistryObject<Block> RAINBOW_STAINED_GLASS = registerBlock("rainbow_stained_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)), ModCreativeModeTab.RAINBOW_DYE_TAB);

    public static final RegistryObject<Block> RAINBOW_STAINED_GLASS_PANE = registerBlock("rainbow_stained_glass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE)), ModCreativeModeTab.RAINBOW_DYE_TAB);

    public static final RegistryObject<Block> RAINBOW_CANDLE = registerBlock("rainbow_candle",
            () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.CANDLE)), ModCreativeModeTab.RAINBOW_DYE_TAB);

    public static final RegistryObject<Block> RAINBOW_CANDLE_CAKE = registerBlock("rainbow_candle_cake",
            () -> new CandleCakeBlock(ModBlocks.RAINBOW_CANDLE.get(), Properties.copy(Blocks.CANDLE_CAKE)), null);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        if (tab != null) {registerBlockItem(name, toReturn, tab);}
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
