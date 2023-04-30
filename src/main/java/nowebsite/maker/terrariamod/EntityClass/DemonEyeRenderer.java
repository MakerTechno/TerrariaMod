package nowebsite.maker.terrariamod.EntityClass;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import nowebsite.maker.terrariamod.TerrariaMod;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class DemonEyeRenderer extends LivingEntityRenderer<DemonEye,DemonEyeModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaMod.MODID, "textures/entity/demon_eye.png");

    public DemonEyeRenderer(EntityRendererProvider.Context context) {
        super(context, new DemonEyeModel(context.bakeLayer(DemonEyeModel.LAYER_LOCATION)), 1f);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@NotNull DemonEye entity) {
        return TEXTURE;
    }
}

