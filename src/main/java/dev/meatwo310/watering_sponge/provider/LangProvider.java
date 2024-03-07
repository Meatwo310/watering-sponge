package dev.meatwo310.watering_sponge.provider;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.blocks.WateringSpongeBlockItem;
import dev.meatwo310.watering_sponge.register.BlockRegister;
import dev.meatwo310.watering_sponge.register.ItemRegister;
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
            add(ItemRegister.TEST_ITEM.get(), "Test Item");
            add(BlockRegister.WATERING_SPONGE_ITEM.get(), "Watering Sponge");
            add(WateringSpongeBlockItem.TOOLTIP_KEY, "§7A sponge that can fill water§r");
        }
    }

    public static class JaJp extends LangProvider {
        public JaJp(DataGenerator gen) {
            super(gen, "ja_jp");
        }

        @Override
        protected void addTranslations() {
            add(ItemRegister.TEST_ITEM.get(), "テストアイテム");
            add(BlockRegister.WATERING_SPONGE_ITEM.get(), "逆スポンジ");
            add(WateringSpongeBlockItem.TOOLTIP_KEY, "§7周囲を水浸しにしよう！§r");
        }
    }
}
