package nowebsite.maker.terrariamod.datagen;

import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.manasystem.client.KeyBindings;
import nowebsite.maker.terrariamod.manasystem.network.PacketGatherMana;
import nowebsite.maker.terrariamod.manasystem.network.PacketGatherUseMana;
import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.data.DataGenerator;

import static nowebsite.maker.terrariamod.setup.ModSetup.TAB_NAME;

public class ENLanguageProvider extends net.minecraftforge.common.data.LanguageProvider {
    public ENLanguageProvider(DataGenerator generator, String locale) {
        super(generator, TerrariaMod.MODID,locale);
    }

    @Override
    protected void addTranslations() {
        /*Mod special group*/
        add("itemGroup."+TAB_NAME,"Terraria Mod");

        /*Mod key bindings*/
        add(KeyBindings.KEY_CATEGORIES_TERRARIAMOD, "Terraria mod keys");
        add(KeyBindings.KEY_FAST_MANA_REGENERATION, "Fast mana regeneration");
        add(PacketGatherMana.MESSAGE_NO_POTIONS, "No potions were found in your packet");
        add(PacketGatherUseMana.MESSAGE_NO_MANA, "Your mana is not enough");
        /*Magic mirror*/
        add(Registration.MAGIC_MIRROR.get(),"Magic mirror");
        add(Registration.BRICK_MIRROR.get(),"Brick mirror");

        /*Terraria mod info*/
        add(Registration.TERRARIA_MOD_INFO.get(),"Terraria mod");

        /**/
        add(Registration.DEMON_EYE.get(),"Demon eye");
        add(Registration.DEMON_EYE_EGG.get(), "Demon eye egg");

        //add(Registration.BOSS_CTHULHU.get(),"Cthulhu");

        add(Registration.TEST_32767_STICK.get(),"Test 32767 stick");
        add(Registration.MAGIC_GUN.get(), "Magic gun");

        /*Mana stars*/
        add(Registration.MANA_CRYSTAL.get(),"Mana crystal");
        add(Registration.ARCANE_CRYSTAL.get(),"Arcane crystal");

        /*Mana potions*/
        add(Registration.LESSER_MANA_POTION.get(),"Lesser mana potion");
        add(Registration.MANA_POTION.get(),"Mana potion");
        add(Registration.GREATER_MANA_POTION.get(),"Greater mana potion");
        add(Registration.SUPER_MANA_POTION.get(),"Super mana potion");

        /*Tins*/
        add(Registration.TIN_ORE.get(),"Tin ore");
        add(Registration.DEEPSLATE_TIN_ORE.get(),"Deepslate tin ore");
        add(Registration.RAW_TIN.get(),"Raw tin");
        add(Registration.TIN_INGOT.get(),"Tin ingot");
        add(Registration.TIN_HELMET.get(),"Tin helmet");
        add(Registration.TIN_CHESTPLATE.get(),"Tin chestplate");
        add(Registration.TIN_LEGGINGS.get(),"Tin leggings");
        add(Registration.TIN_BOOTS.get(),"Tin boots");
        add(Registration.TIN_SWORD.get(),"Tin sword");
        add(Registration.TIN_PICKAXE.get(),"Tin pickaxe");
        add(Registration.TIN_HOE.get(),"Tin hoe");
        add(Registration.TIN_AXE.get(),"Tin axe");
        add(Registration.TIN_SHOVEL.get(),"Tin shovel");

        /*Leads*/
        add(Registration.LEAD_ORE.get(),"Lead ore");
        add(Registration.DEEPSLATE_LEAD_ORE.get(),"Deepslate lead ore");
        add(Registration.RAW_LEAD.get(),"Raw lead");
        add(Registration.LEAD_INGOT.get(),"Lead ingot");
        add(Registration.LEAD_HELMET.get(),"Lead helmet");
        add(Registration.LEAD_CHESTPLATE.get(),"Lead chestplate");
        add(Registration.LEAD_LEGGINGS.get(),"Lead leggings");
        add(Registration.LEAD_BOOTS.get(),"Lead boots");
        add(Registration.LEAD_SWORD.get(),"Lead sword");
        add(Registration.LEAD_PICKAXE.get(),"Lead pickaxe");
        add(Registration.LEAD_HOE.get(),"Lead hoe");
        add(Registration.LEAD_AXE.get(),"Lead axe");
        add(Registration.LEAD_SHOVEL.get(),"Lead shovel");

        /*Silver*/
        add(Registration.SILVER_ORE.get(),"Silver ore");
        add(Registration.DEEPSLATE_SILVER_ORE.get(),"Deepslate silver ore");
        add(Registration.RAW_SILVER.get(),"Raw silver");
        add(Registration.SILVER_INGOT.get(),"Silver ingot");

        /*Tungsten*/
        add(Registration.TUNGSTEN_ORE.get(),"Tungsten ore");
        add(Registration.DEEPSLATE_TUNGSTEN_ORE.get(),"Deepslate tungsten ore");
        add(Registration.RAW_TUNGSTEN.get(),"Raw tungsten");
        add(Registration.TUNGSTEN_INGOT.get(),"Tungsten ingot");

        /*Platinum*/
        add(Registration.PLATINUM_ORE.get(),"Platinum ore");
        add(Registration.DEEPSLATE_PLATINUM_ORE.get(),"Deepslate platinum ore");
        add(Registration.RAW_PLATINUM.get(),"Raw platinum");
        add(Registration.PLATINUM_INGOT.get(),"Platinum ingot");


        /*Nether crystals*/
        add(Registration.NETHER_CRYSTAL_ORE.get(),"Nether crystal ore");
        add(Registration.NETHER_CRYSTAL_INGOT.get(),"Nether crystal ingot");

        /*End pre*/
        add(Registration.END_PREDARKMATERIAL_ORE.get(),"End predarkmaterial ore");
        add(Registration.END_PREDARKMATERIAL_INGOT.get(),"End predarkmaterial ingot");

        /*Special blocks*/
        add(Registration.STEEL_MAKING_FURNACE.get(),"Steel making furnace");



    }
}
