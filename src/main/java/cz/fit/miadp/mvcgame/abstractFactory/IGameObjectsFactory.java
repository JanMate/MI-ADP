package cz.fit.miadp.mvcgame.abstractFactory;

import cz.fit.miadp.mvcgame.model.Cannon;
import cz.fit.miadp.mvcgame.model.Collision;
import cz.fit.miadp.mvcgame.model.Enemy;
import cz.fit.miadp.mvcgame.model.Missile;
import cz.fit.miadp.mvcgame.model.ModelInfo;

public interface IGameObjectsFactory
{
    Cannon createCannon();
    Enemy createEnemy();
    Missile createMissile();
    Collision createCollision(int x, int y);
    ModelInfo createModelInfo();

}