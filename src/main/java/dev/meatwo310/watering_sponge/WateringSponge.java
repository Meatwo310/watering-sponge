package dev.meatwo310.watering_sponge;

import com.mojang.logging.LogUtils;
import dev.meatwo310.watering_sponge.blocks.WateringSpongeBlock;
import dev.meatwo310.watering_sponge.register.BlockEntityRegister;
import dev.meatwo310.watering_sponge.register.BlockRegister;
import dev.meatwo310.watering_sponge.register.ItemRegister;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WateringSponge.MODID)
public class WateringSponge
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "watering_sponge";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public WateringSponge()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        BlockRegister.register(modEventBus);
        BlockEntityRegister.register(modEventBus);
        ItemRegister.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
        ((WateringSpongeBlock)BlockRegister.WATERING_SPONGE_MEDIUM.get()).blockEntity = BlockEntityRegister.WATERING_SPONGE_MEDIUM;
        ((WateringSpongeBlock)BlockRegister.WATERING_SPONGE_LARGE.get()).blockEntity = BlockEntityRegister.WATERING_SPONGE_LARGE;
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
        }
    }
}
