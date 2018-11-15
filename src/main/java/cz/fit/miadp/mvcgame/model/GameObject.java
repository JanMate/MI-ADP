package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.config.GameConfig;
import cz.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class GameObject {

    private int posX = 100;
    private int posY = 100;

    public int getX() {
        return this.posX;
    }

    public void setX(int x) {
        this.posX = x;
    }

    public int getY() {
        return this.posY;
    }

    public void setY(int y) {
        this.posY = y;
    }

    public boolean collidesWith(GameObject otherObject)
    {
        boolean bCollides = true;

        int aX = this.getX();
        int aY = this.getY();
        int bX = otherObject.getX();
        int bY = otherObject.getY();

        //GameConfig.COLLIDE_FACTOR;
        //TODO

        return bCollides;
    }

    public abstract void move();
    public abstract void acceptVisitor(IVisitor visitor);
}
