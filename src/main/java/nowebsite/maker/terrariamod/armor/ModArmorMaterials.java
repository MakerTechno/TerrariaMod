package nowebsite.maker.terrariamod.armor;

import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0.1F, 0.0F,
            () -> Ingredient.of(Items.LEATHER)),

    CHAIN("chainmail", 8, new int[]{1, 4, 5, 2}, 12,
            SoundEvents.ARMOR_EQUIP_CHAIN, 0.1F, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT)),

    TIN("tin", 11, new int[]{2, 4, 5, 2}, 12,
            SoundEvents.ARMOR_EQUIP_IRON, 0.2F, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT)),

    IRON("iron", 15, new int[]{2, 5, 6, 2}, 9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.8F, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT)),

    LEAD("lead", 14,new int[]{2, 5, 6, 2}, 10,
            SoundEvents.ARMOR_EQUIP_IRON, 0.8F, 0.0F,
            () -> Ingredient.of(Registration.LEAD_INGOT.get())),

    SILVER("silver", 20,new int[]{3, 6, 7, 2}, 12,
            SoundEvents.ARMOR_EQUIP_IRON, 1.1F, 0.0F,
            () -> Ingredient.of(Registration.SILVER_INGOT.get())),

    TUNGSTEN("tungsten", 20,new int[]{3, 6, 7, 2}, 11,
            SoundEvents.ARMOR_EQUIP_IRON, 1.2F, 0.0F,
            () -> Ingredient.of(Registration.TUNGSTEN_INGOT.get())),

    GOLD("gold", 9, new int[]{4, 6, 7, 3}, 14,
            SoundEvents.ARMOR_EQUIP_GOLD, 1.4F, 0.0F,
            () -> Ingredient.of(Items.GOLD_INGOT)),

    PLATINUM("platinum", 32, new int[]{5, 7, 7, 4}, 13,
            SoundEvents.ARMOR_EQUIP_GOLD, 1.8F, 0.0F,
            () -> Ingredient.of(Registration.PLATINUM_INGOT.get())),

    DIAMOND("diamond", 33, new int[]{6, 7, 8, 4}, 12,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F,
            () -> Ingredient.of(Items.DIAMOND)),

    TURTLE("turtle", 25, new int[]{2, 5, 6, 2}, 9,
            SoundEvents.ARMOR_EQUIP_TURTLE, 1.0F, 0.0F,
            () -> Ingredient.of(Items.SCUTE)),

    NETHERITE("netherite", 37, new int[]{7, 9, 9, 5}, 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            () -> Ingredient.of(Items.NETHERITE_INGOT));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModArmorMaterials(String p_40474_, int p_40475_, int[] p_40476_, int p_40477_, SoundEvent p_40478_, float p_40479_, float p_40480_, Supplier<Ingredient> p_40481_) {
        this.name = p_40474_;
        this.durabilityMultiplier = p_40475_;
        this.slotProtections = p_40476_;
        this.enchantmentValue = p_40477_;
        this.sound = p_40478_;
        this.toughness = p_40479_;
        this.knockbackResistance = p_40480_;
        this.repairIngredient = new LazyLoadedValue<>(p_40481_);
    }

    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot p_40487_) {
        return this.slotProtections[p_40487_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull SoundEvent getEquipSound() {
        return this.sound;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public @NotNull String getName() {
        return TerrariaMod.MODID+":"+this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
/*
    private static SoundEvent register(String p_12657_) {
        return Registry.register(Registry.SOUND_EVENT, p_12657_, new SoundEvent(new ResourceLocation(p_12657_)));
    }*/
}

