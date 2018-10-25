package cz.fit.miadp.mvcgame.model;

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
}
