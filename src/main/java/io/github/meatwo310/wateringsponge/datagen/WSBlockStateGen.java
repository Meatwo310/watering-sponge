package io.github.meatwo310.wateringsponge.datagen;

import io.github.meatwo310.wateringsponge.WateringSponge;
import io.github.meatwo310.wateringsponge.block.WSBlocks;
import io.github.meatwo310.wateringsponge.block.WateringSpongeBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class WSBlockStateGen extends BlockStateProvider {
    public WSBlockStateGen(PackOutput output, ExistingFileHelper efh) {
        super(output, WateringSponge.MODID, efh);
    }

    @Override
    protected void registerStatesAndModels() {
        registerWateringSponge();
        registerLargeWateringSponge();
    }

    private void registerWateringSponge() {
        var block = WSBlocks.WATERING_SPONGE.get();
        String id = WSBlocks.WATERING_SPONGE.getId().getPath();
        getVariantBuilder(block).forAllStates(state -> {
            var name = "%s%s".formatted(id, state.getValue(WateringSpongeBlock.CORE) ? "_core" : "");
            return ConfiguredModel.builder()
                    .modelFile(models().cubeAll(name, modLoc("block/" + name)))
                    .build();
        });
        simpleBlockItem(block, models().cubeAll(id, modLoc("block/" + id)));
    }

    private void registerLargeWateringSponge() {
        var block = WSBlocks.LARGE_WATERING_SPONGE.get();
        String id = WSBlocks.LARGE_WATERING_SPONGE.getId().getPath();
        getVariantBuilder(block).forAllStates(state -> {
            var name = "%s%s".formatted(id, state.getValue(WateringSpongeBlock.CORE) ? "_core" : "");
            return ConfiguredModel.builder()
                    .modelFile(models().cubeAll(name, modLoc("block/" + name)))
                    .build();
        });
        simpleBlockItem(block, models().cubeAll(id, modLoc("block/" + id)));
    }

    private void cubeAllBlockWithItem(RegistryObject<Block> registryObject) {
        Block block = registryObject.get();
        simpleBlockWithItem(block, cubeAll(block));
    }
}
