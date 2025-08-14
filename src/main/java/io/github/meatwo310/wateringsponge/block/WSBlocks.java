package io.github.meatwo310.wateringsponge.block;

import io.github.meatwo310.wateringsponge.WateringSponge;
import io.github.meatwo310.wateringsponge.item.WSItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class WSBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WateringSponge.MODID);

    public static final RegistryObject<Block> WATERING_SPONGE = registerBlock("watering_sponge", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.SPONGE))
    );

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return registerBlock(name, blockSupplier, item ->
                WSItems.BLOCK_ITEMS.register(name, () -> new BlockItem(item.get(), new Item.Properties()))
        );
    }

    private static <T extends Block> RegistryObject<T> registerBlock(
            String name,
            Supplier<T> blockSupplier,
            Consumer<RegistryObject<T>> itemConsumer
    ) {
        var registryObject = BLOCKS.register(name, blockSupplier);
        itemConsumer.accept(registryObject);
        return registryObject;
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
