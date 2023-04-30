package nowebsite.maker.terrariamod.datagen;

import nowebsite.maker.terrariamod.TerrariaMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid= TerrariaMod.MODID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void GatherData(GatherDataEvent event){
        DataGenerator generator=event.getGenerator();
        if (event.includeServer()){
            generator.addProvider(new LootTables(generator));
            BlockTags blockTags=new BlockTags(generator,event.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new ItemTags(generator,blockTags,event.getExistingFileHelper()));
            generator.addProvider(new Recipes(generator));
        }
        if (event.includeClient()){
            generator.addProvider(new BlockStates(generator,event.getExistingFileHelper()));
            generator.addProvider(new ItemModels(generator,event.getExistingFileHelper()));
            generator.addProvider(new ENLanguageProvider(generator,"en_us"));
            //generator.addProvider(new ZHLanguageProvider(generator,"zh_cn"));
        }
    }
}
