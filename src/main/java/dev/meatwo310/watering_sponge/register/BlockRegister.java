package dev.meatwo310.watering_sponge.register;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.blocks.WateringSpongeBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegister {
    protected static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WateringSponge.MODID);
    public static final RegistryObject<Block> WATERING_SPONGE_MEDIUM = BLOCKS.register("watering_sponge_medium", WateringSpongeBlock::new);
    public static final RegistryObject<Block> WATERING_SPONGE_LARGE = BLOCKS.register("watering_sponge_large", WateringSpongeBlock::new);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
