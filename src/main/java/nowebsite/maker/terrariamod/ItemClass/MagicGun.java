package nowebsite.maker.terrariamod.ItemClass;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import nowebsite.maker.terrariamod.manasystem.data.PlayerMana;
import nowebsite.maker.terrariamod.manasystem.data.PlayerManaProvider;
import nowebsite.maker.terrariamod.manasystem.network.PacketGatherUseMana;
import nowebsite.maker.terrariamod.setup.Messages;
import org.jetbrains.annotations.NotNull;

public class MagicGun extends BowItem {
    public static final int SHOULD_COST = 6;
    public MagicGun(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(@NotNull ItemStack itemStack, Level level, @NotNull LivingEntity livingEntity, int heldCount) {
        if (!level.isClientSide) {
            int playerMana = livingEntity.getCapability(PlayerManaProvider.PLAYER_MANA).map(PlayerMana::getMana).orElse(-1);
            if(playerMana>=SHOULD_COST) {
                Messages.sendToServer(new PacketGatherUseMana(SHOULD_COST));
                super.releaseUsing(itemStack, level, livingEntity, heldCount);
            }
        }
    }
}
