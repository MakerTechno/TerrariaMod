package nowebsite.maker.terrariamod.datagen;

import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer){
/*----------------------------------------TIN ORES RECIPES--------------------------------------------*/
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.TIN_ORES_ITEM),
                        Registration.TIN_INGOT.get(),0.6f,200)
                .unlockedBy("has_ore",has(Registration.TIN_ORES_ITEM))
                .save(consumer,"tin_ingot"+1);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_TIN.get()),
                        Registration.TIN_INGOT.get(),0.6f,180)
                .unlockedBy("has_chunk",has(Registration.RAW_TIN.get()))
                .save(consumer,"tin_ingot"+2);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.TIN_ORES_ITEM),
                        Registration.TIN_INGOT.get(),0.6f,150)
                .unlockedBy("has_ore",has(Registration.TIN_ORES_ITEM))
                .save(consumer,"tin_ingot"+3);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.RAW_TIN.get()),
                        Registration.TIN_INGOT.get(),0.6f,140)
                .unlockedBy("has_chunk",has(Registration.RAW_TIN.get()))
                .save(consumer,"tin_ingot"+4);

/*----------------------------------------LEAD ORES RECIPES-------------------------------------------*/
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.LEAD_ORES_ITEM),
                Registration.LEAD_INGOT.get(),1.0f,280)
                .unlockedBy("has_ore",has(Registration.LEAD_ORES_ITEM))
                .save(consumer,"lead_ingot"+1);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_LEAD.get()),
                Registration.LEAD_INGOT.get(),1.0f,260)
                .unlockedBy("has_chunk",has(Registration.RAW_LEAD.get()))
                .save(consumer,"lead_ingot"+2);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.LEAD_ORES_ITEM),
                        Registration.LEAD_INGOT.get(),1.0f,220)
                .unlockedBy("has_ore",has(Registration.LEAD_ORES_ITEM))
                .save(consumer,"lead_ingot"+3);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.RAW_LEAD.get()),
                        Registration.LEAD_INGOT.get(),1.0f,210)
                .unlockedBy("has_chunk",has(Registration.RAW_LEAD.get()))
                .save(consumer,"lead_ingot"+4);

/*----------------------------------------SILVER ORES RECIPES-------------------------------------------*/
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.SILVER_ORES_ITEM),
                        Registration.SILVER_INGOT.get(),1.6f,340)
                .unlockedBy("has_ore",has(Registration.SILVER_ORES_ITEM))
                .save(consumer,"silver_ingot"+1);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_SILVER.get()),
                        Registration.SILVER_INGOT.get(),1.6f,320)
                .unlockedBy("has_chunk",has(Registration.RAW_SILVER.get()))
                .save(consumer,"silver_ingot"+2);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.SILVER_ORES_ITEM),
                        Registration.SILVER_INGOT.get(),1.6f,290)
                .unlockedBy("has_ore",has(Registration.SILVER_ORES_ITEM))
                .save(consumer,"silver_ingot"+3);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.RAW_SILVER.get()),
                        Registration.SILVER_INGOT.get(),1.6f,260)
                .unlockedBy("has_chunk",has(Registration.RAW_SILVER.get()))
                .save(consumer,"silver_ingot"+4);

/*----------------------------------------TUNGSTEN ORES RECIPES-------------------------------------------*/
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.TUNGSTEN_ORES_ITEM),
                        Registration.TUNGSTEN_INGOT.get(),1.0f,400)
                .unlockedBy("has_ore",has(Registration.TUNGSTEN_ORES_ITEM))
                .save(consumer,"tungsten_ingot"+1);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_TUNGSTEN.get()),
                        Registration.TUNGSTEN_INGOT.get(),1.0f,390)
                .unlockedBy("has_chunk",has(Registration.RAW_TUNGSTEN.get()))
                .save(consumer,"tungsten_ingot"+2);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.TUNGSTEN_ORES_ITEM),
                        Registration.TUNGSTEN_INGOT.get(),1.0f,330)
                .unlockedBy("has_ore",has(Registration.TUNGSTEN_ORES_ITEM))
                .save(consumer,"tungsten_ingot"+3);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.RAW_TUNGSTEN.get()),
                        Registration.TUNGSTEN_INGOT.get(),1.0f,310)
                .unlockedBy("has_chunk",has(Registration.RAW_TUNGSTEN.get()))
                .save(consumer,"tungsten_ingot"+4);

/*----------------------------------------PLATINUM ORES RECIPES-------------------------------------------*/
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.PLATINUM_ORES_ITEM),
                        Registration.PLATINUM_INGOT.get(),1.0f,490)
                .unlockedBy("has_ore",has(Registration.PLATINUM_ORES_ITEM))
                .save(consumer,"platinum_ingot"+1);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_PLATINUM.get()),
                        Registration.PLATINUM_INGOT.get(),1.0f,480)
                .unlockedBy("has_chunk",has(Registration.RAW_PLATINUM.get()))
                .save(consumer,"platinum_ingot"+2);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.PLATINUM_ORES_ITEM),
                        Registration.PLATINUM_INGOT.get(),1.0f,430)
                .unlockedBy("has_ore",has(Registration.PLATINUM_ORES_ITEM))
                .save(consumer,"platinum_ingot"+3);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.RAW_PLATINUM.get()),
                        Registration.PLATINUM_INGOT.get(),1.0f,420)
                .unlockedBy("has_chunk",has(Registration.RAW_PLATINUM.get()))
                .save(consumer,"platinum_ingot"+4);



/*----------------------------------NETHER CRYSTAL ORES RECIPES---------------------------------------*/
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.NETHER_CRYSTAL_ORE_ITEM.get()),
                        Registration.NETHER_CRYSTAL_INGOT.get(),1.2f,2000)
                .unlockedBy("has_ore",has(Registration.NETHER_CRYSTAL_ORE_ITEM.get()))
                .save(consumer,"nether_crystal_ingot"+1);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.NETHER_CRYSTAL_ORE_ITEM.get()),
                        Registration.NETHER_CRYSTAL_INGOT.get(),1.2f,1800)
                .unlockedBy("has_ore",has(Registration.NETHER_CRYSTAL_ORE_ITEM.get()))
                .save(consumer,"nether_crystal_ingot"+2);

/*--------------------------------END PREDARKMATERIAL ORES RECIPES------------------------------------*/
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.END_PREDARKMATERIAL_ORE_ITEM.get()),
                        Registration.END_PREDARKMATERIAL_INGOT.get(),0.6f,3000)
                .unlockedBy("has_ore",has(Registration.END_PREDARKMATERIAL_ORE_ITEM.get()))
                .save(consumer,"end_predarkmaterial_ingot"+1);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.END_PREDARKMATERIAL_ORE_ITEM.get()),
                        Registration.END_PREDARKMATERIAL_INGOT.get(),0.6f,2700)
                .unlockedBy("has_ore",has(Registration.END_PREDARKMATERIAL_ORE_ITEM.get()))
                .save(consumer,"end_predarkmaterial_ingot"+2);
    }

}
