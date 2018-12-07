package cz.fit.miadp.mvcgame.strategy;

public class SimpleMovementStrategy implements IMovementStrategy
{

    @Override
    public int nextPosX(int initX, float initPower, float initAngle, long lifetime) {
        return (int)(initX + ( lifetime * initPower * Math.cos(initAngle)));
    }

    @Override
    public int nextPosY(int initY, float initPower, float initAngle, long lifetime) {
        return (int)(initY + ( lifetime * initPower * Math.sin(initAngle)));
    }

    @Override
    public boolean equals(IMovementStrategy strategy) {
        return strategy.getName().equals(this.getName());
    }

    @Override
    public String getName() {
        return "Simple";
    }

}