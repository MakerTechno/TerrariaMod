package nowebsite.maker.terrariamod.EntityClass;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import nowebsite.maker.terrariamod.TerrariaMod;

public class DemonEyeModel extends EntityModel<DemonEye> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TerrariaMod.MODID, "demon_eye"), "main");
	private final ModelPart body;
	private final ModelPart tail;

	public DemonEyeModel(ModelPart root) {
		this.body = root.getChild("body");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(5, 3).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(30, 0).addBox(-3.0F, -9.0F, 5.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition fronts = body.addOrReplaceChild("fronts", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -8.0F, -6.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 5).addBox(-3.0F, -9.0F, -5.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rights = body.addOrReplaceChild("rights", CubeListBuilder.create().texOffs(0, 20).addBox(-6.0F, -8.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(4, 22).addBox(-5.0F, -9.0F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lefts = body.addOrReplaceChild("lefts", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(5.0F, -8.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(4, 22).mirror().addBox(4.0F, -9.0F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ups = body.addOrReplaceChild("ups", CubeListBuilder.create().texOffs(1, 41).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-3.0F, -11.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition downs = body.addOrReplaceChild("downs", CubeListBuilder.create().texOffs(1, 41).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(18, 22).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition f = tail.addOrReplaceChild("f", CubeListBuilder.create().texOffs(59, 1).addBox(2.0F, -5.0F, 6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(2.0F, -5.0F, 8.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(3.0F, -5.0F, 8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(3.0F, -4.0F, 9.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(3.0F, -4.0F, 11.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(4.0F, -4.0F, 11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition f2 = tail.addOrReplaceChild("f2", CubeListBuilder.create().texOffs(59, 1).addBox(2.0F, -4.0F, 6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(2.0F, -5.0F, 8.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(3.0F, -5.0F, 8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(3.0F, -5.0F, 10.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(4.0F, -5.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(4.0F, -6.0F, 11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -4.0F, 0.0F));

		PartDefinition f3 = tail.addOrReplaceChild("f3", CubeListBuilder.create().texOffs(59, 1).addBox(0.0F, -9.0F, 6.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(0.0F, -10.0F, 9.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(0.0F, -10.0F, 9.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-1.0F, -10.0F, 10.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition f4 = tail.addOrReplaceChild("f4", CubeListBuilder.create().texOffs(59, 1).addBox(-3.0F, -9.0F, 6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-4.0F, -9.0F, 8.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-4.0F, -9.0F, 8.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-4.0F, -10.0F, 10.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-5.0F, -10.0F, 13.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition f5 = tail.addOrReplaceChild("f5", CubeListBuilder.create().texOffs(59, 1).addBox(-3.0F, -6.0F, 6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-4.0F, -6.0F, 8.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-4.0F, -6.0F, 8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-4.0F, -5.0F, 9.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-5.0F, -5.0F, 12.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-5.0F, -5.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition f6 = tail.addOrReplaceChild("f6", CubeListBuilder.create().texOffs(59, 1).addBox(-1.0F, -3.0F, 6.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-1.0F, -3.0F, 9.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-1.0F, -2.0F, 9.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(0.0F, -2.0F, 11.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition f7 = tail.addOrReplaceChild("f7", CubeListBuilder.create().texOffs(59, 1).addBox(-1.0F, -3.0F, 6.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(-1.0F, -3.0F, 9.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(59, 1).addBox(0.0F, -2.0F, 9.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(DemonEye pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}