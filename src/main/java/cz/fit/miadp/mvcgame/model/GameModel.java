package cz.fit.miadp.mvcgame.model;

import java.util.ArrayList;
import java.util.Random;

import cz.fit.miadp.mvcgame.abstractFactory.DefaultGameObjectsFactory;
import cz.fit.miadp.mvcgame.abstractFactory.IGameObjectsFactory;
import cz.fit.miadp.mvcgame.observer.IObservable;
import cz.fit.miadp.mvcgame.observer.IObserver;

public class GameModel implements IObservable
{
    private Cannon cannon;
    private ModelInfo info;
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    private int score = 0;
    private float gravity = 10;
    // ..
    private int confMaxX = 500;
    private int confMaxY = 500;
    private int confMoveStep = 10;
    
    private ArrayList<IObserver> myObservers = new ArrayList<IObserver>();
    private IGameObjectsFactory goFact;

    public GameModel()
    {
        this.goFact = new DefaultGameObjectsFactory(this);
        this.cannon = this.goFact.createCannon();
        this.info = this.goFact.createModelInfo();
        
        int cnt = 10;
        while(cnt > 0)
        {
            this.enemies.add( this.goFact.createEnemy() );
            cnt--;
        }
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
}