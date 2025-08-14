package io.github.meatwo310.wateringsponge.block;

import io.github.meatwo310.wateringsponge.WateringSponge;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WSBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WateringSponge.MODID);

    public static final RegistryObject<BlockEntityType<WateringSpongeCoreBE>> WATERING_SPONGE_BE =
            registerBE(WSBlocks.WATERING_SPONGE_CORE, WateringSpongeCoreBE::new);

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> registerBE(
            RegistryObject<Block> blockRegistry,
            BlockEntitySupplier<T> beSupplier
    ) {
        return BLOCK_ENTITIES.register(blockRegistry.getId().getPath(), () -> BlockEntityType.Builder
                        .of(beSupplier, blockRegistry.get())
                        .build(null)
        );
    }
    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
