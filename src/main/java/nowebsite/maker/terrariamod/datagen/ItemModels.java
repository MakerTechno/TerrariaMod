package nowebsite.maker.terrariamod.datagen;

import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

@SuppressWarnings("all")
public class ItemModels extends ItemModelProvider {

    public ItemModels(DataGenerator generator, ExistingFileHelper helper){
        super(generator, TerrariaMod.MODID,helper);
    }
    @Override
    protected void registerModels() {
        /*Magic mirror*/
        singleTexture(Registration.MAGIC_MIRROR.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/magic_mirror"));
        singleTexture(Registration.BRICK_MIRROR.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/brick_mirror"));
        /*Terraria mod info*/
        singleTexture(Registration.TERRARIA_MOD_INFO.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/terraria_mod_info"));

        singleTexture(Registration.TEST_32767_STICK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/stick"));
        singleTexture(Registration.MAGIC_GUN.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/magic_gun"));

        /*Entity*/
        withExistingParent(Registration.DEMON_EYE_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        /*Mana stars*/
        singleTexture(Registration.MANA_CRYSTAL.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/mana_crystal"));
        singleTexture(Registration.ARCANE_CRYSTAL.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/arcane_crystal"));

        /*Mana potions*/
        singleTexture(Registration.LESSER_MANA_POTION.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lesser_mana_potion"));
        singleTexture(Registration.MANA_POTION.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/mana_potion"));
        singleTexture(Registration.GREATER_MANA_POTION.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/greater_mana_potion"));
        singleTexture(Registration.SUPER_MANA_POTION.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/super_mana_potion"));

        /*Tins*/
        withExistingParent(Registration.TIN_ORE.get().getRegistryName().getPath(),
                modLoc("block/tin_ore"));
        withExistingParent(Registration.DEEPSLATE_TIN_ORE.get().getRegistryName().getPath(),
                modLoc("block/deepslate_tin_ore"));
        singleTexture(Registration.RAW_TIN.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_tin"));
        singleTexture(Registration.TIN_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_ingot"));

        singleTexture(Registration.TIN_PICKAXE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_pickaxe"));
        singleTexture(Registration.TIN_HELMET.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_helmet"));
        singleTexture(Registration.TIN_CHESTPLATE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_chestplate"));
        singleTexture(Registration.TIN_LEGGINGS.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_leggings"));
        singleTexture(Registration.TIN_BOOTS.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_boots"));
        singleTexture(Registration.TIN_SWORD.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_sword"));
        singleTexture(Registration.TIN_HOE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_hoe"));
        singleTexture(Registration.TIN_AXE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_axe"));
        singleTexture(Registration.TIN_SHOVEL.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tin_shovel"));

        /*Leads*/
        withExistingParent(Registration.LEAD_ORE.get().getRegistryName().getPath(),
                modLoc("block/lead_ore"));
        withExistingParent(Registration.DEEPSLATE_LEAD_ORE.get().getRegistryName().getPath(),
                modLoc("block/deepslate_lead_ore"));
        singleTexture(Registration.RAW_LEAD.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/raw_lead"));
        singleTexture(Registration.LEAD_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_ingot"));
        singleTexture(Registration.LEAD_PICKAXE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_pickaxe"));
        singleTexture(Registration.LEAD_HELMET.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_helmet"));
        singleTexture(Registration.LEAD_CHESTPLATE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_chestplate"));
        singleTexture(Registration.LEAD_LEGGINGS.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_leggings"));
        singleTexture(Registration.LEAD_BOOTS.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_boots"));
        singleTexture(Registration.LEAD_SWORD.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_sword"));
        singleTexture(Registration.LEAD_HOE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_hoe"));
        singleTexture(Registration.LEAD_AXE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_axe"));
        singleTexture(Registration.LEAD_SHOVEL.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/lead_shovel"));

        /*Silver*/
        withExistingParent(Registration.SILVER_ORE.get().getRegistryName().getPath(),
                modLoc("block/silver_ore"));
        withExistingParent(Registration.DEEPSLATE_SILVER_ORE.get().getRegistryName().getPath(),
                modLoc("block/deepslate_silver_ore"));
        singleTexture(Registration.RAW_SILVER.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_silver"));
        singleTexture(Registration.SILVER_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/silver_ingot"));

        /*Tungsten*/
        withExistingParent(Registration.TUNGSTEN_ORE.get().getRegistryName().getPath(),
                modLoc("block/tungsten_ore"));
        withExistingParent(Registration.DEEPSLATE_TUNGSTEN_ORE.get().getRegistryName().getPath(),
                modLoc("block/deepslate_tungsten_ore"));
        singleTexture(Registration.RAW_TUNGSTEN.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_tungsten"));
        singleTexture(Registration.TUNGSTEN_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/tungsten_ingot"));

        /*Platinum*/
        withExistingParent(Registration.PLATINUM_ORE.get().getRegistryName().getPath(),
                modLoc("block/platinum_ore"));
        withExistingParent(Registration.DEEPSLATE_PLATINUM_ORE.get().getRegistryName().getPath(),
                modLoc("block/deepslate_platinum_ore"));
        singleTexture(Registration.RAW_PLATINUM.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_platinum"));
        singleTexture(Registration.PLATINUM_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/platinum_ingot"));


        /*Others*/
        withExistingParent(Registration.NETHER_CRYSTAL_ORE.get().getRegistryName().getPath(),
                modLoc("block/nether_crystal_ore"));
        singleTexture(Registration.NETHER_CRYSTAL_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/nether_crystal_ingot"));

        withExistingParent(Registration.END_PREDARKMATERIAL_ORE.get().getRegistryName().getPath(),
                modLoc("block/end_predarkmaterial_ore"));
        singleTexture(Registration.END_PREDARKMATERIAL_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0",modLoc("item/end_predarkmaterial_ingot"));

        withExistingParent(Registration.STEEL_MAKING_FURNACE.get().getRegistryName().getPath(),
                modLoc("block/steel_making_furnace"));


    }
}
