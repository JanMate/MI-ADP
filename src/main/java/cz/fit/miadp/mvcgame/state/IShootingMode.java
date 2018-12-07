package cz.fit.miadp.mvcgame.state;

import cz.fit.miadp.mvcgame.model.Cannon;

public interface IShootingMode
{
    String getName();
    void shoot(Cannon cannon);
    void nextMode(Cannon cannon);
    boolean equals(IShootingMode mode);
}