package io.github.meatwo310.wateringsponge.datagen;

import io.github.meatwo310.wateringsponge.block.WSBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class WSRecipeGen extends RecipeProvider {
    public WSRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WSBlocks.WATERING_SPONGE.get())
                .pattern("DDD")
                .pattern("DWD")
                .pattern("DDD")
                .define('D', Items.COARSE_DIRT)
                .define('W', Items.WATER_BUCKET)
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WSBlocks.LARGE_WATERING_SPONGE.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', WSBlocks.WATERING_SPONGE.get())
                .save(output);
    }
}
