package io.github.meatwo310.wateringsponge.item;

import io.github.meatwo310.wateringsponge.WateringSponge;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WSItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WateringSponge.MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WateringSponge.MODID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        BLOCK_ITEMS.register(bus);
    }
}
