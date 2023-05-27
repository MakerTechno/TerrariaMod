package nowebsite.maker.terrariamod.EntityClass.AIs;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

class CustomFlyingGoalEx extends Goal {
    private final PathfinderMob creature;
    private Vec3 start;
    private Vec3 velocity;
    private LivingEntity target;

    private static final double RADIUS = 4.0D;
    private static final double HEIGHT = 4.0D;
    private Vec3 targetPos;

    public CustomFlyingGoalEx(PathfinderMob creature) {
        this.creature = creature;
        this.target = this.creature.getTarget();
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
        this.start = this.creature.position();
        this.velocity = new Vec3(0.0D, 1.0D, 0.0D);
        this.targetPos = this.creature.position();
    }

    @Override
    public void tick() {
        long time = this.creature.level.getGameTime();
        this.target = this.creature.getTarget(); // 获取生物的攻击目标

        if (this.target != null && this.creature.distanceToSqr(this.target) < 2.0D) {
            // 如果有目标且生物触碰到玩家，沿抛物线反弹
            double x = start.x;
            double y = start.y - 0.5 * 9.8 * Math.pow(time, 2);
            double z = start.z;
            this.creature.getNavigation().moveTo(x, y, z, 1.0D);

            double vy = velocity.y - 9.8 * time;
            velocity = new Vec3(0.0D, vy, 0.0D);

            // 攻击玩家
            this.target.hurt(DamageSource.mobAttack(this.creature), (float) this.creature.getAttributeValue(Attributes.ATTACK_DAMAGE));
        } else {
            // 否则，沿曲线漫游并尝试向玩家俯冲
            if (this.target != null && this.creature.getSensing().hasLineOfSight(this.target)) {
                this.targetPos = this.target.position();
            }

            double x = this.targetPos.x + RADIUS * Math.cos(time * 0.01D);
            double y = this.targetPos.y + HEIGHT;
            double z = this.targetPos.z + RADIUS * Math.sin(time * 0.01D);

            this.creature.getNavigation().moveTo(x, y, z, 1.0D);
        }
    }
}

class CustomFlyingGoalExNew extends Goal {
    private final PathfinderMob creature;
    private Vec3 start;
    private Vec3 velocity;
    private LivingEntity target;

    private boolean isBouncing;
    private boolean isDiving;

    private static final double RADIUS = 4.0D;
    private static final double HEIGHT = 4.0D;
    private Vec3 targetPos;

    public CustomFlyingGoalExNew(PathfinderMob creature) {
        this.creature = creature;
        this.target = this.creature.getTarget();
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
        this.start = this.creature.position();
        this.velocity = new Vec3(0.0D, 1.0D, 0.0D);
        this.targetPos = this.creature.position();
    }

    @Override
    public void tick() {
        long time = this.creature.level.getGameTime();
        this.target = this.creature.getTarget(); // 获取生物的攻击目标

        if (this.isBouncing) {
            // 如果生物正在进行抛物线反弹
            double x = start.x + velocity.x * time;
            double y = start.y + velocity.y * time - 0.5 * 9.8 * Math.pow(time, 2);
            double z = start.z + velocity.z * time;
            this.creature.getNavigation().moveTo(x, y, z, 1.0D);

            double vy = velocity.y - 9.8 * time;
            velocity = new Vec3(velocity.x, vy, velocity.z);

            // 如果生物的y坐标超过了目标的y坐标+7，结束抛物线反弹
            if (this.creature.getY() > this.target.getY() + 7.0D) {
                this.isBouncing = false;
                isDiving = true;
            }
        } else if (this.isDiving) {
            // 如果生物正在向玩家俯冲
            if (this.target != null) {
                double x = this.target.getX();
                double y = this.target.getY();
                double z = this.target.getZ();
                this.creature.getNavigation().moveTo(x, y, z, 1.0D);

                if (this.creature.distanceToSqr(this.target) < 2.0D) {
                    // 如果生物触碰到玩家，结束俯冲
                    // 攻击玩家
                    this.target.hurt(DamageSource.mobAttack(this.creature), (float) this.creature.getAttributeValue(Attributes.ATTACK_DAMAGE));
                    this.isDiving = false;
                }
            }
        } else {
            // 否则，沿曲线漫游并尝试向玩家俯冲
            if (this.target != null && this.creature.getSensing().hasLineOfSight(this.target)) {
                this.targetPos = this.target.position();
                if (this.creature.getY() > this.target.getY() + 4.0D) {
                    // 如果生物的y坐标高于目标的y坐标+4，开始向玩家俯冲
                    this.isDiving = true;
                }
            }

            //游荡
            double x = this.targetPos.x + RADIUS * Math.cos(time * 0.01D);
            double y = this.targetPos.y + HEIGHT;
            double z = this.targetPos.z + RADIUS * Math.sin(time * 0.01D);

            this.creature.getNavigation().moveTo(x, y, z, 1.0D);
        }
    }


}


class MobAvoidWaterGoalEx extends Goal {
    private final Mob mob;
    private final PathNavigation mobNavigation;

    public MobAvoidWaterGoalEx(Mob mob) {
        this.mob = mob;
        this.mobNavigation = mob.getNavigation();
    }

    @Override
    public boolean canUse() {
        // 如果实体在水中，或者正在向水中移动，则返回true
        return mob.isInWater() || mobNavigation.isStableDestination(new BlockPos(mob.getX(), mob.getY(), mob.getZ()).below()) && mob.level.getFluidState(new BlockPos(mob.getX(), mob.getY(), mob.getZ()).below()).is(FluidTags.WATER);
    }

    @Override
    public void start() {
        // 改变实体的路径以避开水
        // 这只是一个示例，你可能需要根据实际情况调整代码
        Random random = mob.getRandom();
        double x = mob.getX() + (random.nextDouble() * 2 - 1) * 16.0;
        double y = mob.getY() + (random.nextDouble() * 2 - 1) * 16.0;
        double z = mob.getZ() + (random.nextDouble() * 2 - 1) * 16.0;
        mobNavigation.moveTo(x, y, z, 1.0);
    }
}


