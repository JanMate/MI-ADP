package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonShootCommand extends AbsGameCommand
{
    
    public CannonShootCommand(IGameModel subject)
    {
        super(subject);
    }

    public void execute()
    {
        this.subject.cannonShoot();
    }
}