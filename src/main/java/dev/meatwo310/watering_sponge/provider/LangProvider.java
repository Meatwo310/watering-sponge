package dev.meatwo310.watering_sponge.provider;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.registering.BlockRegistering;
import dev.meatwo310.watering_sponge.registering.ItemRegistering;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class LangProvider extends LanguageProvider {

    public LangProvider(DataGenerator gen, String locale) {
        super(gen, WateringSponge.MODID, locale);
    }

    public static class EnUs extends LangProvider {
        public EnUs(DataGenerator gen) {
            super(gen, "en_us");
        }

        @Override
        protected void addTranslations() {
            add("itemGroup.watering_sponge", "Watering Sponge");
            add(ItemRegistering.TEST_ITEM.get(), "Test Item");
            add(BlockRegistering.WATERING_SPONGE.get(), "Watering Sponge");
        }
    }

    public static class JaJp extends LangProvider {
        public JaJp(DataGenerator gen) {
            super(gen, "ja_jp");
        }

        @Override
        protected void addTranslations() {
            add(ItemRegistering.TEST_ITEM.get(), "テストアイテム");
            add(BlockRegistering.WATERING_SPONGE.get(), "べちゃべちゃのスポンジ");
        }
    }
}
