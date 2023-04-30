package nowebsite.maker.terrariamod.manasystem.network;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import nowebsite.maker.terrariamod.manasystem.data.ManaManager;
import nowebsite.maker.terrariamod.manasystem.data.PlayerManaProvider;

import java.util.function.Supplier;

public class PacketGatherMana {

    public static final String MESSAGE_NO_POTIONS = "message.nopotions";

    public PacketGatherMana() {
    }

    public PacketGatherMana(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are server side
            ServerPlayer player = ctx.getSender();


            player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(playerMana -> playerMana.addMana(10));
            /*
            int extracted = ManaManager.get(player.level).extractMana(player.blockPosition());
            if (extracted <= 0) {
                player.sendMessage(new TranslatableComponent(MESSAGE_NO_POTIONS).withStyle(ChatFormatting.RED), Util.NIL_UUID);
            } else {
                player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(playerMana -> {
                    playerMana.addMana(10);
                });
            }*/
        });
        return true;

    }
}
