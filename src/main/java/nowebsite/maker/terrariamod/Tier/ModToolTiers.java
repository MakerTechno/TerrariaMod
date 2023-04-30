package nowebsite.maker.terrariamod.Tier;

import net.minecraft.stats.StatType;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final ForgeTier TIN = new ForgeTier(
            1, 186,5.0f,1.8f,10,
            Registration.NEEDS_TIN_TOOLS,
            ()-> Ingredient.of(Registration.TIN_INGOT.get())
    );
    public static final ForgeTier LEAD =new ForgeTier(
            2, 270,6.2f,2.2f,14,
            Registration.NEEDS_LEAD_TOOLS,
            ()-> Ingredient.of(Registration.LEAD_INGOT.get())
    );
    public static Tier SILVER = new ForgeTier(
            3, 440,7.2f,2.8f,15,
            Registration.NEEDS_SILVER_TOOLS,
            ()-> Ingredient.of(Registration.SILVER_INGOT.get())
    );
    public static Tier TUNGSTEN = new ForgeTier(
            3, 440,7.2f,2.8f,15,
            Registration.NEEDS_TUNGSTEN_TOOLS,
            ()-> Ingredient.of(Registration.TUNGSTEN_INGOT.get())
    );
    public static Tier PLATINUM = new ForgeTier(
            4, 900,9.2f,3.5f,23,
            Registration.NEEDS_PLATINUM_TOOLS,
            ()-> Ingredient.of(Registration.PLATINUM_INGOT.get())
    );
    static {
        /*
        GOLD = TierSortingRegistry.registerTier(

                new ForgeTier(
                        4,740, 8.6f, 3.3f, 20,
                        Registration.NEEDS_PLATINUM_TOOLS,
                        ()-> Ingredient.of(Items.GOLD_INGOT)
                ),

                new ResourceLocation(TerrariaMod.VANILLA,"gold_ingot"),
                List.of(ToolTiers.TUNGSTEN),
                List.of(ToolTiers.PLATINUM)
        );*/
/*
        DIAMOND = TierSortingRegistry.registerTier(

                new ForgeTier(
                        5,1220, 10.1f, 3.8f, 18,
                        BlockTags.NEEDS_DIAMOND_TOOL,
                        ()-> Ingredient.of(Items.DIAMOND)
                ),

                new ResourceLocation(TerrariaMod.VANILLA,"diamond"),
                List.of(ToolTiers.PLATINUM),
                List.of(ToolTiers.NETHERITE)
        );

        NETHERITE = TierSortingRegistry.registerTier(

                new ForgeTier(
                        6,1776, 10.8f, 4.3f, 17,
                        BlockTags.createOptional(new ResourceLocation(TerrariaMod.VANILLA,"needs_netherite_tool")),
                        ()-> Ingredient.of(Items.NETHERITE_INGOT)
                ),

                new ResourceLocation(TerrariaMod.VANILLA,"netherite_ingot"),
                List.of(ToolTiers.DIAMOND),
                List.of()
        );*/


    }
    public void register(){

    }

}
