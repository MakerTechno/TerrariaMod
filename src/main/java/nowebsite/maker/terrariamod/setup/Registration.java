package nowebsite.maker.terrariamod.setup;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.common.ForgeSpawnEggItem;
import nowebsite.maker.terrariamod.EntityClass.DemonEye;
import nowebsite.maker.terrariamod.EntityClass.DemonEyeModel;
//import nowebsite.maker.terrariamod.EntityClass.boss.Cthulhu;
import nowebsite.maker.terrariamod.ItemClass.*;
import nowebsite.maker.terrariamod.ItemClass.ManaPotionsF.GreaterManaPotion;
import nowebsite.maker.terrariamod.ItemClass.ManaPotionsF.LesserManaPotion;
import nowebsite.maker.terrariamod.ItemClass.ManaPotionsF.ManaPotion;
import nowebsite.maker.terrariamod.ItemClass.ManaPotionsF.SuperManaPotion;
import nowebsite.maker.terrariamod.Tier.ModToolTiers;
import nowebsite.maker.terrariamod.armor.ModArmorMaterials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static nowebsite.maker.terrariamod.TerrariaMod.MODID;

public class Registration {



    //register
    /**Blocks registry bus*/
    public static final DeferredRegister<Block> BLOCKS=DeferredRegister.create(ForgeRegistries.BLOCKS,MODID);
    /**Items registry bus*/
    public static final DeferredRegister<Item> ITEMS=DeferredRegister.create(ForgeRegistries.ITEMS,MODID);
    /**Entities registry bus*/
    public static final DeferredRegister<EntityType<?>> ENTITIES=DeferredRegister.create(ForgeRegistries.ENTITIES,MODID);
    /**Enchantments registry bus*/
    public static final DeferredRegister<Enchantment> ENCHANTMENTS=DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,MODID);
    /**Enchantments registry bus*/
    public static final DeferredRegister<Motive> PAINTINGS=DeferredRegister.create(ForgeRegistries.PAINTING_TYPES,MODID);
    /**Block entity registry bus*/
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES=DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,MODID);
    /**Containers registry bus*/
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS,MODID);


    //put those things to register, then game.
    public static void init(){
        //Get game's ModEventBus to put all things in.
        IEventBus bus= FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(bus);
        ITEMS.register(bus);
        ENTITIES.register(bus);
        ENCHANTMENTS.register(bus);
        PAINTINGS.register(bus);
        BLOCK_ENTITIES.register(bus);
        CONTAINERS.register(bus);
    }


    public static final Item.Properties ITEM_PROPERTIES=new Item.Properties().tab(ModSetup.ITEM_GROUP);
    public static final Item.Properties STACK_ONE_ITEM_PROPERTIES=new Item.Properties().tab(ModSetup.ITEM_GROUP).stacksTo(1);


    //blocks' items,it means when we put an item to the ground,the linked block will be load there.
    public static <B extends Block>RegistryObject<Item> fromBlock(RegistryObject<B> block){
        return ITEMS.register(block.getId().getPath(),()->new BlockItem(block.get(),ITEM_PROPERTIES));
    }



    /*------------------------Below are the blocks and items will be registered.-------------------------*/
    public static final RegistryObject<Motive> MAKER_AUTHOR_PAD = PAINTINGS.register("author_pad",()->new Motive(80,48));
    public static final RegistryObject<Motive> OLLIE_GIVE = PAINTINGS.register("ollie_give", ()->new Motive(32,32));
    public static final RegistryObject<Motive> TIAN_SUO_HAO_ER = PAINTINGS.register("tian_suo_hao_er",()->new Motive(32,32));

    /**magic mirror that teleport a few meters*/
    public static final RegistryObject<Item> BRICK_MIRROR = ITEMS.register("brick_mirror",()->new BrickMirror(STACK_ONE_ITEM_PROPERTIES));
    public static final RegistryObject<Item> MAGIC_MIRROR = ITEMS.register("magic_mirror",()->new MagicMirror(STACK_ONE_ITEM_PROPERTIES));
    /**Terraria mod's info generate item*/
    public static final RegistryObject<Item> TERRARIA_MOD_INFO = ITEMS.register("terraria_mod_info",()->new TerrariaModInfo(STACK_ONE_ITEM_PROPERTIES));

    public static final RegistryObject<Item> TEST_32767_STICK = ITEMS.register("test_32767_stick",()->new SwordItem(Tiers.NETHERITE,32763,0.1f,STACK_ONE_ITEM_PROPERTIES));
    public static final RegistryObject<Item> MAGIC_GUN = ITEMS.register("magic_gun", ()->new MagicGun(STACK_ONE_ITEM_PROPERTIES));

    /*---------------------------------------------Entities----------------------------------------------*/
    public static final RegistryObject<EntityType<DemonEye>> DEMON_EYE = ENTITIES.register("demon_eye",()->EntityType.Builder
            .of(DemonEye::new, MobCategory.MONSTER)
            .sized(0.6f, 0.6f)
            .clientTrackingRange(8)
            .setShouldReceiveVelocityUpdates(false)
            .build("demon_eye"));
    public static final RegistryObject<Item> DEMON_EYE_EGG = ITEMS.register("demon_eye",()->new ForgeSpawnEggItem(DEMON_EYE, 0xff0000, 0x00ff00, ITEM_PROPERTIES));
    /*public static final RegistryObject<EntityType<Cthulhu>> BOSS_CTHULHU = ENTITIES.register("cthulhu",()->EntityType.Builder
            .of(Cthulhu::new, MobCategory.MONSTER)
            .sized(0.6f, 0.6f)
            .clientTrackingRange(8)
            .setShouldReceiveVelocityUpdates(false)
            .build("cthulhu"));
*/
    /*----------------------------------------------MANA-------------------------------------------------*/
    public static final RegistryObject<Item> MANA_CRYSTAL = ITEMS.register("mana_crystal", ()->new ManaCrystal(ITEM_PROPERTIES));
    public static final RegistryObject<Item> ARCANE_CRYSTAL = ITEMS.register("arcane_crystal", ()->new ArcaneCrystal(ITEM_PROPERTIES));

    public static final RegistryObject<Item> LESSER_MANA_POTION = ITEMS.register("lesser_mana_potion", ()->new LesserManaPotion(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MANA_POTION = ITEMS.register("mana_potion", ()->new ManaPotion(ITEM_PROPERTIES));
    public static final RegistryObject<Item> GREATER_MANA_POTION = ITEMS.register("greater_mana_potion", ()->new GreaterManaPotion(ITEM_PROPERTIES));
    public static final RegistryObject<Item> SUPER_MANA_POTION = ITEMS.register("super_mana_potion", ()->new SuperManaPotion(ITEM_PROPERTIES));




    /*-----------------------------------TIN ORES,MATERIALS,UTILS----------------------------------------*/
    /**Tin ore*/
    public static final RegistryObject<Block> TIN_ORE=BLOCKS.register("tin_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(2.4f)));
    public static final RegistryObject<Item> TIN_ORE_ITEM=fromBlock(TIN_ORE);

    /**Tin ore which will be generated deeply underground,it changes it's looking and strength,others are the same to tin ore*/
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE=BLOCKS.register("deepslate_tin_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(2.6f)));
    public static final RegistryObject<Item> DEEPSLATE_TIN_ORE_ITEM=fromBlock(DEEPSLATE_TIN_ORE);

    /**Raw tin,it could drop when you destroyed a tin ore block*/
    public static final RegistryObject<Item> RAW_TIN=ITEMS.register("raw_tin",()->new Item(ITEM_PROPERTIES));

    /**Tin ingot,which could get by smelting "raw tin" item*/
    public static final RegistryObject<Item> TIN_INGOT=ITEMS.register("tin_ingot",()->new Item(ITEM_PROPERTIES));

    /**Tin group for tin group blocks,a tag*/
    public static final TagKey<Block> TIN_ORES= BlockTags.create(new ResourceLocation(MODID,"tin_ores"));

    /**Tin group for tin group item,a tag*/
    public static final TagKey<Item> TIN_ORES_ITEM= ItemTags.create(new ResourceLocation(MODID,"tin_ores"));

    /**Tin pickaxe like an iron pickaxe*/
    public static final RegistryObject<Item> TIN_PICKAXE = ITEMS.register("tin_pickaxe",()->new PickaxeItem(ModToolTiers.TIN,1,2f,STACK_ONE_ITEM_PROPERTIES));

    /**Tin helmet*/
    public static final RegistryObject<Item> TIN_HELMET = ITEMS.register("tin_helmet",() ->new ArmorItem(ModArmorMaterials.TIN, EquipmentSlot.HEAD,STACK_ONE_ITEM_PROPERTIES));
    /**Tin chestplate*/
    public static final RegistryObject<Item> TIN_CHESTPLATE = ITEMS.register("tin_chestplate",() ->new ArmorItem(ModArmorMaterials.TIN, EquipmentSlot.CHEST,STACK_ONE_ITEM_PROPERTIES));
    /**Tin leggings*/
    public static final RegistryObject<Item> TIN_LEGGINGS = ITEMS.register("tin_leggings",() ->new ArmorItem(ModArmorMaterials.TIN, EquipmentSlot.LEGS,STACK_ONE_ITEM_PROPERTIES));
    /**Tin boots*/
    public static final RegistryObject<Item> TIN_BOOTS = ITEMS.register("tin_boots",() ->new ArmorItem(ModArmorMaterials.TIN, EquipmentSlot.FEET,STACK_ONE_ITEM_PROPERTIES));
    /**Tin Tools(Just a Try)*/
    public static final RegistryObject<Item> TIN_SWORD = ITEMS.register("tin_sword",()->new SwordItem(ModToolTiers.TIN,3,0.6f,STACK_ONE_ITEM_PROPERTIES));
    public static final RegistryObject<Item> TIN_HOE = ITEMS.register("tin_hoe",()->new HoeItem(ModToolTiers.TIN,2,0.9f,STACK_ONE_ITEM_PROPERTIES));
    public static final RegistryObject<Item> TIN_AXE = ITEMS.register("tin_axe",()->new AxeItem(ModToolTiers.TIN,4,0.4f,STACK_ONE_ITEM_PROPERTIES));
    public static final RegistryObject<Item> TIN_SHOVEL = ITEMS.register("tin_shovel",()->new ShovelItem(ModToolTiers.TIN,1,0.9f,STACK_ONE_ITEM_PROPERTIES));


    /**Tin Tools Tag*/
    public static final TagKey<Block> NEEDS_TIN_TOOLS = BlockTags.create(new ResourceLocation(MODID,"needs_tin_tools"));

    /*---------------------------------LEAD ORES,MATERIALS,UTILS AND ARMORS-----------------------------------*/
    /**Lead ore*/
    public static final RegistryObject<Block> LEAD_ORE=BLOCKS.register("lead_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(3.8f)));
    public static final RegistryObject<Item> LEAD_ORE_ITEM=fromBlock(LEAD_ORE);

    /**Lead ore which will be generated deeply underground,it changes it's looking and strength,others are the same to lead ore*/
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE=BLOCKS.register("deepslate_lead_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(4.2f)));
    public static final RegistryObject<Item> DEEPSLATE_LEAD_ORE_ITEM=fromBlock(DEEPSLATE_LEAD_ORE);

    /**Raw lead,it could drop when you destroyed a lead ore block*/
    public static final RegistryObject<Item> RAW_LEAD=ITEMS.register("raw_lead",()->new Item(ITEM_PROPERTIES));

    /**Lead ingot,which could get by smelting "raw lead" item*/
    public static final RegistryObject<Item> LEAD_INGOT =ITEMS.register("lead_ingot",()->new Item(ITEM_PROPERTIES));

    /**Lead group for lead group blocks,a tag*/
    public static final TagKey<Block> LEAD_ORES= BlockTags.create(new ResourceLocation(MODID,"lead_ores"));

    /**Lead group for lead group item,a tag*/
    public static final TagKey<Item> LEAD_ORES_ITEM= ItemTags.create(new ResourceLocation(MODID,"lead_ores"));

    /**Lead Tools Tag*/
    public static final TagKey<Block> NEEDS_LEAD_TOOLS = BlockTags.create(new ResourceLocation(MODID,"needs_lead_tool"));

    /**Lead pickaxe like an iron pickaxe*/
    public static final RegistryObject<Item> LEAD_PICKAXE = ITEMS.register("lead_pickaxe",()->new PickaxeItem(ModToolTiers.LEAD,2,3f,STACK_ONE_ITEM_PROPERTIES));

    /**Lead helmet*/
    public static final RegistryObject<Item> LEAD_HELMET = ITEMS.register("lead_helmet",() ->new ArmorItem(ModArmorMaterials.LEAD, EquipmentSlot.HEAD,STACK_ONE_ITEM_PROPERTIES));
    /**Lead chestplate*/
    public static final RegistryObject<Item> LEAD_CHESTPLATE = ITEMS.register("lead_chestplate",() ->new ArmorItem(ModArmorMaterials.LEAD, EquipmentSlot.CHEST,STACK_ONE_ITEM_PROPERTIES));
    /**Lead leggings*/
    public static final RegistryObject<Item> LEAD_LEGGINGS = ITEMS.register("lead_leggings",() ->new ArmorItem(ModArmorMaterials.LEAD, EquipmentSlot.LEGS,STACK_ONE_ITEM_PROPERTIES));
    /**Lead boots*/
    public static final RegistryObject<Item> LEAD_BOOTS = ITEMS.register("lead_boots",() ->new ArmorItem(ModArmorMaterials.LEAD, EquipmentSlot.FEET,STACK_ONE_ITEM_PROPERTIES));
    /**Lead Tools(Just a Try)*/
    public static final RegistryObject<Item> LEAD_SWORD = ITEMS.register("lead_sword",()->new SwordItem(ModToolTiers.LEAD,14,0.6f,STACK_ONE_ITEM_PROPERTIES));
    public static final RegistryObject<Item> LEAD_HOE = ITEMS.register("lead_hoe",()->new HoeItem(ModToolTiers.LEAD,3,0.9f,STACK_ONE_ITEM_PROPERTIES));
    public static final RegistryObject<Item> LEAD_AXE = ITEMS.register("lead_axe",()->new AxeItem(ModToolTiers.LEAD,18,0.4f,STACK_ONE_ITEM_PROPERTIES));
    public static final RegistryObject<Item> LEAD_SHOVEL = ITEMS.register("lead_shovel",()->new ShovelItem(ModToolTiers.LEAD,2,0.9f,STACK_ONE_ITEM_PROPERTIES));

    /*-----------------------------------SILVER ORES,MATERIALS,UTILS----------------------------------------*/
    /**Silver ore*/
    public static final RegistryObject<Block> SILVER_ORE=BLOCKS.register("silver_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(6.2f)));
    public static final RegistryObject<Item> SILVER_ORE_ITEM=fromBlock(SILVER_ORE);

    /**Silver ore which will be generated deeply underground,it changes it's looking and strength,others are the same to silver ore*/
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE=BLOCKS.register("deepslate_silver_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(6.5f)));
    public static final RegistryObject<Item> DEEPSLATE_SILVER_ORE_ITEM=fromBlock(DEEPSLATE_SILVER_ORE);

    /**Raw silver,it could drop when you destroyed a silver ore block*/
    public static final RegistryObject<Item> RAW_SILVER=ITEMS.register("raw_silver",()->new Item(ITEM_PROPERTIES));

    /**Silver ingot,which could get by smelting "raw silver" item*/
    public static final RegistryObject<Item> SILVER_INGOT=ITEMS.register("silver_ingot",()->new Item(ITEM_PROPERTIES));


    /**Silver group for tin group blocks,a tag*/
    public static final TagKey<Block> SILVER_ORES= BlockTags.create(new ResourceLocation(MODID,"silver_ores"));

    /**Silver group for tin group item,a tag*/
    public static final TagKey<Item> SILVER_ORES_ITEM= ItemTags.create(new ResourceLocation(MODID,"silver_ores"));

    /**Silver Tools Tag*/
    public static final TagKey<Block> NEEDS_SILVER_TOOLS = BlockTags.create(new ResourceLocation(MODID,"needs_silver_tool"));

    /*-----------------------------------TUNGSTEN ORES,MATERIALS,UTILS----------------------------------------*/
    /**Tungsten ore*/
    public static final RegistryObject<Block> TUNGSTEN_ORE=BLOCKS.register("tungsten_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(6.2f)));
    public static final RegistryObject<Item> TUNGSTEN_ORE_ITEM=fromBlock(TUNGSTEN_ORE);

    /**Tungsten ore which will be generated deeply underground,it changes it's looking and strength,others are the same to tungsten ore*/
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE=BLOCKS.register("deepslate_tungsten_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(6.6f)));
    public static final RegistryObject<Item> DEEPSLATE_TUNGSTEN_ORE_ITEM=fromBlock(DEEPSLATE_TUNGSTEN_ORE);

    /**Raw tungsten,it could drop when you destroyed a tungsten ore block*/
    public static final RegistryObject<Item> RAW_TUNGSTEN=ITEMS.register("raw_tungsten",()->new Item(ITEM_PROPERTIES));

    /**Tungsten ingot,which could get by smelting "raw tungsten" item*/
    public static final RegistryObject<Item> TUNGSTEN_INGOT=ITEMS.register("tungsten_ingot",()->new Item(ITEM_PROPERTIES));

    /**Tungsten group for tin group blocks,a tag*/
    public static final TagKey<Block> TUNGSTEN_ORES= BlockTags.create(new ResourceLocation(MODID,"tungsten_ores"));

    /**Tungsten group for tin group item,a tag*/
    public static final TagKey<Item> TUNGSTEN_ORES_ITEM= ItemTags.create(new ResourceLocation(MODID,"tungsten_ores"));

    /**Tungsten Tools Tag*/
    public static final TagKey<Block> NEEDS_TUNGSTEN_TOOLS = BlockTags.create(new ResourceLocation(MODID,"needs_tungsten_tools"));

    /*-----------------------------------PLATINUM ORES,MATERIALS,UTILS----------------------------------------*/
    /**Platinum ore*/
    public static final RegistryObject<Block> PLATINUM_ORE=BLOCKS.register("platinum_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(8.1f)));
    public static final RegistryObject<Item> PLATINUM_ORE_ITEM=fromBlock(PLATINUM_ORE);

    /**Platinum ore which will be generated deeply underground,it changes it's looking and strength,others are the same to platinum ore*/
    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE=BLOCKS.register("deepslate_platinum_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(8.5f)));
    public static final RegistryObject<Item> DEEPSLATE_PLATINUM_ORE_ITEM=fromBlock(DEEPSLATE_PLATINUM_ORE);

    /**Raw platinum,it could drop when you destroyed a platinum ore block*/
    public static final RegistryObject<Item> RAW_PLATINUM=ITEMS.register("raw_platinum",()->new Item(ITEM_PROPERTIES));

    /**Platinum ingot,which could get by smelting "raw platinum" item*/
    public static final RegistryObject<Item> PLATINUM_INGOT=ITEMS.register("platinum_ingot",()->new Item(ITEM_PROPERTIES));

    /**Platinum group for tin group blocks,a tag*/
    public static final TagKey<Block> PLATINUM_ORES= BlockTags.create(new ResourceLocation(MODID,"platinum_ores"));

    /**Platinum group for tin group item,a tag*/
    public static final TagKey<Item> PLATINUM_ORES_ITEM= ItemTags.create(new ResourceLocation(MODID,"platinum_ores"));

    /**Platinum Tools Tag*/
    public static final TagKey<Block> NEEDS_PLATINUM_TOOLS = BlockTags.create(new ResourceLocation(MODID,"needs_platinum_tools"));

    //crystal group
    public static final RegistryObject<Block> NETHER_CRYSTAL_ORE=BLOCKS.register("nether_crystal_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(6.3f)));
    public static final RegistryObject<Item> NETHER_CRYSTAL_ORE_ITEM=fromBlock(NETHER_CRYSTAL_ORE);
    public static final RegistryObject<Item> NETHER_CRYSTAL_INGOT=ITEMS.register("nether_crystal_ingot",()->new Item(ITEM_PROPERTIES));

    //pre dark material group
    public static final RegistryObject<Block> END_PREDARKMATERIAL_ORE=BLOCKS.register("end_predarkmaterial_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(9.9f)));
    public static final RegistryObject<Item> END_PREDARKMATERIAL_ORE_ITEM=fromBlock(END_PREDARKMATERIAL_ORE);
    public static final RegistryObject<Item> END_PREDARKMATERIAL_INGOT=ITEMS.register("end_predarkmaterial_ingot",()->new Item(ITEM_PROPERTIES));

    //steel making furnace group
    public static final RegistryObject<Block> STEEL_MAKING_FURNACE=BLOCKS.register("steel_making_furnace",
            /*
            ()->new SteelMakingFurnaceBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.ANVIL)
                    .strength(15f).requiresCorrectToolForDrops().noOcclusion()));
                    */
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.ANVIL).requiresCorrectToolForDrops()
                    .strength(11.4f)));
    public static final RegistryObject<Item> STEEL_MAKING_FURNACE_ITEM=fromBlock(STEEL_MAKING_FURNACE);


}