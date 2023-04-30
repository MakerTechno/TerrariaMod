package nowebsite.maker.terrariamod.setup;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import nowebsite.maker.terrariamod.EntityClass.DemonEyeModel;
import nowebsite.maker.terrariamod.EntityClass.DemonEyeRenderer;
import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.manasystem.client.KeyBindings;
import nowebsite.maker.terrariamod.manasystem.client.KeyInputHandler;
import nowebsite.maker.terrariamod.manasystem.client.ManaOverlay;

import static net.minecraftforge.client.gui.ForgeIngameGui.HOTBAR_ELEMENT;

@Mod.EventBusSubscriber(modid= TerrariaMod.MODID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(FMLCommonSetupEvent event){
        MinecraftForge.EVENT_BUS.addListener(KeyInputHandler::onKeyInput);
        KeyBindings.init();
        OverlayRegistry.registerOverlayAbove(HOTBAR_ELEMENT,"name", ManaOverlay.HUD_MANA);
    }
    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DemonEyeModel.LAYER_LOCATION, DemonEyeModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.DEMON_EYE.get(), DemonEyeRenderer::new);
    }
}
