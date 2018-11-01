package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.abstractFactory.IGameObjectsFactory;
import cz.fit.miadp.mvcgame.visitor.IVisitor;

public class Cannon extends GameObject {

    protected float power = 10.0f;
    protected float angle = 0.0f;

    protected float confAngleStep = 0.2f;
    protected float confPowerStep = 1.0f;

	public Missile shoot(IGameObjectsFactory goFact) {
		return goFact.createMissile();
    }
    
    public void move()
    {
        //empty
    }

	public float getAngle() {
		return this.angle;
	}

	public float getPower() {
		return this.power;
	}

	public void aimUp() {
        this.angle -= confAngleStep;
	}

	public void aimDown() {
        this.angle += confAngleStep;
	}

	public void incPower() {
        this.power += confPowerStep;
	}

	public void decPower() {
        this.power -= confPowerStep;
	}

    public void acceptVisitor(IVisitor visitor)
    {
        visitor.visitCannon(this);
    }
}
