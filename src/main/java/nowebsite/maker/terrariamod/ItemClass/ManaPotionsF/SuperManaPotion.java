package nowebsite.maker.terrariamod.ItemClass.ManaPotionsF;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SuperManaPotion extends ManaPotions{

    public static final int REGENERATE_CONS = 300;

    public SuperManaPotion(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 10;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack usePotions(ItemStack itemStack, @NotNull Level level, LivingEntity livingEntity, int regenerates) {
        return super.usePotions(itemStack,level,livingEntity,regenerates);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull LivingEntity pEntityLiving) {
        return usePotions(pStack,pLevel,pEntityLiving,REGENERATE_CONS);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pHand) {
        return super.use(pLevel, pPlayer, pHand);
    }
}
