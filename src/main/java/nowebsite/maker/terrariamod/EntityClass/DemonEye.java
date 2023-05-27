package nowebsite.maker.terrariamod.EntityClass;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.terrariamod.EntityClass.AIs.CthulhuAI;
import nowebsite.maker.terrariamod.EntityClass.AIs.CustomFlyingGoal;
import nowebsite.maker.terrariamod.EntityClass.AIs.MobAvoidWaterGoal;
import nowebsite.maker.terrariamod.TerrariaMod;
import org.jetbrains.annotations.NotNull;

public class DemonEye extends Monster implements Enemy {

    public DemonEye(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.lookControl = new LookControl(this);
        this.moveControl = new FlyingMoveControl(this ,10,true);
        xpReward=10;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new MobAvoidWaterGoal(this));
        //this.goalSelector.addGoal(1, new CustomFlyingGoal(this));
        this.goalSelector.addGoal(1,new CthulhuAI(this));
    }

    @Override
    public void load(@NotNull CompoundTag pCompound) {
        super.load(pCompound);
    }

    @Override
    public boolean save(@NotNull CompoundTag pCompound) {
        return super.save(pCompound);
    }

    @Override
    public void travel(@NotNull Vec3 pTravelVector) {
        super.travel(pTravelVector);
    }

/**&@EYD*AED&$&$*(@___FUCK!Who care?Let it go and I'll never start it again.*/
    static class DemonEyeCircleAroundGoal extends Goal{
        private final Mob demonEye;
        private final Level level;
        private Player targetPlayer;

        private static final double SPEED = 0.8D;
        private int verticalMoveCooldown = 0;
        private boolean movingUpwards = false;

        public DemonEyeCircleAroundGoal(@NotNull Mob demonEye) {
            this.demonEye = demonEye;
            this.level = demonEye.getLevel();
        }

        private static final double MAX_DISTANCE_SQUARED = 256.0D; //16Block's square

        @Override
        public boolean canUse() {
            targetPlayer = level.getNearestPlayer(demonEye, 16.0D); //searching for nearest player
            if (targetPlayer == null) {
                TerrariaMod.LOGGER.info("Demon_eye: Couldn't find player");
                return false;
            }
            return demonEye.distanceTo(targetPlayer) < MAX_DISTANCE_SQUARED;
        }

        @Override
        public void start() {
            moveToPlayer();
        }

        @Override
        public void tick() {
            if (targetPlayer == null || !canUse()) {
                return;
            }
            moveToPlayer();

            if (verticalMoveCooldown <= 0) {
                movingUpwards = !movingUpwards;
                verticalMoveCooldown = 20 + demonEye.getRandom().nextInt(20);
            }

            double verticalSpeed = 0.05D;
            demonEye.lerpMotion(0, movingUpwards ? verticalSpeed : -verticalSpeed, 0);

            verticalMoveCooldown--;
        }

        private void moveToPlayer() {
            double x = targetPlayer.getX() - demonEye.getX();
            double z = targetPlayer.getZ() - demonEye.getZ();
            double distance = Math.sqrt(x * x + z * z);
            double desiredX = demonEye.getX() + x / distance * 2;
            double desiredZ = demonEye.getZ() + z / distance * 2;
            demonEye.getNavigation().moveTo(desiredX, demonEye.getY(), desiredZ, SPEED);
        }
    }

    public static AttributeSupplier.@NotNull Builder prepareAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 6D)//normal 18 for Terraria
                .add(Attributes.MAX_HEALTH, 22.0D)//normal 60 for Terraria
                .add(Attributes.FOLLOW_RANGE, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FLYING_SPEED, 1.0D);
    }
}
