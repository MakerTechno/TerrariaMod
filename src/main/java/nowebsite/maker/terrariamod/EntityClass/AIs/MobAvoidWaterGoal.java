package nowebsite.maker.terrariamod.EntityClass.AIs;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;

import java.util.Random;

public class MobAvoidWaterGoal extends Goal {
    private final Mob mob;
    private final PathNavigation mobNavigation;

    public MobAvoidWaterGoal(Mob mob) {
        this.mob = mob;
        this.mobNavigation = mob.getNavigation();
    }

    @Override
    public boolean canUse() {
        return mob.isInWater() || mobNavigation.isStableDestination(new BlockPos(mob.getX(), mob.getY(), mob.getZ()).below()) && mob.level.getFluidState(new BlockPos(mob.getX(), mob.getY(), mob.getZ()).below()).is(FluidTags.WATER);
    }

    @Override
    public void start() {
        Random random = mob.getRandom();
        double x = mob.getX() + (random.nextDouble() * 2 - 1) * 16.0;
        double y = mob.getY() + (random.nextDouble() * 2 - 1) * 16.0;
        double z = mob.getZ() + (random.nextDouble() * 2 - 1) * 16.0;
        mobNavigation.moveTo(x, y, z, 1.0);
    }
}
