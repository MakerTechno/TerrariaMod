package nowebsite.maker.terrariamod.datagen;

import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, TerrariaMod.MODID,helper);
    }

    @Override
    protected void addTags(){
/*-------------------------------------------------Tools requests------------------------------------------------*/
        //mineable with pickaxe
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.TIN_ORE.get())
                .add(Registration.DEEPSLATE_TIN_ORE.get())

                .add(Registration.LEAD_ORE.get())
                .add(Registration.DEEPSLATE_LEAD_ORE.get())

                .add(Registration.SILVER_ORE.get())
                .add(Registration.DEEPSLATE_SILVER_ORE.get())

                .add(Registration.TUNGSTEN_ORE.get())
                .add(Registration.DEEPSLATE_TUNGSTEN_ORE.get())

                .add(Registration.PLATINUM_ORE.get())
                .add(Registration.DEEPSLATE_PLATINUM_ORE.get())

                .add(Registration.NETHER_CRYSTAL_ORE.get())

                .add(Registration.END_PREDARKMATERIAL_ORE.get())

                .add(Registration.STEEL_MAKING_FURNACE.get());

        //tin ores here just take the wood place,but wood is the lowest tool,so we only need "mineable with pickaxe"tag

        //stone&tin tools
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                //lead ores
                .add(Registration.LEAD_ORE.get())
                .add(Registration.DEEPSLATE_LEAD_ORE.get());

        //iron&lead tools
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                //silver ores
                .add(Registration.SILVER_ORE.get())
                .add(Registration.DEEPSLATE_SILVER_ORE.get())
                //tungsten ores
                .add(Registration.TUNGSTEN_ORE.get())
                .add(Registration.DEEPSLATE_TUNGSTEN_ORE.get())
                //others
                .add(Registration.NETHER_CRYSTAL_ORE.get());

        //silver&tungsten tools
        tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL)
                //platinum ores
                .add(Registration.PLATINUM_ORE.get())
                .add(Registration.DEEPSLATE_PLATINUM_ORE.get())
                //others
                .add(Registration.END_PREDARKMATERIAL_ORE.get())
                .add(Registration.STEEL_MAKING_FURNACE.get());

/*----------------------------------------------------Ore tag----------------------------------------------------*/
        tag(Tags.Blocks.ORES)
                .add(Registration.TIN_ORE.get())
                .add(Registration.DEEPSLATE_TIN_ORE.get())
                .add(Registration.LEAD_ORE.get())
                .add(Registration.DEEPSLATE_LEAD_ORE.get())
                .add(Registration.SILVER_ORE.get())
                .add(Registration.DEEPSLATE_SILVER_ORE.get())
                .add(Registration.TUNGSTEN_ORE.get())
                .add(Registration.DEEPSLATE_TUNGSTEN_ORE.get())
                .add(Registration.PLATINUM_ORE.get())
                .add(Registration.DEEPSLATE_PLATINUM_ORE.get())

                .add(Registration.NETHER_CRYSTAL_ORE.get())
                .add(Registration.END_PREDARKMATERIAL_ORE.get());

        tag(Registration.TIN_ORES)
                .add(Registration.TIN_ORE.get())
                .add(Registration.DEEPSLATE_TIN_ORE.get());

        tag(Registration.LEAD_ORES)
                .add(Registration.LEAD_ORE.get())
                .add(Registration.DEEPSLATE_LEAD_ORE.get());

        tag(Registration.SILVER_ORES)
                .add(Registration.SILVER_ORE.get())
                .add(Registration.DEEPSLATE_SILVER_ORE.get());

        tag(Registration.TUNGSTEN_ORES)
                .add(Registration.TUNGSTEN_ORE.get())
                .add(Registration.DEEPSLATE_TUNGSTEN_ORE.get());

        tag(Registration.PLATINUM_ORES)
                .add(Registration.PLATINUM_ORE.get())
                .add(Registration.DEEPSLATE_PLATINUM_ORE.get());

    }
}
