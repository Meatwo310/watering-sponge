package dev.meatwo310.watering_sponge;

import dev.meatwo310.watering_sponge.register.BlockRegister;
import net.minecraft.world.item.ItemStack;

public class WateringSpongeItemGroup extends net.minecraft.world.item.CreativeModeTab {
    public static final WateringSpongeItemGroup MAIN = new WateringSpongeItemGroup(net.minecraft.world.item.CreativeModeTab.TABS.length, WateringSponge.MODID);
    public WateringSpongeItemGroup(int length, String label) {
        super(length, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(BlockRegister.WATERING_SPONGE.get());
    }
}
