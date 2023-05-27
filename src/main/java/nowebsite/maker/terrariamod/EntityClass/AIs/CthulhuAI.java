package nowebsite.maker.terrariamod.EntityClass.AIs;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;

public class CthulhuAI extends Goal {
    private final Monster boss;
    private Player target;
    private int chargeTime = 60;
    private int turnTime = 20;
    private int waitTime = 0;


    public CthulhuAI(Monster boss) {
        this.boss = boss;
    }

    @Override
    public boolean canUse() {
        this.target = boss.level.getNearestPlayer(boss, 100);
        return this.target != null;
    }

    @Override
    public void start() {
        this.chargeTime = 60;
        this.turnTime = 20;
        this.waitTime = 0;
    }

    @Override
    public void stop() {
        this.target = null;
    }

    @Override
    public void tick() {
        if (this.waitTime > 0) {
            this.waitTime--;
        } else if (this.turnTime > 0) {
            // smoothly turn to player
            this.boss.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
            this.turnTime--;
        } else if (this.chargeTime > 0) {
            // rush to player
            this.boss.getMoveControl().setWantedPosition(this.target.getX(), this.target.getY(), this.target.getZ(), this.getChargeSpeed());
            this.chargeTime--;
        } else {
            // reset time and wait for the next rush
            this.waitTime = 40;
            this.turnTime = 20;
            this.chargeTime = 60;
        }
    }

    private double getChargeSpeed() {
        // return a speed computed with time
        return 4.0 - (this.chargeTime / 60.0) * 3.0;
    }
}
