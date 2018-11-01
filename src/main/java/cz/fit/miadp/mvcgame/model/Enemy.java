package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.visitor.IVisitor;

public class Enemy extends GameObject {

    public void move()
    {
        
    }

    public void acceptVisitor(IVisitor visitor)
    {
        visitor.visitEnemy(this);
    }
    
}
