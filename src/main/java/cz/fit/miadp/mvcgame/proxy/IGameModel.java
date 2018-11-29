package cz.fit.miadp.mvcgame.proxy;

import java.util.ArrayList;

import cz.fit.miadp.mvcgame.command.AbsGameCommand;
import cz.fit.miadp.mvcgame.command.CannonShootCommand;
import cz.fit.miadp.mvcgame.model.Cannon;
import cz.fit.miadp.mvcgame.model.Enemy;
import cz.fit.miadp.mvcgame.model.GameObject;
import cz.fit.miadp.mvcgame.model.Missile;
import cz.fit.miadp.mvcgame.model.ModelInfo;
import cz.fit.miadp.mvcgame.observer.IObserver;
import cz.fit.miadp.mvcgame.strategy.IMovementStrategy;

public interface IGameModel
{
    public int getScore();
    public int getMaxX();
    public int getMaxY();
    public Cannon getCannon();
    public ModelInfo getInfo();
    public ArrayList<Enemy> getEnemies();
    public void moveCannonUp();
    public void moveCannonDown();
    public void cannonShoot();
    
    public void attachObserver(IObserver observer);
    public void deattachObserver(IObserver observer);
    public void notifyMyObservers();
    
    public ArrayList<Missile> getMissiles();
	public void aimCannonUp();
	public void aimCannonDown();
	public void incCannonPower();
	public void decCannonPower();
    public void switchMovementStrategy();
	public ArrayList<GameObject> getGameObjects();
    public IMovementStrategy getActiveMovementStrategy();
    
	public void cannonToggleShootingMode();
	

    public void registerCmd(AbsGameCommand cmd);
    public void undoLastCommand();
    
	public Object createMemento();
	public void setMemento(Object memento);
}