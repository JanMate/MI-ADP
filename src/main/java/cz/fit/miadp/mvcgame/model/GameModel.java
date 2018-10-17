package cz.fit.miadp.mvcgame.model;

public class GameModel 
{
    private Cannon cannon = new Cannon();
    private int score;
    private float gravity;
    // ..
    private int confMoveStep = 10;

    public Cannon getCannon()
    {
        return this.cannon;
    }

    public void moveCannonUp()
    {
        int y = this.cannon.getY();
        y -= confMoveStep;
        this.cannon.setY(y);
    }

    public void moveCannonDown()
    {
        int y = this.cannon.getY();
        y += confMoveStep;
        this.cannon.setY(y);
    }
}