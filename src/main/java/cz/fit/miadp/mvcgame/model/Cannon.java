package cz.fit.miadp.mvcgame.model;

import java.util.ArrayList;
import java.util.List;

import cz.fit.miadp.mvcgame.abstractFactory.IGameObjectsFactory;
import cz.fit.miadp.mvcgame.config.GameConfig;
import cz.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.fit.miadp.mvcgame.state.IShootingMode;
import cz.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.fit.miadp.mvcgame.visitor.IVisitor;

public class Cannon extends GameObject {
	private static final IShootingMode SINGLE_MODE = new SingleShootingMode();
	private static final IShootingMode DOUBLE_MODE = new DoubleShootingMode();

    protected float power = 10.0f;
	protected float angle = 0.0f;
	protected IGameObjectsFactory goFact;
	protected IShootingMode shootingMode;
	protected List<Missile> shootBatch;

	public Cannon(IGameObjectsFactory goFact)
	{
		this.goFact = goFact;
		this.setSingleShootingMode();
	}

	public IShootingMode getShootingMode()
	{
		return this.shootingMode;
	}


	public List<Missile> shoot() {
		shootBatch = new ArrayList<Missile>();
		shootingMode.shoot(this);
		return shootBatch;
	}

	public void toggleShootingMode()
	{
		shootingMode.nextMode(this);
	}
	
	public void primitiveShoot() {
		shootBatch.add( goFact.createMissile() );
	}
	
	public void setSingleShootingMode() {
		shootingMode = SINGLE_MODE;
	}

	public void setDoubleShootingMode() {
		shootingMode = DOUBLE_MODE;
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
        this.angle -= GameConfig.ANGLE_STEP;
	}

	public void aimDown() {
        this.angle += GameConfig.ANGLE_STEP;
	}

	public void incPower() {
        this.power += GameConfig.POWER_STEP;
	}

	public void decPower() {
        this.power -= GameConfig.POWER_STEP;
	}

    public void acceptVisitor(IVisitor visitor)
    {
        visitor.visitCannon(this);
    }

	

	
}
