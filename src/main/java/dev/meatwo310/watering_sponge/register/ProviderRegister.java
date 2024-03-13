package dev.meatwo310.watering_sponge.register;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.provider.BlockStateProvider;
import dev.meatwo310.watering_sponge.provider.LangProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WateringSponge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ProviderRegister {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
//        generator.addProvider(event.includeClient(), new ItemModelProvider(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new BlockStateProvider(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LangProvider.EnUs(generator));
        generator.addProvider(event.includeClient(), new LangProvider.JaJp(generator));
    }
}
