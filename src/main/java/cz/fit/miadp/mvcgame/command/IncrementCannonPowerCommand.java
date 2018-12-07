package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class IncrementCannonPowerCommand extends AbsGameCommand {
    public IncrementCannonPowerCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        this.subject.incCannonPower();
    }
}
