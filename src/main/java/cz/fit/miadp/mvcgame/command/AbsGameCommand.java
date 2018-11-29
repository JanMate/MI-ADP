package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public abstract class AbsGameCommand
{
    protected IGameModel subject;
    protected Object memento;
    
    public AbsGameCommand(IGameModel subject)
    {
        this.subject = subject;
    }

    public void extExecute()
    {
        this.memento = this.subject.createMemento();
        this.execute();
    }
    public abstract void execute();

    public void unexecute()
    {
        this.subject.setMemento(this.memento);
    }
}