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
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper efh = event.getExistingFileHelper();

        DataGeneratorHelper gen = new DataGeneratorHelper(generator);

        if (event.includeClient()) {
            gen.addProvider(new WSLangGen.EnUs(output));
            gen.addProvider(new WSLangGen.JaJp(output));
            gen.addProvider(new WSBlockStateGen(output, efh));
        }
        if (event.includeServer()) {
            gen.addProvider(new WSRecipeGen(output));
        }
    }

    private record DataGeneratorHelper(DataGenerator gen) {
        public <T extends net.minecraft.data.DataProvider> T addProvider(T provider) {
            gen.addProvider(true, provider);
            return provider;
        }
    }
}
