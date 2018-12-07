package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonDownCommand extends AbsGameCommand {
    public CannonDownCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        this.subject.moveCannonDown();
    }

}
