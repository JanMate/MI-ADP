package cz.fit.miadp.mvcgame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cz.fit.miadp.mvcgame.abstractFactory.DefaultGameObjectsFactory;
import cz.fit.miadp.mvcgame.abstractFactory.IGameObjectsFactory;
import cz.fit.miadp.mvcgame.config.GameConfig;
import cz.fit.miadp.mvcgame.observer.IObservable;
import cz.fit.miadp.mvcgame.observer.IObserver;
import cz.fit.miadp.mvcgame.proxy.IGameModel;
import cz.fit.miadp.mvcgame.strategy.IMovementStrategy;
import cz.fit.miadp.mvcgame.strategy.RandomMovementStrategy;
import cz.fit.miadp.mvcgame.strategy.SimpleMovementStrategy;

public class GameModel implements IObservable, IGameModel
{
    private Cannon cannon;
    private ModelInfo info;
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<Missile> missiles = new ArrayList<Missile>();
    private ArrayList<Collision> collisions = new ArrayList<Collision>();

    private int score = GameConfig.INIT_SCORE;
    private float gravity = GameConfig.INIT_GRAVITY;
    // ..
    
    private List<IObserver> myObservers = new ArrayList<IObserver>();
    private IGameObjectsFactory goFact;
    private Timer timer;
    private List<IMovementStrategy> movementStrategies = new ArrayList<IMovementStrategy>();
    private int activeMovementStrategyIndex = 0;

    public GameModel()
    {
        this.goFact = new DefaultGameObjectsFactory(this);

        this.movementStrategies.add( new SimpleMovementStrategy() );
        this.movementStrategies.add( new RandomMovementStrategy() );

        initGame();
        initTimer();
    }

    public ArrayList<Collision> getCollisions() {
        return collisions;
    }

    protected void initTimer()
    {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask(){
            @Override
            public void run() {
                // THE GAME LOOP
                moveGameObjects();
            }
        }, 0, GameConfig.TIME_TICK);
    }

    private void moveGameObjects() {
        moveMissiles();
        destroyInvisibleObjects();

        handleCollisions();

        this.notifyMyObservers();
    }

    private void handleCollisions() {
        List<Missile> missToRemove = new ArrayList<Missile>();
        List<Enemy> enemsToRemove = new ArrayList<Enemy>();

        for(Missile m : this.getMissiles())
        {
            for(Enemy e : this.getEnemies())
            {
                if(m.collidesWith(e))
                {
                    // remove m & e
                    missToRemove.add(m);
                    enemsToRemove.add(e);

                    // inc score
                    this.score++;

                    // create Collision
                    collisions.add( goFact.createCollision(m.getX(), m.getY()) );
                }
            }
        } 

        // collect old collisions
        List<Collision> collsToRemove = new ArrayList<Collision>();
        for(Collision c : this.collisions)
        {
            if(c.getLifetime() > GameConfig.COLLISION_LIFETIME)
            {
                collsToRemove.add(c);
            }
        }

        // remove stuff
        for(Collision c : collsToRemove)
            this.collisions.remove(c);
        for(Enemy e : enemsToRemove)
            this.enemies.remove(e);
        for(Missile m : missToRemove)
            this.missiles.remove(m);

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
        for(int i=0; i < GameConfig.MAX_ENEMIES; i++)
            this.enemies.add( this.goFact.createEnemy() );
    }

    public int getScore()
    {
        return this.score;
    }

    public int getMaxX()
    {
        return GameConfig.MAX_X;
    }

    public int getMaxY()
    {
        return GameConfig.MAX_Y;
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
        y -= GameConfig.MOVE_STEP;
        this.cannon.setY(y);

        this.notifyMyObservers();
    }

    public void moveCannonDown()
    {
        int y = this.cannon.getY();
        y += GameConfig.MOVE_STEP;
        this.cannon.setY(y);

        this.notifyMyObservers();
    }

    public void switchMovementStrategy()
    {
        activeMovementStrategyIndex = (activeMovementStrategyIndex + 1) % movementStrategies.size();
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
        this.missiles.addAll( this.cannon.shoot() );

        this.notifyMyObservers();
    }
    
    public void cannonToggleShootingMode()
    {
        this.cannon.toggleShootingMode();
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

	public IMovementStrategy getActiveMovementStrategy() {
		return this.movementStrategies.get(this.activeMovementStrategyIndex);
	}
}