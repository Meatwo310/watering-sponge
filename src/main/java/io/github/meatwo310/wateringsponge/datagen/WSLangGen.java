package io.github.meatwo310.wateringsponge.datagen;

import io.github.meatwo310.wateringsponge.WateringSponge;
import io.github.meatwo310.wateringsponge.block.WSBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class WSLangGen {
    private WSLangGen() {}

    public static class EnUs extends LanguageProvider {
        public EnUs(PackOutput output) {
            super(output, WateringSponge.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            add("itemGroup.%s.main".formatted(WateringSponge.MODID), "Watering Sponge");

            add(WSBlocks.WATERING_SPONGE.get(), "Watering Sponge");
            add(WSBlocks.LARGE_WATERING_SPONGE.get(), "Large Water Sponge");
            add(WSBlocks.LAVA_SPONGE.get(), "Lava Sponge");
        }
    }

    public static class JaJp extends LanguageProvider{
        public JaJp(PackOutput output) {
            super(output, WateringSponge.MODID, "ja_jp");
        }

        @Override
        protected void addTranslations() {
            add(WSBlocks.WATERING_SPONGE.get(), "逆スポンジ");
            add(WSBlocks.LARGE_WATERING_SPONGE.get(), "大きな逆スポンジ");
            add(WSBlocks.LAVA_SPONGE.get(), "溶岩スポンジ");
        }
    }
}
