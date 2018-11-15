package cz.fit.miadp.mvcgame.strategy;

public interface IMovementStrategy
{
    String getName();
    int nextPosX(int initX, float initPower, float initAngle, long lifetime);
    int nextPosY(int initY, float initPower, float initAngle, long lifetime);
}