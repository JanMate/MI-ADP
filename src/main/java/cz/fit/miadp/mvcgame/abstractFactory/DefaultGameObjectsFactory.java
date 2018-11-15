package cz.fit.miadp.mvcgame.abstractFactory;

import java.util.Random;

import cz.fit.miadp.mvcgame.model.Cannon;
import cz.fit.miadp.mvcgame.model.Collision;
import cz.fit.miadp.mvcgame.model.Enemy;
import cz.fit.miadp.mvcgame.model.GameModel;
import cz.fit.miadp.mvcgame.model.Missile;
import cz.fit.miadp.mvcgame.model.ModelInfo;

public class DefaultGameObjectsFactory implements IGameObjectsFactory
{
    private GameModel model;

    public DefaultGameObjectsFactory(GameModel model)
    {
        this.model = model;
    }

    public Cannon createCannon()
    {
        Cannon cannon = new Cannon(this);
        cannon.setX(50);
        return cannon;
    }
    
    public Enemy createEnemy()
    {
        Random rand = new Random();
        
        int posY = rand.nextInt( this.model.getMaxY() );
        int posX = this.model.getCannon().getX()*2 + rand.nextInt( this.model.getMaxX() - (this.model.getCannon().getX()*2) );

        Enemy enemy = new Enemy();
        enemy.setX(posX);
        enemy.setY(posY);

        return enemy;
    }

    public Missile createMissile()
    {
        return new Missile(
            this.model.getCannon().getX(),
            this.model.getCannon().getY(),
            this.model.getCannon().getAngle(),
            this.model.getCannon().getPower(),
            this.model.getActiveMovementStrategy()
        );
    }

    public Collision createCollision(int x, int y)
    {
        Collision collision = new Collision();

        collision.setX(x);
        collision.setY(y);

        return collision;
    }

    public ModelInfo createModelInfo()
    {
        ModelInfo modelInfo = new ModelInfo(this.model);
        modelInfo.setY(10);
        modelInfo.setX(10);

        return modelInfo;
    }

}