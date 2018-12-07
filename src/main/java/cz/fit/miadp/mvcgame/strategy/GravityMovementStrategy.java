package cz.fit.miadp.mvcgame.strategy;

import cz.fit.miadp.mvcgame.config.GameConfig;

public class GravityMovementStrategy implements IMovementStrategy {

    @Override
    public int nextPosX(int initX, float initPower, float initAngle, long lifetime) {
        return (int)(initX + ( lifetime * initPower * Math.cos(initAngle)));
    }

    @Override
    public int nextPosY(int initY, float initPower, float initAngle, long lifetime) {
        return (int)(initY + (Math.pow(lifetime * (initPower / GameConfig.GRAVITY_STEP), 1.5f)) + initAngle);
    }

    @Override
    public boolean equals(IMovementStrategy strategy) {
        return strategy.getName().equals(this.getName());
    }

    @Override
    public String getName() {
        return "Gravity";
    }
}
