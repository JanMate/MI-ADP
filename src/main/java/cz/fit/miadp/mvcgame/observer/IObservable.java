package cz.fit.miadp.mvcgame.observer;

public interface IObservable
{
    void attachObserver(IObserver observer);
    void deattachObserver(IObserver observer);
    void notifyMyObservers();
}