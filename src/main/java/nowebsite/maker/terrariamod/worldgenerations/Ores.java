package nowebsite.maker.terrariamod.worldgenerations;

import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import org.jetbrains.annotations.NotNull;

import static nowebsite.maker.terrariamod.worldgenerations.OreReferences.*;

public class Ores {

    public static final RuleTest IRON_ORE = new TagMatchTest(Tags.Blocks.ORES_IRON);

    public static final RuleTest ENDSTONE = new TagMatchTest(Tags.Blocks.END_STONES);

    public static Holder<PlacedFeature> TIN_OVERWORLD_OREGEN;
    public static Holder<PlacedFeature> TIN_DEEPSLATE_OREGEN;

    public static Holder<PlacedFeature> LEAD_OVERWORLD_OREGEN;
    public static Holder<PlacedFeature> LEAD_DEEPSLATE_OREGEN;

    public static Holder<PlacedFeature> SILVER_OVERWORLD_OREGEN;
    public static Holder<PlacedFeature> SILVER_DEEPSLATE_OREGEN;

    public static Holder<PlacedFeature> TUNGSTEN_OVERWORLD_OREGEN;
    public static Holder<PlacedFeature> TUNGSTEN_DEEPSLATE_OREGEN;

    public static Holder<PlacedFeature> PLATINUM_OVERWORLD_OREGEN;
    public static Holder<PlacedFeature> PLATINUM_DEEPSLATE_OREGEN;

    public static Holder<PlacedFeature> NETHER_CRYSTAL_OREGEN;
    public static Holder<PlacedFeature> END_PREDARKMATERIAL_OREGEN;

