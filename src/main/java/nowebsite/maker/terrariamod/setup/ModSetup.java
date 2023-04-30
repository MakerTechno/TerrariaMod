package nowebsite.maker.terrariamod.setup;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nowebsite.maker.terrariamod.EntityClass.DemonEye;
import nowebsite.maker.terrariamod.TerrariaMod;
import nowebsite.maker.terrariamod.manasystem.data.ManaEvents;
import net.minecraft.world.entity.Entity;
import nowebsite.maker.terrariamod.worldgenerations.Ores;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid= TerrariaMod.MODID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
    public static final String TAB_NAME="terrariamod";
    public static final CreativeModeTab ITEM_GROUP=new CreativeModeTab(TAB_NAME) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Registration.TERRARIA_MOD_INFO.get());
        }
    };
    public static void init(@NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(Ores::registerConfiguredFeatures);
        Messages.register();
    }
    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addListener(Ores::onBiomeLoadingEvent);
        bus.addGenericListener(Entity.class, ManaEvents::onAttachCapabilitiesPlayer);
        bus.addListener(ManaEvents::onPlayerCloned);
        bus.addListener(ManaEvents::onRegisterCapabilities);
        bus.addListener(ManaEvents::onWorldTick);
    }

    @SubscribeEvent
    public static void onAttributeCreate(@NotNull EntityAttributeCreationEvent event){
        event.put(Registration.DEMON_EYE.get(), DemonEye.prepareAttributes().build());
    }
}
