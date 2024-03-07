package dev.meatwo310.watering_sponge.registering;

import dev.meatwo310.watering_sponge.ItemGroup;
import dev.meatwo310.watering_sponge.WateringSponge;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistering {
    protected static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WateringSponge.MODID);
    protected static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WateringSponge.MODID);

    public static final RegistryObject<Block> WATERING_SPONGE = BLOCKS.register("watering_sponge", () -> new Block(BlockBehaviour.Properties.of(Material.SPONGE)));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);

        // Register the block items
        BLOCKS.getEntries().forEach(entry ->
            BLOCKITEMS.register(entry.getId().getPath(), () -> new BlockItem(entry.get(), new Item.Properties().tab(ItemGroup.MAIN)))
        );
        BLOCKITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
