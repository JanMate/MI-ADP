package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonToggleShootingModeCommand extends AbsGameCommand {
    public CannonToggleShootingModeCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        this.subject.cannonToggleShootingMode();
    }
}
