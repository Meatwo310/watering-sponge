package dev.meatwo310.watering_sponge.blocks;

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
    public static final String TOOLTIP_KEY = "tooltip.watering_sponge.watering_sponge";

    public WateringSpongeBlockItem(Block block) {
        super(block, new Item.Properties().tab(WateringSpongeItemGroup.MAIN));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable(TOOLTIP_KEY));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
