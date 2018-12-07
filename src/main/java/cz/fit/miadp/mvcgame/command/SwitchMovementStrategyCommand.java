package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class SwitchMovementStrategyCommand extends AbsGameCommand {
    public SwitchMovementStrategyCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        this.subject.switchMovementStrategy();
    }
}
