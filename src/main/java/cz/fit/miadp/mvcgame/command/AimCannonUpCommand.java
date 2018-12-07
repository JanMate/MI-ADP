package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class AimCannonUpCommand extends AbsGameCommand {
    public AimCannonUpCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        this.subject.aimCannonUp();
    }

}
