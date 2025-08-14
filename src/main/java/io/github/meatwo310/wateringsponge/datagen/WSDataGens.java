package io.github.meatwo310.wateringsponge.datagen;

import io.github.meatwo310.wateringsponge.WateringSponge;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = WateringSponge.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class WSDataGens {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper efh = event.getExistingFileHelper();

        gen.addProvider(event.includeClient(), new WSLangGen.EnUs(output));
        gen.addProvider(event.includeClient(), new WSLangGen.JaJp(output));
    }
}
