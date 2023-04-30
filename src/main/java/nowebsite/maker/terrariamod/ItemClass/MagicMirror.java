package nowebsite.maker.terrariamod.ItemClass;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.terrariamod.setup.Registration;
import org.jetbrains.annotations.NotNull;

public class MagicMirror extends Item {
    public MagicMirror(Properties properties) {
        super(properties);
    }
    /*@Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide&&hand == InteractionHand.MAIN_HAND) {
            HitResult hitResult = player.pick(2,0,false);
            Vec3 location = hitResult.getLocation();
            BlockPos blockPos = new BlockPos(location.x, location.y, location.z);
            BlockState hitBlockState = level.getBlockState(blockPos);
            if(hitBlockState.is(Blocks.BEDROCK)){
                player.setItemInHand(InteractionHand.MAIN_HAND, Registration.BRICK_MIRROR.get().getDefaultInstance());
                return super.use(level, player, hand);
            }
            try {
                player.getCooldowns().addCooldown(this,38);
                Thread.sleep(2700);
                player.teleportTo(level.getLevelData().getXSpawn(),level.getLevelData().getYSpawn(),level.getLevelData().getZSpawn());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.use(level, player, hand);
    }*/

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 30;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.SPYGLASS;
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        Level level = context.getLevel();

        Player player = context.getPlayer();
        assert player!=null;

        InteractionHand hand = context.getHand();
        if (!level.isClientSide&&hand == InteractionHand.MAIN_HAND) {
            BlockPos blockPos = context.getClickedPos();
            BlockState hitBlockState = level.getBlockState(blockPos);
            if(hitBlockState.is(Blocks.BEDROCK)){
                player.setItemInHand(InteractionHand.MAIN_HAND, Registration.BRICK_MIRROR.get().getDefaultInstance());
            }
        }
        return super.useOn(context);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull LivingEntity pLivingEntity) {
        Player player = pLivingEntity instanceof Player? (Player)pLivingEntity : null;
        if (player!= null) {
            player.getCooldowns().addCooldown(this, 10);
            player.teleportTo(pLevel.getLevelData().getXSpawn(), pLevel.getLevelData().getYSpawn(), pLevel.getLevelData().getZSpawn());
        }
        return pStack;
    }
}
