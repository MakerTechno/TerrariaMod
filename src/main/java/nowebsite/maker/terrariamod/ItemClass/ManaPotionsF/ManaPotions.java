package nowebsite.maker.terrariamod.ItemClass.ManaPotionsF;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import nowebsite.maker.terrariamod.manasystem.data.PlayerMana;
import nowebsite.maker.terrariamod.manasystem.data.PlayerManaProvider;
import org.jetbrains.annotations.NotNull;

public abstract class ManaPotions extends Item {

    public ManaPotions(Properties properties) {
        super(properties);
    }

    @Override
    abstract public int getUseDuration(@NotNull ItemStack pStack);

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    @Override
    abstract public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) ;

    public ItemStack usePotions(ItemStack itemStack, @NotNull Level level, LivingEntity livingEntity, int regenerates) {
        boolean used = false;
        Player player = livingEntity instanceof Player? (Player)livingEntity : null;
        if (!level.isClientSide){
            if (
                    livingEntity.getCapability(PlayerManaProvider.PLAYER_MANA).map(PlayerMana::getMana).orElse(-1)
                    <
                    livingEntity.getCapability(PlayerManaProvider.PLAYER_MANA).map(PlayerMana::getManaMaxInt).orElse(-1)
            ) {
                if (player != null) {
                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (!player.getAbilities().instabuild) {
                        player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(playerMana -> playerMana.addMana(regenerates));
                        used=true;
                        itemStack.shrink(1);
                    }
                }
            }

            if (player == null || !player.getAbilities().instabuild) {
                if (itemStack.isEmpty()) {
                    return new ItemStack(Items.GLASS_BOTTLE);
                }
                if (player != null) {
                    player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
                }
            }
        }
        if (used){
            itemStack.shrink(1);
        }
        return itemStack;
    }

    @Override
    abstract public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull LivingEntity pEntityLiving);
}
