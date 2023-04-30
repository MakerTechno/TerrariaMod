package nowebsite.maker.terrariamod.ItemClass;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import nowebsite.maker.terrariamod.manasystem.data.PlayerMana;
import nowebsite.maker.terrariamod.manasystem.data.PlayerManaProvider;
import org.jetbrains.annotations.NotNull;

public class ManaCrystal extends Item {
    public ManaCrystal(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack itemStack) {
        return 30;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.SPYGLASS;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player? (Player)livingEntity : null;
        boolean used = false;
        if (!level.isClientSide) {
            if (player!=null) {
                boolean usedOver = player.getCapability(PlayerManaProvider.PLAYER_MANA).map(PlayerMana::addManaMaxIntByMagicStar).orElse(false);
                if (usedOver) {
                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (!player.getAbilities().instabuild) {
                        used=true;
                        itemStack.shrink(1);
                    }
                }
            }
        }
        if (used){
            itemStack.shrink(1);
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

}
