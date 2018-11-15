package cz.fit.miadp.mvcgame.strategy;

import java.util.Random;

public class RandomMovementStrategy implements IMovementStrategy
{
    Random random = new Random();

    @Override
    public int nextPosX(int initX, float initPower, float initAngle, long lifetime) {
        return (random.nextInt(50)-25) + (int)(initX + ( lifetime * initPower * Math.cos(initAngle)));
    }

    @Override
    public int nextPosY(int initY, float initPower, float initAngle, long lifetime) {
        return (random.nextInt(50)-25) + (int)(initY + ( lifetime * initPower * Math.sin(initAngle)));
    }

    @Override
    public String getName() {
        return "Random";
    }

}