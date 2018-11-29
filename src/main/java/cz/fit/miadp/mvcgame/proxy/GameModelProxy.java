package cz.fit.miadp.mvcgame.proxy;

import java.util.ArrayList;

import cz.fit.miadp.mvcgame.command.AbsGameCommand;
import cz.fit.miadp.mvcgame.model.Cannon;
import cz.fit.miadp.mvcgame.model.Enemy;
import cz.fit.miadp.mvcgame.model.GameObject;
import cz.fit.miadp.mvcgame.model.Missile;
import cz.fit.miadp.mvcgame.model.ModelInfo;
import cz.fit.miadp.mvcgame.observer.IObserver;
import cz.fit.miadp.mvcgame.strategy.IMovementStrategy;

public class GameModelProxy implements IGameModel
{
    private IGameModel subject;

    public GameModelProxy(IGameModel subject)
    {
        this.subject = subject;
    }


    @Override
    public int getScore() {
        return this.subject.getScore();
    }

    @Override
    public int getMaxX() {
        return this.subject.getMaxX();
    }

    @Override
    public int getMaxY() {
        return this.subject.getMaxY();
    }

    @Override
    public Cannon getCannon() {
        return this.subject.getCannon();
    }

    @Override
    public ModelInfo getInfo() {
        return this.subject.getInfo();
    }

    @Override
    public ArrayList<Enemy> getEnemies() {
        return this.subject.getEnemies();
    }

    @Override
    public void moveCannonUp() {
        
        this.subject.moveCannonUp();
    }

    @Override
    public void moveCannonDown() {
        this.subject.moveCannonDown();
    }

    @Override
    public void cannonShoot() {
        this.subject.cannonShoot();
    }

    @Override
    public void attachObserver(IObserver observer) {
        this.subject.attachObserver(observer);
    }

    @Override
    public void deattachObserver(IObserver observer) {
        this.subject.deattachObserver(observer);
    }

    @Override
    public void notifyMyObservers() {
        this.subject.notifyMyObservers();
    }

    @Override
    public ArrayList<Missile> getMissiles() {
        return this.subject.getMissiles();
    }

    @Override
    public void aimCannonUp() {
        this.subject.aimCannonUp();
    }

    @Override
    public void aimCannonDown() {
        this.subject.aimCannonDown();
    }

    @Override
    public void incCannonPower() {
        this.subject.incCannonPower();
    }

    @Override
    public void decCannonPower() {
        this.subject.decCannonPower();
    }

    @Override
    public void switchMovementStrategy() {
        this.subject.switchMovementStrategy();
    }

    @Override
    public ArrayList<GameObject> getGameObjects() {
        return this.subject.getGameObjects();
    }

    @Override
    public IMovementStrategy getActiveMovementStrategy() {
        return this.subject.getActiveMovementStrategy();
    }

    @Override
    public void cannonToggleShootingMode() {
        this.subject.cannonToggleShootingMode();
    }
    
    @Override
    public void registerCmd(AbsGameCommand cmd)
    {
        this.subject.registerCmd(cmd);
    }

    @Override
    public void undoLastCommand()
    {
        this.subject.undoLastCommand();
    }

    @Override
    public Object createMemento()
    {
        return this.subject.createMemento();
    }

    @Override
    public void setMemento(Object memento)
    {
        this.subject.setMemento(memento);
    }
}
