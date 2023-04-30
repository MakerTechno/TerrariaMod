package nowebsite.maker.terrariamod.ItemClass;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class BrickMirror extends Item {
    public BrickMirror(Properties properties) {
        super(properties);
    }
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide&&hand == InteractionHand.MAIN_HAND) {
            HitResult hitResult = player.pick(20,0,false);
            Vec3 location=hitResult.getLocation();
            player.teleportTo(location.x,location.y,location.z);
            player.getCooldowns().addCooldown(this,80);
        }
        return super.use(level, player, hand);
    }
}
