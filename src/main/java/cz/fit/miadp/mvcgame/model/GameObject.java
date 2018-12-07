package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.config.GameConfig;
import cz.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class GameObject {

    private int posX = GameConfig.INIT_POS_X;
    private int posY = GameConfig.INIT_POS_Y;

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
        bCollides = bCollides && (Math.abs(aX-bX) < GameConfig.COLLIDE_FACTOR);
        bCollides = bCollides && (Math.abs(aY-bY) < GameConfig.COLLIDE_FACTOR);

        return bCollides;
    }

    public abstract void move();
    public abstract void acceptVisitor(IVisitor visitor);
}
