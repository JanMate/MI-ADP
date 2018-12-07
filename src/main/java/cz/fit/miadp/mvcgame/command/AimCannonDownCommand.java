package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class AimCannonDownCommand extends AbsGameCommand {
    public AimCannonDownCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        this.subject.aimCannonDown();
    }

}
