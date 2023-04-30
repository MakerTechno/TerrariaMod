package nowebsite.maker.terrariamod.manasystem.network;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import nowebsite.maker.terrariamod.manasystem.data.ManaManager;
import nowebsite.maker.terrariamod.manasystem.data.PlayerMana;
import nowebsite.maker.terrariamod.manasystem.data.PlayerManaProvider;

import java.util.function.Supplier;

public class PacketGatherUseMana {

    public static final String MESSAGE_NO_MANA = "message.nomana";
    public static int COST = 0;

    public PacketGatherUseMana(int cost) {
        COST = cost;
    }

    public PacketGatherUseMana(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are server side
            ServerPlayer player = ctx.getSender();
            int extra = player.getCapability(PlayerManaProvider.PLAYER_MANA).map(PlayerMana::getMana).orElse(-1);
            if (extra<=COST){
                player.sendMessage(new TranslatableComponent(MESSAGE_NO_MANA).withStyle(ChatFormatting.RED), Util.NIL_UUID);
            } else {
                player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(playerMana -> playerMana.costMana(COST));
            }


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
