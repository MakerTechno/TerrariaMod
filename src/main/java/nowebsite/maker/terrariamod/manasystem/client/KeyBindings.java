package nowebsite.maker.terrariamod.manasystem.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {

    public static final String KEY_CATEGORIES_TERRARIAMOD = "key.categories.terrariamod";
    public static final String KEY_FAST_MANA_REGENERATION = "key.fastManaRegeneration";

    public static KeyMapping fastManaRegeneration;

    public static void init() {
        // Use KeyConflictContext.IN_GAME to indicate this key is meant for usage in-game
        fastManaRegeneration = new KeyMapping(KEY_FAST_MANA_REGENERATION, KeyConflictContext.IN_GAME, InputConstants.getKey("key.keyboard.left.alt"), KEY_CATEGORIES_TERRARIAMOD);
        ClientRegistry.registerKeyBinding(fastManaRegeneration);
    }
}
