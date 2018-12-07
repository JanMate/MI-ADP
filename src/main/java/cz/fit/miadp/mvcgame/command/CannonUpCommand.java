package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonUpCommand extends AbsGameCommand {
    public CannonUpCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        this.subject.moveCannonUp();
    }
}
