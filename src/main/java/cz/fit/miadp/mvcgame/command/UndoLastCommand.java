package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class UndoLastCommand extends AbsGameCommand
{
    
    public UndoLastCommand(IGameModel subject)
    {
        super(subject);
    }

    public void execute()
    {
        this.subject.undoLastCommand();
    }
}