package dev.meatwo310.watering_sponge.provider;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.WateringSpongeItemGroup;
import dev.meatwo310.watering_sponge.blocks.WateringSpongeBlockItem;
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
            add(WateringSpongeItemGroup.TOOLTIP_KEY, "Watering Sponge");
            add(ItemRegister.TEST_ITEM.get(), "Test Item");

            /*
            Watering Sponge
            This is a DANGEROUS block that will flood the surrounding area!
            This replaces the surrounding air and replaceable blocks with water, with the placed location as the upper limit of height.
            To cancel this, destroy the block that was placed first.
             */
            add(ItemRegister.WATERING_SPONGE_MEDIUM.get(), "Watering Sponge");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_1,
                    "§4This is a §cDANGEROUS§r §4block that will flood the surrounding area!§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_2,
                    "§7This replaces the surrounding air and replaceable blocks with water, with the placed location as the upper limit of height.§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_3,
                    "§7To cancel this, destroy the block that was placed first.§r");
        }
    }

    public static class JaJp extends LangProvider {
        public JaJp(DataGenerator gen) {
            super(gen, "ja_jp");
        }

        @Override
        protected void addTranslations() {
            add(ItemRegister.TEST_ITEM.get(), "テストアイテム");

            /*
            逆スポンジ
            これは周囲を水浸しにする危険なブロックです！
            設置された場所を高さの上限として、 周囲の空気や置き換え可能なブロックを水に置換します。
            これをキャンセルするには、 はじめに設置したブロックを壊してください。
             */
            add(ItemRegister.WATERING_SPONGE_MEDIUM.get(), "逆スポンジ");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_1,
                    "§4これは周囲を水浸しにする§c危険な§r§4ブロックです！§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_2,
                    "§7設置された場所を高さの上限として、 周囲の空気や置き換え可能なブロックを水に置換します。§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_3,
                    "§7これをキャンセルするには、 はじめに設置したブロックを壊してください。§r");
        }
    }
}
