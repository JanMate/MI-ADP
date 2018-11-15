package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.strategy.IMovementStrategy;
import cz.fit.miadp.mvcgame.visitor.IVisitor;

public class Missile extends LifetimeAwareGameObject {

    protected int initX;
    protected int initY;
    protected float initAngle;
    protected float initPower;
    protected IMovementStrategy movementStrategy;

    public Missile(int initX, int initY, float initAngle, float initPower, IMovementStrategy movementStrategy)
    {
        this.movementStrategy = movementStrategy;
        this.initAngle = initAngle;
        this.initX = initX;
        this.initY = initY;
        this.initPower = initPower / 20.0f;
        this.setX(initX);
        this.setY(initY);
    }

    public void move()
    {
        long lifetime = this.getLifetime();
        //int newX = (int)(initX + ( lifetime * initPower * Math.cos(initAngle)));
        //int newY = (int)(initY + ( lifetime * initPower * Math.sin(initAngle)));
        int newX = movementStrategy.nextPosX(initX, initPower, initAngle, lifetime);
        int newY = movementStrategy.nextPosY(initY, initPower, initAngle, lifetime);

        this.setX(newX);
        this.setY(newY);
    }

    public void acceptVisitor(IVisitor visitor)
    {
        visitor.visitMissile(this);
    }
    
}
