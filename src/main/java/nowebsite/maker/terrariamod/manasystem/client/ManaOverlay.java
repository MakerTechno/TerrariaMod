package nowebsite.maker.terrariamod.manasystem.client;

import net.minecraftforge.client.gui.IIngameOverlay;
import nowebsite.maker.terrariamod.manasystem.ManaConfig;

public class ManaOverlay {

    public static final IIngameOverlay HUD_MANA = (gui, poseStack, partialTicks, width, height) -> {
        String toDisplay ="Mana: " + ClientManaData.getPlayerMana() + " / Total:" + ClientManaData.getPlayerManaMaxInt();
        int x = ManaConfig.MANA_HUD_X.get();
        int y = ManaConfig.MANA_HUD_Y.get();
        if (x >= 0 && y >= 0) {
            gui.getFont().draw(poseStack, toDisplay, x, y, ManaConfig.MANA_HUD_COLOR.get());
        }
    };
}
