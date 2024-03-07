package dev.meatwo310.watering_sponge.register;

import dev.meatwo310.watering_sponge.WateringSpongeItemGroup;
import dev.meatwo310.watering_sponge.WateringSponge;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegister {
    protected static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WateringSponge.MODID);

    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new Item(new Item.Properties().tab(WateringSpongeItemGroup.MAIN)));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
