package cz.fit.miadp.mvcgame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

import cz.fit.miadp.mvcgame.abstractFactory.DefaultGameObjectsFactory;
import cz.fit.miadp.mvcgame.abstractFactory.IGameObjectsFactory;
import cz.fit.miadp.mvcgame.observer.IObservable;
import cz.fit.miadp.mvcgame.observer.IObserver;

public class GameModel implements IObservable
{
    private Cannon cannon;
    private ModelInfo info;
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<Missile> missiles = new ArrayList<Missile>();

    private int score;
    private float gravity;
    // ..
    private int confMaxX = 500;
    private int confMaxY = 500;
    private int confMoveStep = 10;
    private int confMaxEnemies = 10;
    private int confTimerPeriod = 30;
    
    private ArrayList<IObserver> myObservers = new ArrayList<IObserver>();
    private IGameObjectsFactory goFact;
    private Timer timer;

    public GameModel()
    {
        this.goFact = new DefaultGameObjectsFactory(this);

        initGame();
        initTimer();
    }

    protected void initTimer()
    {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask(){
            @Override
            public void run() {
                moveGameObjects();
            }
        }, 0, this.confTimerPeriod);
    }

    private void moveGameObjects() {
        moveMissiles();
        destroyInvisibleObjects();

        this.notifyMyObservers();
    }

    private void destroyInvisibleObjects() {
        HashSet<Missile> toRemove = new HashSet<Missile>();
        for(Missile m : this.getMissiles())
        {
            if( m.getX() < 0 || m.getX() > this.getMaxX() )
                toRemove.add(m);

            if( m.getY() < 0 || m.getY() > this.getMaxY() )
                toRemove.add(m);
        }

        for(Missile m : toRemove)
            this.missiles.remove(m);
    }

    private void moveMissiles() {
        for(Missile missile : this.getMissiles())
            missile.move();
    }

    public void initGame()
    {
        this.score = 0;
        this.gravity = 10.0f;
        this.cannon = this.goFact.createCannon();
        this.info = this.goFact.createModelInfo();
        
        this.enemies.clear();
        for(int i=0; i < confMaxEnemies; i++)
            this.enemies.add( this.goFact.createEnemy() );
    }

    public int getScore()
    {
        return this.score;
    }

    public int getMaxX()
    {
        return this.confMaxX;
    }

    public int getMaxY()
    {
        return this.confMaxY;
    }

    public ArrayList<Enemy> getEnemies()
    {
        return this.enemies;
    }

    public Cannon getCannon()
    {
        return this.cannon;
    }

    public ModelInfo getInfo() {
        return this.info;
    }

    public void moveCannonUp()
    {
        int y = this.cannon.getY();
        y -= confMoveStep;
        this.cannon.setY(y);

        this.notifyMyObservers();
    }

    public void moveCannonDown()
    {
        int y = this.cannon.getY();
        y += confMoveStep;
        this.cannon.setY(y);

        this.notifyMyObservers();
    }

    public void attachObserver(IObserver observer)
    {
        if(!this.myObservers.contains(observer))
            this.myObservers.add(observer);
    }

    public void deattachObserver(IObserver observer)
    {
        this.myObservers.remove(observer);
    }
    
    public void notifyMyObservers()
    {
        for (IObserver obs : this.myObservers) {
            obs.update();
        }
    }

    public ArrayList<Missile> getMissiles()
    {
        return this.missiles;
    }

	public void cannonShoot() {
        this.missiles.add( this.cannon.shoot(goFact) );

        this.notifyMyObservers();
	}

	public void aimCannonUp() {
        this.cannon.aimUp();

        this.notifyMyObservers();
	}

	public void aimCannonDown() {
        this.cannon.aimDown();

        this.notifyMyObservers();
	}

	public void incCannonPower() {
        this.cannon.incPower();

        this.notifyMyObservers();
	}

	public void decCannonPower() {
        this.cannon.decPower();

        this.notifyMyObservers();
	}

	public ArrayList<GameObject> getGameObjects() {
        ArrayList<GameObject> gos = new ArrayList<GameObject>();

        gos.addAll(this.enemies);
        gos.addAll(this.missiles);
        gos.add(this.cannon);
        gos.add(this.getInfo());

        return gos;
	}
}