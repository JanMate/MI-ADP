package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.fit.miadp.mvcgame.proxy.IGameModel;
import cz.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.fit.miadp.mvcgame.strategy.GravityMovementStrategy;
import cz.fit.miadp.mvcgame.strategy.IMovementStrategy;
import cz.fit.miadp.mvcgame.strategy.RandomMovementStrategy;
import cz.fit.miadp.mvcgame.strategy.SimpleMovementStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GameObjectTest {

    IGameModel model;
    IGameModel modelProxy;
    Cannon cannon;

    @Before
    public void initial(){
        model = new GameModel();
        modelProxy = new GameModelProxy( model );
        cannon = model.getCannon();
    }

    @Test
    public void testCannonPosition(){
        Assert.assertEquals(cannon.getX(), 50);
        Assert.assertEquals(cannon.getY(), 100);

        cannon.setX(cannon.getX() + 50);
        Assert.assertEquals(cannon.getX(), 100);

        cannon.setY(cannon.getY() + 100);
        Assert.assertEquals(cannon.getY(), 200);
    }

    @Test
    public void testCannonAngle(){
        Assert.assertTrue(cannon.getAngle() == 0.0f);

        cannon.aimDown();
        Assert.assertTrue(cannon.getAngle() == 0.1f);

        cannon.aimUp();
        cannon.aimUp();
        Assert.assertTrue(cannon.getAngle() == -0.1f);
    }

    @Test
    public void testCannonPower(){
        Assert.assertTrue(cannon.getPower() == 10.0f);

        cannon.incPower();
        cannon.incPower();
        Assert.assertTrue(cannon.getPower() == 12.0f);

        cannon.decPower();
        Assert.assertTrue(cannon.getPower() == 11.0f);
    }

    @Test
    public void testCannonShootingMode(){
        Assert.assertTrue(cannon.getShootingMode().equals(new SingleShootingMode()));

        cannon.toggleShootingMode();
        Assert.assertTrue(cannon.getShootingMode().equals(new DoubleShootingMode()));

        cannon.toggleShootingMode();
        Assert.assertTrue(cannon.getShootingMode().equals(new SingleShootingMode()));
    }
}
