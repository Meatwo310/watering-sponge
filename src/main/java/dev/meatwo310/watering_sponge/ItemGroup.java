package dev.meatwo310.watering_sponge;

import dev.meatwo310.watering_sponge.registering.BlockRegistering;
import net.minecraft.world.item.ItemStack;

public class ItemGroup extends net.minecraft.world.item.CreativeModeTab {
    public static final ItemGroup MAIN = new ItemGroup(net.minecraft.world.item.CreativeModeTab.TABS.length, WateringSponge.MODID);
    public ItemGroup(int length, String label) {
        super(length, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(BlockRegistering.WATERING_SPONGE.get());
    }
}
