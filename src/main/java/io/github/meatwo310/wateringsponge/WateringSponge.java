package io.github.meatwo310.wateringsponge;

import io.github.meatwo310.wateringsponge.block.WSBlockEntities;
import io.github.meatwo310.wateringsponge.block.WSBlocks;
import io.github.meatwo310.wateringsponge.item.WSCreativeModeTabs;
import io.github.meatwo310.wateringsponge.item.WSItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WateringSponge.MODID)
public class WateringSponge {
    public static final String MODID = "wateringsponge";

    public WateringSponge(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();

        WSCreativeModeTabs.register(bus);
        WSItems.register(bus);
        WSBlocks.register(bus);
        WSBlockEntities.register(bus);
    }
}
