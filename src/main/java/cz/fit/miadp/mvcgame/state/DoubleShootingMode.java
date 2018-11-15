package cz.fit.miadp.mvcgame.state;

import cz.fit.miadp.mvcgame.model.Cannon;

public class DoubleShootingMode implements IShootingMode {

    @Override
    public void shoot(Cannon cannon) {
        cannon.aimUp();
        cannon.primitiveShoot();
        cannon.aimDown();
        cannon.aimDown();
        cannon.primitiveShoot();
        cannon.aimUp();
    }

    @Override
    public void nextMode(Cannon cannon) {
		cannon.setSingleShootingMode();
	}

    @Override
    public String getName() {
        return "Double";
    }

}