package dev.meatwo310.watering_sponge.register;

import dev.meatwo310.watering_sponge.WateringSpongeItemGroup;
import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.blocks.WateringSpongeBlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegister {
    protected static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WateringSponge.MODID);

    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new Item(new Item.Properties().tab(WateringSpongeItemGroup.MAIN)));

    protected static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WateringSponge.MODID);
    public static final RegistryObject<Item> WATERING_SPONGE_MEDIUM = BLOCKITEMS.register(BlockRegister.WATERING_SPONGE_MEDIUM.getId().getPath(), () -> new WateringSpongeBlockItem(BlockRegister.WATERING_SPONGE_MEDIUM.get()));



    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        BLOCKITEMS.register(modEventBus);
    }
}
