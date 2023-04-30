package nowebsite.maker.terrariamod.datagen;

import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper helper) {
        super(generator, blockTagsProvider, TerrariaMod.MODID,helper);
    }

    @Override
    protected void addTags(){
        tag(Tags.Items.ORES)
                .add(Registration.TIN_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_TIN_ORE_ITEM.get())

                .add(Registration.LEAD_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_LEAD_ORE_ITEM.get())

                .add(Registration.SILVER_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_SILVER_ORE_ITEM.get())

                .add(Registration.TUNGSTEN_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_TUNGSTEN_ORE_ITEM.get())

                .add(Registration.PLATINUM_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_PLATINUM_ORE_ITEM.get())

                .add(Registration.NETHER_CRYSTAL_ORE_ITEM.get())

                .add(Registration.END_PREDARKMATERIAL_ORE_ITEM.get());

        tag(Tags.Items.RAW_MATERIALS)
                .add(Registration.RAW_TIN.get())
                .add(Registration.RAW_LEAD.get())
                .add(Registration.RAW_SILVER.get())
                .add(Registration.RAW_TUNGSTEN.get())
                .add(Registration.RAW_PLATINUM.get())

                .add(Registration.NETHER_CRYSTAL_INGOT.get())

                .add(Registration.END_PREDARKMATERIAL_INGOT.get());

        tag(Tags.Items.INGOTS)
                .add(Registration.TIN_INGOT.get())
                .add(Registration.LEAD_INGOT.get())
                .add(Registration.SILVER_INGOT.get())
                .add(Registration.TUNGSTEN_INGOT.get())
                .add(Registration.PLATINUM_INGOT.get())

                .add(Registration.NETHER_CRYSTAL_INGOT.get())

                .add(Registration.END_PREDARKMATERIAL_INGOT.get());


        tag(Registration.TIN_ORES_ITEM)
                .add(Registration.TIN_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_TIN_ORE_ITEM.get());

        tag(Registration.LEAD_ORES_ITEM)
                .add(Registration.LEAD_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_LEAD_ORE_ITEM.get());

        tag(Registration.SILVER_ORES_ITEM)
                .add(Registration.SILVER_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_SILVER_ORE_ITEM.get());

        tag(Registration.TUNGSTEN_ORES_ITEM)
                .add(Registration.TUNGSTEN_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_TUNGSTEN_ORE_ITEM.get());

        tag(Registration.PLATINUM_ORES_ITEM)
                .add(Registration.PLATINUM_ORE_ITEM.get())
                .add(Registration.DEEPSLATE_PLATINUM_ORE_ITEM.get());


    }


}
