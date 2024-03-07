package dev.meatwo310.watering_sponge.register;

import dev.meatwo310.watering_sponge.WateringSpongeItemGroup;
import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.blocks.WateringSpongeBlock;
import dev.meatwo310.watering_sponge.blocks.WateringSpongeBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegister {
    protected static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WateringSponge.MODID);
    protected static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WateringSponge.MODID);

    public static final RegistryObject<Block> WATERING_SPONGE = BLOCKS.register("watering_sponge", WateringSpongeBlock::new);
    public static final RegistryObject<Item> WATERING_SPONGE_ITEM = BLOCKITEMS.register("watering_sponge", () -> new WateringSpongeBlockItem(WATERING_SPONGE.get()));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);

        // Register the block items
//        BLOCKS.getEntries()
//            .forEach(entry -> {
//                BLOCKITEMS.register(entry.getId().getPath(), () ->
//                        new BlockItem(entry.get(), new Item.Properties().tab(ItemGroup.MAIN))
//                );
//            });
        BLOCKITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
