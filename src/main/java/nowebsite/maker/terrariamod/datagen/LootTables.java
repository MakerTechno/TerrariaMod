package nowebsite.maker.terrariamod.datagen;

import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {
    public LootTables(DataGenerator dataGeneratorIn){
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables(){
/*--------------------------------------TIN ORES LOOT TABLES------------------------------------------*/
        lootTables.put(Registration.TIN_ORE.get(),
                createSilkTouchTable("tin_ore",Registration.TIN_ORE.get(),
                        Registration.RAW_TIN.get(),1,1));
        lootTables.put(Registration.DEEPSLATE_TIN_ORE.get(),
                createSilkTouchTable("deepslate_tin_ore",Registration.TIN_ORE.get(),
                        Registration.RAW_TIN.get(),1,1));

/*--------------------------------------LEAD ORES LOOT TABLES-----------------------------------------*/
        lootTables.put(Registration.LEAD_ORE.get(),
                createSilkTouchTable("lead_ore",Registration.LEAD_ORE.get(),
                        Registration.RAW_LEAD.get(),1,1));
        lootTables.put(Registration.DEEPSLATE_LEAD_ORE.get(),
                createSilkTouchTable("deepslate_lead_ore",Registration.LEAD_ORE.get(),
                        Registration.RAW_LEAD.get(),1,1));

/*--------------------------------------SILVER ORES LOOT TABLES-----------------------------------------*/
        lootTables.put(Registration.SILVER_ORE.get(),
                createSilkTouchTable("silver_ore",Registration.SILVER_ORE.get(),
                        Registration.RAW_SILVER.get(),1,1));
        lootTables.put(Registration.DEEPSLATE_SILVER_ORE.get(),
                createSilkTouchTable("deepslate_silver_ore",Registration.SILVER_ORE.get(),
                        Registration.RAW_SILVER.get(),1,1));

/*--------------------------------------TUNGSTEN ORES LOOT TABLES-----------------------------------------*/
        lootTables.put(Registration.TUNGSTEN_ORE.get(),
                createSilkTouchTable("tungsten_ore",Registration.TUNGSTEN_ORE.get(),
                        Registration.RAW_TUNGSTEN.get(),1,1));
        lootTables.put(Registration.DEEPSLATE_TUNGSTEN_ORE.get(),
                createSilkTouchTable("deepslate_tungsten_ore",Registration.TUNGSTEN_ORE.get(),
                        Registration.RAW_TUNGSTEN.get(),1,1));

/*--------------------------------------PLATINUM ORES LOOT TABLES-----------------------------------------*/
        lootTables.put(Registration.PLATINUM_ORE.get(),
                createSilkTouchTable("platinum_ore",Registration.PLATINUM_ORE.get(),
                        Registration.RAW_PLATINUM.get(),1,1));
        lootTables.put(Registration.DEEPSLATE_PLATINUM_ORE.get(),
                createSilkTouchTable("deepslate_platinum_ore",Registration.PLATINUM_ORE.get(),
                        Registration.RAW_PLATINUM.get(),1,1));


/*---------------------------------NETHER CRYSTAL ORES LOOT TABLES------------------------------------*/
        lootTables.put(Registration.NETHER_CRYSTAL_ORE.get(),
                createSilkTouchTable("nether_crystal_ore",Registration.NETHER_CRYSTAL_ORE.get(),
                        Registration.NETHER_CRYSTAL_ORE_ITEM.get(),1,1));


/*-------------------------------END PREDARKMATERIAL ORES LOOT TABLES---------------------------------*/
        lootTables.put(Registration.END_PREDARKMATERIAL_ORE.get(),
                createSilkTouchTable("end_predarkmaterial_ore",Registration.END_PREDARKMATERIAL_ORE.get(),
                        Registration.END_PREDARKMATERIAL_ORE_ITEM.get(),1,1));

/*----------------------------------------------OTHERS-----------------------------------------------*/
        lootTables.put(Registration.STEEL_MAKING_FURNACE.get(),
                createSilkTouchTable("steel_making_furnace",Registration.STEEL_MAKING_FURNACE.get(),
                        Registration.STEEL_MAKING_FURNACE_ITEM.get(),1,1));
    }
}
