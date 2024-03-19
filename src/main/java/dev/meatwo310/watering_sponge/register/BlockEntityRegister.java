package dev.meatwo310.watering_sponge.register;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.blockentitys.WateringSpongeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegister {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WateringSponge.MODID);
    public static RegistryObject<BlockEntityType<WateringSpongeBlockEntity>> WATERING_SPONGE_MEDIUM;

    public static RegistryObject<BlockEntityType<WateringSpongeBlockEntity>> WATERING_SPONGE_LARGE;

    public static void register(IEventBus modEventBus) {
        WATERING_SPONGE_MEDIUM = TILE_ENTITY_TYPES.register(BlockRegister.WATERING_SPONGE_MEDIUM.getId().getPath(), () -> BlockEntityType.Builder.of(
                        (BlockPos pos, BlockState state) -> new WateringSpongeBlockEntity(
                                WATERING_SPONGE_MEDIUM.get(), pos, state, 8, 16
                        ),
                        BlockRegister.WATERING_SPONGE_MEDIUM.get()
                ).build(null)
        );
        WATERING_SPONGE_LARGE = TILE_ENTITY_TYPES.register(BlockRegister.WATERING_SPONGE_LARGE.getId().getPath(), () -> BlockEntityType.Builder.of(
                        (BlockPos pos, BlockState state) -> new WateringSpongeBlockEntity(
                                WATERING_SPONGE_LARGE.get(), pos, state, 16, 32
                        ),
                        BlockRegister.WATERING_SPONGE_LARGE.get()
                ).build(null)
        );
        TILE_ENTITY_TYPES.register(modEventBus);
    }
}
