package io.github.meatwo310.wateringsponge.datagen;

import io.github.meatwo310.wateringsponge.block.WSBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class WSRecipeGen extends RecipeProvider {
    public WSRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> output) {
        Block sponge = WSBlocks.WATERING_SPONGE.get();
        Block largeSponge = WSBlocks.LARGE_WATERING_SPONGE.get();

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, sponge)
                .pattern("DDD")
                .pattern("DWD")
                .pattern("DDD")
                .define('D', Items.COARSE_DIRT)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, largeSponge)
                .pattern("SS")
                .pattern("SS")
                .define('S', sponge)
                .unlockedBy(getHasName(sponge), has(sponge))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WSBlocks.LAVA_SPONGE.get())
                .pattern("DDD")
                .pattern("DLD")
                .pattern("DDD")
                .define('D', Items.COARSE_DIRT)
                .define('L', Items.LAVA_BUCKET)
                .unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET))
                .save(output);
    }
}
