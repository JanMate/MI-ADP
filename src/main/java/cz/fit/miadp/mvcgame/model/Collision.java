package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.visitor.IVisitor;

public class Collision extends LifetimeAwareGameObject {

    public void move()
    {
        
    }

    public void acceptVisitor(IVisitor visitor)
    {
        visitor.visitCollision(this);
    }
    
}
