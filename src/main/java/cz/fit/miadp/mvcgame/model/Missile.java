package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.visitor.IVisitor;

public class Missile extends GameObject {

    protected long created;
    protected int initX;
    protected int initY;
    protected float initAngle;
    protected float initPower;

    public Missile(int initX, int initY, float initAngle, float initPower)
    {
        this.initAngle = initAngle;
        this.initX = initX;
        this.initY = initY;
        this.initPower = initPower / 20.0f;
        this.created = System.currentTimeMillis();
        this.setX(initX);
        this.setY(initY);
    }

    public void move()
    {
        long lifetime = System.currentTimeMillis() - created;
        int newX = (int)(initX + ( lifetime * initPower * Math.cos(initAngle)));
        int newY = (int)(initY + ( lifetime * initPower * Math.sin(initAngle)));

        this.setX(newX);
        this.setY(newY);
    }

    public void acceptVisitor(IVisitor visitor)
    {
        visitor.visitMissile(this);
    }
    
}
