package nowebsite.maker.terrariamod.ItemClass;

import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class TerrariaModInfo extends Item {

    public TerrariaModInfo(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if(level.isClientSide && hand == InteractionHand.MAIN_HAND){
            final String description =
                    """
                    This work was created by Maker(R),for Terraria.
                    You should already know the basic rules and information from Terraria.
                    We will have a website soon.
                    """;
            player.sendMessage(Component.nullToEmpty(description), Util.NIL_UUID);
        }
        return super.use(level, player, hand);
    }

}
