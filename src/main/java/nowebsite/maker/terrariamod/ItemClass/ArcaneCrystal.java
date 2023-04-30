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

public class ArcaneCrystal extends Item {
    public ArcaneCrystal(Properties properties) {
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

    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull LivingEntity pLivingEntity) {
        boolean used = false;
        Player player = pLivingEntity instanceof Player? (Player)pLivingEntity : null;
        if (!pLevel.isClientSide) {
            boolean usedOver = pLevel.getCapability(PlayerManaProvider.PLAYER_MANA).map(PlayerMana::UseArcaneCrystal).orElse(false);
            if (usedOver) {
                if (player != null) {
                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (!player.getAbilities().instabuild) {
                        used=true;
                        pStack.shrink(1);
                    }
                }
            }
        }
        if (used){
            pStack.shrink(1);
        }
        return pStack;
    }
}
