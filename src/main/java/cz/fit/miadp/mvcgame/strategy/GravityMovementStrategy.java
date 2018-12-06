package cz.fit.miadp.mvcgame.strategy;

public class GravityMovementStrategy implements IMovementStrategy {

    @Override
    public int nextPosX(int initX, float initPower, float initAngle, long lifetime) {
        return (int)(initX + ( lifetime * initPower * Math.cos(initAngle)));
    }

    @Override
    public int nextPosY(int initY, float initPower, float initAngle, long lifetime) {
        return (int)(initY + (Math.pow(lifetime * (initPower / 10), 1.5)) + initAngle);
    }

    @Override
    public String getName() {
        return "Gravity";
    }
}
