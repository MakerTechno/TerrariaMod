package nowebsite.maker.terrariamod.manasystem.data;

import net.minecraft.world.entity.player.Player;
import nowebsite.maker.terrariamod.setup.Messages;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;
import nowebsite.maker.terrariamod.manasystem.network.PacketSyncManaToClient;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class ManaManager extends SavedData {

    private final Map<ChunkPos, Mana> manaMap = new HashMap<>();

    private int counter = 0;

    @Nonnull
    public static ManaManager get(Level level) {
        if (level.isClientSide) {
            throw new RuntimeException("Don't access this client-side!");
        }
        DimensionDataStorage storage = ((ServerLevel)level).getDataStorage();
        return storage.computeIfAbsent(ManaManager::new, ManaManager::new, "manamanager");
    }




    public void tick(Level level) {
        counter--;
        if (counter <= 0) {
            counter = 4;
            // Synchronize the mana to the players in this world
            // todo expansion: keep the previous data that was sent to the player and only send if changed
            level.players().forEach(player -> {
                if (player instanceof ServerPlayer serverPlayer) {
                    int added = serverPlayer.getCapability(PlayerManaProvider.PLAYER_MANA)
                            .map(PlayerMana::Tick_AddMana).orElse(0);

                    int playerMana =
                            serverPlayer.getCapability(PlayerManaProvider.PLAYER_MANA)
                            .map(PlayerMana::getMana)
                            .orElse(-1);

                    int playerManaMaxInt =
                            serverPlayer.getCapability(PlayerManaProvider.PLAYER_MANA)
                            .map(PlayerMana::getManaMaxInt)
                            .orElse(-1);

                    int playerStars =
                            serverPlayer.getCapability(PlayerManaProvider.PLAYER_MANA)
                            .map(PlayerMana::getStarAddedManaInt)
                            .orElse(-1);

                    boolean usesArcaneCrystal =
                            serverPlayer.getCapability(PlayerManaProvider.PLAYER_MANA)
                            .map(PlayerMana::isUsesArcaneCrystal)
                            .orElse(false);

                    Messages.sendToPlayer(new PacketSyncManaToClient(playerMana, playerManaMaxInt, playerStars, usesArcaneCrystal), serverPlayer);
                }
            });

            // todo expansion: here it would be possible to slowly regenerate mana in chunks
        }
    }

    public ManaManager() {
    }

    public ManaManager(CompoundTag tag) {/*
        ListTag list = tag.getList("mana", Tag.TAG_COMPOUND);
        for (Tag t : list) {
            CompoundTag manaTag = (CompoundTag) t;
            Mana mana = new Mana(manaTag.getInt("mana"));
            ChunkPos pos = new ChunkPos(manaTag.getInt("x"), manaTag.getInt("z"));
            manaMap.put(pos, mana);
        }*/
    }

    @Override
    public CompoundTag save(CompoundTag tag) {/*
        ListTag list = new ListTag();
        manaMap.forEach((chunkPos, mana) -> {
            CompoundTag manaTag = new CompoundTag();
            manaTag.putInt("x", chunkPos.x);
            manaTag.putInt("z", chunkPos.z);
            manaTag.putInt("mana", mana.getMana());
            list.add(manaTag);
        });
        tag.put("mana", list);*/
        return tag;
    }


}
