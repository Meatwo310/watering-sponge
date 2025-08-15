package io.github.meatwo310.wateringsponge.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final WSConfig WATERING_SPONGE = new WSConfig(
            "wateringSponge",
            "Watering Sponge",
            240,
            7,
            8,
            16,
            true
    );
    public static final WSConfig LARGE_WATERING_SPONGE = new WSConfig(
            "largeWateringSponge",
            "Large Watering Sponge",
            480,
            7,
            16,
            32,
            true
    );

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static class WSConfig {
        public final ForgeConfigSpec.IntValue maxTicks;
        public final ForgeConfigSpec.IntValue ticksPerBlock;
        public final ForgeConfigSpec.IntValue xzRadius;
        public final ForgeConfigSpec.IntValue yHeight;
        public final ForgeConfigSpec.BooleanValue fillBreakable;

        private WSConfig(String category, String name, int maxTicks, int ticksPerBlock, int xzRadius, int yHeight, boolean fillBreakable) {
            BUILDER.push(category);

            this.maxTicks = BUILDER
                    .comment("Maximum number of ticks the " + name + " runs before stopping.")
                    .defineInRange("maxTicks", maxTicks, 1, Integer.MAX_VALUE);
            this.ticksPerBlock = BUILDER
                    .comment("Number of ticks the " + name + " takes to fill one block.")
                    .defineInRange("ticksPerBlock", ticksPerBlock, 1, Integer.MAX_VALUE);
            this.xzRadius = BUILDER
                    .comment("The radius in the X and Z directions that the " + name + " can fill.")
                    .defineInRange("xzRadius", xzRadius - 1, 1, Integer.MAX_VALUE);
            this.yHeight = BUILDER
                    .comment("The height in the Y direction that the " + name + " can fill.")
                    .defineInRange("yHeight", yHeight - 1, 1, Integer.MAX_VALUE);
            this.fillBreakable = BUILDER
                    .comment("Whether to replace blocks that can be broken by pistons.")
                    .define("fillBreakable", fillBreakable);

            BUILDER.pop();
        }
    }
}
