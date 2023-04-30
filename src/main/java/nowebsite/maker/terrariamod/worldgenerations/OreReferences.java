package nowebsite.maker.terrariamod.worldgenerations;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreReferences {
    public static ForgeConfigSpec.IntValue MAX_REPLACE_VEINSIZE;
    public static ForgeConfigSpec.IntValue MAX_REPLACE_AMOUNT;

    public static ForgeConfigSpec.IntValue TIN_OVERWORLD_VEINSIZE;//How much a group of it will spawn
    public static ForgeConfigSpec.IntValue TIN_OVERWORLD_AMOUNT;//How much a structure spawn(it's range ,int bigger>more)
    public static ForgeConfigSpec.IntValue TIN_DEEPSLATE_VEINSIZE;
    public static ForgeConfigSpec.IntValue TIN_DEEPSLATE_AMOUNT;

    public static ForgeConfigSpec.IntValue LEAD_OVERWORLD_VEINSIZE;
    public static ForgeConfigSpec.IntValue LEAD_OVERWORLD_AMOUNT;
    public static ForgeConfigSpec.IntValue LEAD_DEEPSLATE_VEINSIZE;
    public static ForgeConfigSpec.IntValue LEAD_DEEPSLATE_AMOUNT;

    public static ForgeConfigSpec.IntValue SILVER_OVERWORLD_VEINSIZE;
    public static ForgeConfigSpec.IntValue SILVER_OVERWORLD_AMOUNT;
    public static ForgeConfigSpec.IntValue SILVER_DEEPSLATE_VEINSIZE;
    public static ForgeConfigSpec.IntValue SILVER_DEEPSLATE_AMOUNT;

    public static ForgeConfigSpec.IntValue TUNGSTEN_OVERWORLD_VEINSIZE;
    public static ForgeConfigSpec.IntValue TUNGSTEN_OVERWORLD_AMOUNT;
    public static ForgeConfigSpec.IntValue TUNGSTEN_DEEPSLATE_VEINSIZE;
    public static ForgeConfigSpec.IntValue TUNGSTEN_DEEPSLATE_AMOUNT;

    public static ForgeConfigSpec.IntValue PLATINUM_OVERWORLD_VEINSIZE;
    public static ForgeConfigSpec.IntValue PLATINUM_OVERWORLD_AMOUNT;
    public static ForgeConfigSpec.IntValue PLATINUM_DEEPSLATE_VEINSIZE;
    public static ForgeConfigSpec.IntValue PLATINUM_DEEPSLATE_AMOUNT;

    public static ForgeConfigSpec.IntValue NETHER_CRYSTAL_VEINSIZE;
    public static ForgeConfigSpec.IntValue NETHER_CRYSTAL_AMOUNT;

    public static ForgeConfigSpec.IntValue END_PREDARKMATERIAL_VEINSIZE;
    public static ForgeConfigSpec.IntValue END_PREDARKMATERIAL_AMOUNT;

    public static void registerCommonConfig(ForgeConfigSpec.Builder COMMON_BUILDER) {
        COMMON_BUILDER.comment("Settings for ore generation").push("ores");

        MAX_REPLACE_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of max replace")
                .defineInRange("maxReplaceVeinsize",114514,114514,Integer.MAX_VALUE);

        MAX_REPLACE_AMOUNT = COMMON_BUILDER
                .comment("Amount of max replace")
                .defineInRange("maxReplaceAmount",114514,114514,Integer.MAX_VALUE);

        /*-----------------------------------Tin ores config------------------------------------*/
        TIN_OVERWORLD_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of overworld tin ore")
                .defineInRange("overworldTinVeinsize", 6, 1, Integer.MAX_VALUE);

        TIN_OVERWORLD_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of overworld tin ore")
                .defineInRange("overworldTinAmount", 18, 1, Integer.MAX_VALUE);


        TIN_DEEPSLATE_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of deepslate tin ore")
                .defineInRange("deepslateTinVeinsize", 5, 1, Integer.MAX_VALUE);

        TIN_DEEPSLATE_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of deepslate tin ore")
                .defineInRange("deepslateTinAmount", 16, 1, Integer.MAX_VALUE);



        /*-----------------------------------Lead ores config------------------------------------*/
        LEAD_OVERWORLD_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of overworld lead ore")
                .defineInRange("overworldLeadVeinsize", 6, 1, Integer.MAX_VALUE);

        LEAD_OVERWORLD_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of overworld lead ore")
                .defineInRange("overworldLeadAmount", 14, 1, Integer.MAX_VALUE);


        LEAD_DEEPSLATE_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of deepslate lead ore")
                .defineInRange("deepslateLeadVeinsize", 5, 1, Integer.MAX_VALUE);

        LEAD_DEEPSLATE_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of deepslate lead ore")
                .defineInRange("deepslateLeadAmount", 13, 1, Integer.MAX_VALUE);



        /*-----------------------------------Silver ores config------------------------------------*/
        SILVER_OVERWORLD_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of overworld silver ore")
                .defineInRange("overworldSilverVeinsize", 6, 1, Integer.MAX_VALUE);

        SILVER_OVERWORLD_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of overworld silver ore")
                .defineInRange("overworldSilverAmount", 10, 1, Integer.MAX_VALUE);


        SILVER_DEEPSLATE_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of deepslate silver ore")
                .defineInRange("deepslateSilverVeinsize", 6, 1, Integer.MAX_VALUE);

        SILVER_DEEPSLATE_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of deepslate silver ore")
                .defineInRange("deepslateSilverAmount", 10, 1, Integer.MAX_VALUE);



        /*-----------------------------------Tungsten ores config------------------------------------*/
        TUNGSTEN_OVERWORLD_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of overworld tungsten ore")
                .defineInRange("overworldTungstenVeinsize", 7, 1, Integer.MAX_VALUE);

        TUNGSTEN_OVERWORLD_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of overworld tungsten ore")
                .defineInRange("overworldTungstenAmount", 10, 1, Integer.MAX_VALUE);


        TUNGSTEN_DEEPSLATE_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of deepslate tungsten ore")
                .defineInRange("deepslateTungstenVeinsize", 7, 1, Integer.MAX_VALUE);

        TUNGSTEN_DEEPSLATE_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of deepslate tungsten ore")
                .defineInRange("deepslateTungstenAmount", 10, 1, Integer.MAX_VALUE);



        /*-----------------------------------Platinum ores config------------------------------------*/
        PLATINUM_OVERWORLD_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of overworld platinum ore")
                .defineInRange("overworldPlatinumVeinsize", 6, 1, Integer.MAX_VALUE);

        PLATINUM_OVERWORLD_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of overworld platinum ore")
                .defineInRange("overworldPlatinumAmount", 3, 1, Integer.MAX_VALUE);


        PLATINUM_DEEPSLATE_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of deepslate platinum ore")
                .defineInRange("deepslatePlatinumVeinsize", 5, 1, Integer.MAX_VALUE);

        PLATINUM_DEEPSLATE_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of platinum silver ore")
                .defineInRange("deepslatePlatinumAmount", 4, 1, Integer.MAX_VALUE);



        /*-------------------------------------Nether configs------------------------------------------*/
        NETHER_CRYSTAL_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of nether crystal ore")
                .defineInRange("netherCrystalOreVeinsize", 4, 1, Integer.MAX_VALUE);

        NETHER_CRYSTAL_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of nether crystal ore")
                .defineInRange("netherCrystalOreAmount", 20, 1, Integer.MAX_VALUE);



        /*----------------------------------------End configs-----------------------------------------*/
        END_PREDARKMATERIAL_VEINSIZE = COMMON_BUILDER
                .comment("Veinsize of end predarkmaterial")
                .defineInRange("endPredarkmaterialVeinsize", 6, 1, Integer.MAX_VALUE);

        END_PREDARKMATERIAL_AMOUNT = COMMON_BUILDER
                .comment("Amount of veins of end predarkmaterial")
                .defineInRange("endPredarkmaterialAmount", 12, 1, Integer.MAX_VALUE);




        COMMON_BUILDER.pop();
    }

}
