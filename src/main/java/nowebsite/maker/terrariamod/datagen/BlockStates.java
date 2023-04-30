package nowebsite.maker.terrariamod.datagen;

import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator generator, ExistingFileHelper helper){
        super(generator, TerrariaMod.MODID,helper);
    }

    @Override
    protected void registerStatesAndModels() {
        /*Tin ores*/
        simpleBlock(Registration.TIN_ORE.get());
        simpleBlock(Registration.DEEPSLATE_TIN_ORE.get());

        /*Lead ores*/
        simpleBlock(Registration.LEAD_ORE.get());
        simpleBlock(Registration.DEEPSLATE_LEAD_ORE.get());

        /*Silver ores*/
        simpleBlock(Registration.SILVER_ORE.get());
        simpleBlock(Registration.DEEPSLATE_SILVER_ORE.get());

        /*Tungsten ores*/
        simpleBlock(Registration.TUNGSTEN_ORE.get());
        simpleBlock(Registration.DEEPSLATE_TUNGSTEN_ORE.get());

        /*Platinum ores*/
        simpleBlock(Registration.PLATINUM_ORE.get());
        simpleBlock(Registration.DEEPSLATE_PLATINUM_ORE.get());



        simpleBlock(Registration.NETHER_CRYSTAL_ORE.get());

        simpleBlock(Registration.END_PREDARKMATERIAL_ORE.get());

        simpleBlock(Registration.STEEL_MAKING_FURNACE.get());

    }
}