    public static void registerConfiguredFeatures() {
        //VerticalAnchor.absolute(a number for the generation , first the bottom , then the up face)
        TIN_OVERWORLD_OREGEN = registerDefaultOreConfig(
                "tin_ore",
                OreFeatures.STONE_ORE_REPLACEABLES,
                Registration.TIN_ORE.get(),
                TIN_OVERWORLD_VEINSIZE,
                TIN_OVERWORLD_AMOUNT,
                VerticalAnchor.absolute(30),
                VerticalAnchor.absolute(133));

        TIN_DEEPSLATE_OREGEN = registerDefaultOreConfig(
                "deepslate_tin_ore",
                OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                Registration.DEEPSLATE_TIN_ORE.get(),
                TIN_DEEPSLATE_VEINSIZE,
                TIN_DEEPSLATE_AMOUNT,
                VerticalAnchor.bottom(),
                VerticalAnchor.aboveBottom(64));

        LEAD_OVERWORLD_OREGEN = registerDefaultOreConfig(
                "lead_ore",
                OreFeatures.STONE_ORE_REPLACEABLES,
                Registration.LEAD_ORE.get(),
                LEAD_OVERWORLD_VEINSIZE,
                LEAD_OVERWORLD_AMOUNT,
                VerticalAnchor.absolute(10),
                VerticalAnchor.absolute(100));

        LEAD_DEEPSLATE_OREGEN = registerDefaultOreConfig(
                "deepslate_lead_ore",
                OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                Registration.DEEPSLATE_LEAD_ORE.get(),
                LEAD_DEEPSLATE_VEINSIZE,
                LEAD_DEEPSLATE_AMOUNT,
                VerticalAnchor.bottom(),
                VerticalAnchor.absolute(58));

        SILVER_OVERWORLD_OREGEN = registerDefaultOreConfig(
                "silver_ore",
                OreFeatures.STONE_ORE_REPLACEABLES,
                Registration.SILVER_ORE.get(),
                SILVER_OVERWORLD_VEINSIZE,
                SILVER_OVERWORLD_AMOUNT,
                VerticalAnchor.absolute(-10),
                VerticalAnchor.absolute(64));

        SILVER_DEEPSLATE_OREGEN = registerDefaultOreConfig(
                "deepslate_silver_ore",
                OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                Registration.DEEPSLATE_SILVER_ORE.get(),
                SILVER_DEEPSLATE_VEINSIZE,
                SILVER_DEEPSLATE_AMOUNT,
                VerticalAnchor.bottom(),
                VerticalAnchor.absolute(10));

        TUNGSTEN_OVERWORLD_OREGEN = registerDefaultOreConfig(
                "tungsten_ore",
                OreFeatures.STONE_ORE_REPLACEABLES,
                Registration.TUNGSTEN_ORE.get(),
                TUNGSTEN_OVERWORLD_VEINSIZE,
                TUNGSTEN_OVERWORLD_AMOUNT,
                VerticalAnchor.absolute(-10),
                VerticalAnchor.absolute(36));

        TUNGSTEN_DEEPSLATE_OREGEN = registerDefaultOreConfig(
                "deepslate_tungsten_ore",
                OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                Registration.DEEPSLATE_TUNGSTEN_ORE.get(),
                TUNGSTEN_DEEPSLATE_VEINSIZE,
                TUNGSTEN_DEEPSLATE_AMOUNT,
                VerticalAnchor.bottom(),
                VerticalAnchor.absolute(10));

        PLATINUM_OVERWORLD_OREGEN = registerDefaultOreConfig(
                "platinum_ore",
                OreFeatures.STONE_ORE_REPLACEABLES,
                Registration.PLATINUM_ORE.get(),
                PLATINUM_OVERWORLD_VEINSIZE,
                PLATINUM_OVERWORLD_AMOUNT,
                VerticalAnchor.absolute(-10),
                VerticalAnchor.absolute(18));

        PLATINUM_DEEPSLATE_OREGEN = registerDefaultOreConfig(
                "deepslate_platinum_ore",
                OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                Registration.DEEPSLATE_PLATINUM_ORE.get(),
                PLATINUM_DEEPSLATE_VEINSIZE,
                PLATINUM_DEEPSLATE_AMOUNT,
                VerticalAnchor.bottom(),
                VerticalAnchor.absolute(-10));

        NETHER_CRYSTAL_OREGEN = registerDefaultOreConfig(
                "nether_crystal_ore",
                OreFeatures.NETHER_ORE_REPLACEABLES,
                Registration.NETHER_CRYSTAL_ORE.get(),
                NETHER_CRYSTAL_VEINSIZE,
                NETHER_CRYSTAL_AMOUNT,
                VerticalAnchor.absolute(10),
                VerticalAnchor.absolute(200));

        END_PREDARKMATERIAL_OREGEN = registerDefaultOreConfig(
                "end_predarkmaterial_ore",
                ENDSTONE,
                Registration.END_PREDARKMATERIAL_ORE.get(),
                END_PREDARKMATERIAL_VEINSIZE,
                END_PREDARKMATERIAL_AMOUNT,
                VerticalAnchor.absolute(0),
                VerticalAnchor.absolute(100));

    }


    public static void onBiomeLoadingEvent(@NotNull BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NETHER_CRYSTAL_OREGEN);
        } else if (event.getCategory() == Biome.BiomeCategory.THEEND) {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, END_PREDARKMATERIAL_OREGEN);
        } else {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TIN_OVERWORLD_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TIN_DEEPSLATE_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, LEAD_OVERWORLD_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, LEAD_DEEPSLATE_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SILVER_OVERWORLD_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SILVER_DEEPSLATE_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TUNGSTEN_OVERWORLD_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TUNGSTEN_DEEPSLATE_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, PLATINUM_OVERWORLD_OREGEN);
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, PLATINUM_DEEPSLATE_OREGEN);

        }
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }
    public static @NotNull Holder<PlacedFeature> registerDefaultOreConfig(String name, RuleTest targetReplaceBlock, @NotNull Block RegisteredOre, ForgeConfigSpec.IntValue veinsize, ForgeConfigSpec.IntValue amount, VerticalAnchor bottom, VerticalAnchor top){
        return registerPlacedFeature(
                name,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(
                                targetReplaceBlock,
                                RegisteredOre.defaultBlockState(),
                                veinsize.get()
                        )),
                CountPlacement.of(amount.get()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(bottom, top));
    }
}