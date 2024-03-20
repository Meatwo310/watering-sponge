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

            add(ItemRegister.WATERING_SPONGE_MEDIUM.get(), "Watering Sponge");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_1,
                    "§4This is a §cDANGEROUS§r §4block that will flood the surrounding area!§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_2,
                    "§7This replaces air, grass, etc. with water in a 15x15 block around it, with the placed location as the upper limit of height.§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_3,
                    "§7To cancel this, destroy the block that was placed first.§r");
            add(ItemRegister.WATERING_SPONGE_LARGE.get(), "Large Watering Sponge");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_LARGE.get()).TOOLTIP_KEY_1,
                    "§4This is a §cVERY DANGEROUS§r §4block that will flood a large area!§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_LARGE.get()).TOOLTIP_KEY_2,
                    "§7A larger Watering Sponge.§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_LARGE.get()).TOOLTIP_KEY_3,
                    "§731x31 blocks will be replaced with water.§r");
        }
    }

    public static class JaJp extends LangProvider {
        public JaJp(DataGenerator gen) {
            super(gen, "ja_jp");
        }

        @Override
        protected void addTranslations() {
            add(ItemRegister.TEST_ITEM.get(), "テストアイテム");

            add(ItemRegister.WATERING_SPONGE_MEDIUM.get(), "逆スポンジ");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_1,
                    "§4これは周囲を水浸しにする§c危険な§r§4ブロックです！§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_2,
                    "§7設置された場所を高さの上限として、 周囲15x15ブロックの空気や草などを水に置換します。§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_MEDIUM.get()).TOOLTIP_KEY_3,
                    "§7置き換えをキャンセルするには、 はじめに設置したブロックを壊してください。§r");
            add(ItemRegister.WATERING_SPONGE_LARGE.get(), "大きな逆スポンジ");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_LARGE.get()).TOOLTIP_KEY_1,
                    "§4これは大きな範囲を水浸しにする§cとても危険な§r§4ブロックです！§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_LARGE.get()).TOOLTIP_KEY_2,
                    "§7より大きな範囲を水に置換する逆スポンジ。§r");
            add(((WateringSpongeBlockItem)ItemRegister.WATERING_SPONGE_LARGE.get()).TOOLTIP_KEY_3,
                    "§731x31ブロックを置き換えます。§r");
        }
    }
}
