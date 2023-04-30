package nowebsite.maker.terrariamod.manasystem.client;

import net.minecraftforge.client.event.InputEvent;
import nowebsite.maker.terrariamod.manasystem.network.PacketGatherMana;
import nowebsite.maker.terrariamod.setup.Messages;

public class KeyInputHandler {

    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeyBindings.fastManaRegeneration.consumeClick()) {
            Messages.sendToServer(new PacketGatherMana());
        }
    }
}
