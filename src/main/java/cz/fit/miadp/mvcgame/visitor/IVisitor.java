package cz.fit.miadp.mvcgame.visitor;

import cz.fit.miadp.mvcgame.model.*;

public interface IVisitor
{
    void visitCannon(Cannon cannon);
    void visitEnemy(Enemy enemy);
    void visitMissile(Missile missile);
    void visitInfo(ModelInfo info);
    void visitCollision(Collision collision);
}