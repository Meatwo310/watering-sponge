package io.github.meatwo310.wateringsponge.item;

import io.github.meatwo310.wateringsponge.WateringSponge;
import io.github.meatwo310.wateringsponge.block.WSBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class WSCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WateringSponge.MODID);

    public static final RegistryObject<CreativeModeTab> WATERING_SPONGE_TAB = TABS
            .register(WateringSponge.MODID, () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(WSBlocks.WATERING_SPONGE.get()))
                    .displayItems(WSCreativeModeTabs::getDisplayItems)
                    .build()
            );

    private static void getDisplayItems(ItemDisplayParameters params, Output output) {
        Stream.concat(WSItems.ITEMS.getEntries().stream(), WSItems.BLOCK_ITEMS.getEntries().stream())
                .map(RegistryObject::get)
                .forEach(output::accept);
    }

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
