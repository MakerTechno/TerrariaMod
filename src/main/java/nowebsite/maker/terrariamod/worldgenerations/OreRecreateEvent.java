/*
package nowebsite.maker.terrariamod.worldgenerations;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import nowebsite.maker.terrariamod.setup.Registration;

import java.util.Random;

public class OreRecreateEvent {
    public static final Holder<PlacedFeature> LEAD_REPLACE_OREGEN = Ores.registerDefaultOreConfig(
            "lead_ore",
            new BlockMatchTest(Blocks.IRON_ORE),
                Registration.LEAD_ORE.get(),
    OreReferences.MAX_REPLACE_VEINSIZE,
    OreReferences.MAX_REPLACE_AMOUNT,
            VerticalAnchor.bottom(),
            VerticalAnchor.top());
    @SubscribeEvent
    public static void OreRecreate(TickEvent.WorldTickEvent event, BiomeLoadingEvent event1){
        int a = event.world.getFreeMapId();
        Random random = new Random(a);
        int seed = random.nextInt(6);
        if (seed==3) {
            event1.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, LEAD_REPLACE_OREGEN);
        }
    }
}
*/
