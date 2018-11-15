package cz.fit.miadp.mvcgame.state;

import cz.fit.miadp.mvcgame.model.Cannon;

public class SingleShootingMode implements IShootingMode {

    @Override
    public void shoot(Cannon cannon) {
        cannon.primitiveShoot();
    }

    @Override
    public void nextMode(Cannon cannon) {
		cannon.setDoubleShootingMode();
	}

    @Override
    public String getName() {
        return "Single";
    }

}