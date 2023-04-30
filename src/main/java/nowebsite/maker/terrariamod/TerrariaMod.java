package nowebsite.maker.terrariamod;

import nowebsite.maker.terrariamod.setup.ClientSetup;
import nowebsite.maker.terrariamod.setup.ConfigSetup;
import nowebsite.maker.terrariamod.setup.ModSetup;
import nowebsite.maker.terrariamod.setup.Registration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//True,learning mod is helpful.Now I know "->" means create an no-name method.

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TerrariaMod.MODID)
public class TerrariaMod {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "terrariamod";
    public static final String VANILLA = "minecraft";

    public TerrariaMod() {
        LOGGER.warn("Terraria Mod is loading!This version of the mod was uncompleted,please using it carefully");
        LOGGER.info("This mod is the first mod from Maker(R),learn skills from McJty@github");

        // Register the deferred registry
        Registration.init();
        ModSetup.setup();
        ConfigSetup.register();


        // Register the setup method for mod-loading
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();

        //which always happens on each side
        modbus.addListener(ModSetup::init);

        //which happens only on client
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,()->()->modbus.addListener(ClientSetup::init));
    }

}