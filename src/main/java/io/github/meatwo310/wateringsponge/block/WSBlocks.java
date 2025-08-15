package io.github.meatwo310.wateringsponge.block;

import io.github.meatwo310.wateringsponge.WateringSponge;
import io.github.meatwo310.wateringsponge.item.WSItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class WSBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WateringSponge.MODID);

    public static final RegistryObject<Block> WATERING_SPONGE = registerBlock(
            "watering_sponge",
            WateringSpongeBlock::new
    );
    public static final RegistryObject<Block> LARGE_WATERING_SPONGE = registerBlock(
            "large_watering_sponge",
            LargeWateringSpongeBlock::new
    );
    public static final RegistryObject<Block> LAVA_SPONGE = registerBlock(
            "lava_sponge",
            LavaSpongeBlock::new
    );

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return registerBlock(name, blockSupplier, item ->
                new BlockItem(item.get(), new Item.Properties())
        );
    }

    private static <T extends Block> RegistryObject<T> registerBlock(
            String name,
            Supplier<T> blockSupplier,
            Function<RegistryObject<T>, ? extends Item> itemFactory
    ) {
        var registryObject = BLOCKS.register(name, blockSupplier);
        WSItems.BLOCK_ITEMS.register(name, () -> itemFactory.apply(registryObject));
        return registryObject;
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
