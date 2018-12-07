package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.visitor.IVisitor;

public class ModelInfo extends GameObject {

    private GameModel model;

    public ModelInfo(GameModel model)
    {
        this.model = model;
    }

    public String getText()
    {
        return "Score: " + this.model.getScore()
                +" Cannon.Y: " + this.model.getCannon().getY()
                +" Cannon.Angle: " + this.model.getCannon().getAngle()
                +" Cannon.Power: " + this.model.getCannon().getPower()
                +" Missile.size: " + this.model.getMissiles().size()
                +" MoveStrg: " + this.model.getActiveMovementStrategy().getName()
                +" ShootMode: " + this.model.getCannon().getShootingMode().getName();
    }

    public void move()
    {
        
    }

    public void acceptVisitor(IVisitor visitor)
    {
        visitor.visitInfo(this);
    }
}
