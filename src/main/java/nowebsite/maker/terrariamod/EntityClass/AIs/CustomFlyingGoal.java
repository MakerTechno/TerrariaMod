package nowebsite.maker.terrariamod.EntityClass.AIs;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class CustomFlyingGoal extends Goal {
    private int count = 0;
    private boolean roll = false;
    //debug upside
    
    private final PathfinderMob creature;
    private Vec3 start;
    private Vec3 velocity;
    private Player target;

    private boolean isBouncing;
    private boolean isDiving;

    private static final double RADIUS = 4.0D;
    private static final double HEIGHT = 4.0D;
    private Vec3 targetPos;

    public CustomFlyingGoal(PathfinderMob creature) {
        this.creature = creature;
        this.target = this.creature.getLevel().getNearestPlayer(this.creature,32D);
        this.start = creature.position();
        this.velocity = new Vec3(0.0D, 1.0D, 0.0D);
        this.targetPos = creature.position();
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void start() {
        this.velocity = new Vec3(0.0D, 1.0D, 0.0D);
        this.targetPos = this.creature.position();
    }

    @Override
    public void tick() {/*
        if (count>=50){
            roll = true;
        } else if (count<=-50){
            roll = false;
        }

        if (!roll){
            count++;
        }else {
            count--;
        }*/
        if (count>2000)count=1000;


        long time = this.creature.level.getGameTime();
        this.target = this.creature.getLevel().getNearestPlayer(this.creature,32D);

        if (this.isBouncing) {
            double x = start.x + velocity.x * time;
            double y = start.y + velocity.y * time - 0.5 * 9.8 * Math.pow(time, 2);
            double z = start.z + velocity.z * time;
            this.creature.getNavigation().moveTo(x, y, z,1.7D);

            double vy = velocity.y - 9.8 * time;
            velocity = new Vec3(velocity.x, vy, velocity.z);

            if (this.creature.getY() > this.target.getY() + 7.0D) {
                this.isBouncing = false;
                isDiving = true;
            }
        } else if (this.isDiving) {

            if (this.hasSurviveTarget()) {
                double x = this.target.getX();
                double y = this.target.getY();
                double z = this.target.getZ();
                this.creature.getNavigation().moveTo(x, y, z, 1.0D);

                if (this.creature.distanceToSqr(this.target) < 2.0D) {
                    this.target.hurt(DamageSource.mobAttack(this.creature), (float) this.creature.getAttributeValue(Attributes.ATTACK_DAMAGE));
                    this.isDiving = false;
                    this.isBouncing = true;
                    this.start = this.creature.position();
                }
            }
        } else {
            this.targetPos = this.creature.position();
            if (this.hasSurviveTarget() && this.creature.getSensing().hasLineOfSight(this.target)) {
                if (this.creature.getY() > this.target.getY() + 4.0D) {
                    this.isDiving = true;
                }
            }/*
            double x = this.targetPos.x + RADIUS * Math.cos(time * 0.01D);
            double y = this.targetPos.y + HEIGHT;
            double z = this.targetPos.z + RADIUS * Math.sin(time * 0.01D);*/
            if (count % 20 == 0) { // 1sec
                // randomly change ports
                this.velocity = Vec3.directionFromRotation(this.creature.getRandom().nextFloat() * 360F, this.creature.getRandom().nextFloat() * 180F - 90F);
            }

            double x = this.creature.getX() + 1;
            double y = this.creature.getY() + 1;
            double z = this.creature.getZ() + 1;
            this.creature.getNavigation().moveTo(x, y, z,this.creature.flyingSpeed);
            if (count%10==0) {
                //TerrariaMod.LOGGER.info("Mob: "+this.creature.getX()+" , "+this.creature.getY()+" , "+this.creature.getZ()+" ; "+"Move to: "+x+" , "+y+" , "+z);
            }
        }
        //if (count>=20)count=0;
    }

    private boolean hasSurviveTarget(){
        return this.target != EntitySelector.NO_SPECTATORS && this.target !=EntitySelector.NO_CREATIVE_OR_SPECTATOR && this.target != null ;
    }

}
