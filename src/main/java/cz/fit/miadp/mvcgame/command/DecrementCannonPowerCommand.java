package cz.fit.miadp.mvcgame.command;

import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class DecrementCannonPowerCommand extends AbsGameCommand {
    public DecrementCannonPowerCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        this.subject.decCannonPower();
    }
}
