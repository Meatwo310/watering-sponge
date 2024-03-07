package dev.meatwo310.watering_sponge.registering;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.provider.LangProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WateringSponge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ProviderRegistering {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeClient(), new LangProvider.EnUs(generator));
        generator.addProvider(event.includeClient(), new LangProvider.JaJp(generator));
    }
}
