package nowebsite.maker.terrariamod.setup;

import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.manasystem.network.PacketGatherMana;
import nowebsite.maker.terrariamod.manasystem.network.PacketGatherUseMana;
import nowebsite.maker.terrariamod.manasystem.network.PacketSyncManaToClient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class Messages {

    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(TerrariaMod.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(PacketGatherMana.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PacketGatherMana::new)
                .encoder(PacketGatherMana::toBytes)
                .consumer(PacketGatherMana::handle)
                .add();
        net.messageBuilder(PacketGatherUseMana.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PacketGatherUseMana::new)
                .encoder(PacketGatherUseMana::toBytes)
                .consumer(PacketGatherUseMana::handle)
                .add();
        net.messageBuilder(PacketSyncManaToClient.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PacketSyncManaToClient::new)
                .encoder(PacketSyncManaToClient::toBytes)
                .consumer(PacketSyncManaToClient::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

}
