package nowebsite.maker.terrariamod.manasystem.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import nowebsite.maker.terrariamod.manasystem.client.ClientManaData;

import java.util.function.Supplier;

public class PacketSyncManaToClient {

    private final int playerMana;
    private final int playerManaMaxInt;
    private final int playerStars;
    private final boolean usesArcaneCrystal;


    public PacketSyncManaToClient(int playerMana, int playerManaMaxInt,int playerStars,boolean usesArcaneCrystal) {
        this.playerMana = playerMana;
        this.playerManaMaxInt = playerManaMaxInt;
        this.playerStars = playerStars;
        this.usesArcaneCrystal = usesArcaneCrystal;
    }

    public PacketSyncManaToClient(FriendlyByteBuf buf) {
        playerMana = buf.readInt();
        playerManaMaxInt = buf.readInt();
        playerStars = buf.readInt();
        usesArcaneCrystal = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(playerMana);
        buf.writeInt(playerManaMaxInt);
        buf.writeInt(playerStars);
        buf.writeBoolean(usesArcaneCrystal);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are client side.
            // Be very careful not to access client-only classes here! (like Minecraft) because
            // this packet needs to be available server-side too
            ClientManaData.set(playerMana, playerManaMaxInt, playerStars, usesArcaneCrystal);
        });
        return true;
    }
}
