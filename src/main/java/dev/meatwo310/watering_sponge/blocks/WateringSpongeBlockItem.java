package dev.meatwo310.watering_sponge.blocks;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.WateringSpongeItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

public class WateringSpongeBlockItem extends BlockItem {
    public final String TOOLTIP_KEY_1;
    public final String TOOLTIP_KEY_2;
    public final String TOOLTIP_KEY_3;
//    public final String TOOLTIP_KEY_4;
//    public final String TOOLTIP_KEY_5;

    public WateringSpongeBlockItem(Block block) {
        super(block, new Item.Properties().tab(WateringSpongeItemGroup.MAIN));
        TOOLTIP_KEY_1 = "tooltip.watering_sponge." + block.getDescriptionId() + ".1";
        TOOLTIP_KEY_2 = "tooltip.watering_sponge." + block.getDescriptionId() + ".2";
        TOOLTIP_KEY_3 = "tooltip.watering_sponge." + block.getDescriptionId() + ".3";
//        TOOLTIP_KEY_4 = "tooltip.watering_sponge." + block.getDescriptionId() + ".4";
//        TOOLTIP_KEY_5 = "tooltip.watering_sponge." + block.getDescriptionId() + ".5";
        WateringSponge.LOGGER.info(block.getDescriptionId());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable(TOOLTIP_KEY_1));
        tooltip.add(Component.translatable(TOOLTIP_KEY_2));
        tooltip.add(Component.translatable(TOOLTIP_KEY_3));
//        tooltip.add(Component.translatable(TOOLTIP_KEY_4));
//        tooltip.add(Component.translatable(TOOLTIP_KEY_5));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
