package cz.fit.miadp.mvcgame.model;

import cz.fit.miadp.mvcgame.proxy.IGameModel;
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
public class GameModelTest {
    IGameModel model;

    @Before
    public void initial(){
        model = new GameModel();
    }

    @Test
    public void testStrategy() {
        IMovementStrategy strategy = model.getActiveMovementStrategy();
        IMovementStrategy simple = new SimpleMovementStrategy();
        Assert.assertTrue(strategy.equals(simple));

        IMovementStrategy random = new RandomMovementStrategy();
        model.switchMovementStrategy();
        strategy = model.getActiveMovementStrategy();
        Assert.assertTrue(strategy.equals(random));

        IMovementStrategy gravity = new GravityMovementStrategy();
        model.switchMovementStrategy();
        strategy = model.getActiveMovementStrategy();
        Assert.assertTrue(strategy.equals(gravity));

        model.switchMovementStrategy();
        strategy = model.getActiveMovementStrategy();
        Assert.assertTrue(strategy.equals(simple));
    }

    @Test
    public void testScore(){
        Assert.assertEquals(model.getScore(), 0);
    }

    @Test
    public void testMoveCannonUp(){
        Assert.assertEquals(model.getCannon().getY(), 100);

        model.moveCannonUp();
        Assert.assertEquals(model.getCannon().getY(), 90);

        model.moveCannonUp();
        model.moveCannonUp();
        Assert.assertEquals(model.getCannon().getY(), 70);
    }

    @Test
    public void testMoveCannonDown(){
        Assert.assertEquals(model.getCannon().getY(), 100);

        model.moveCannonDown();
        model.moveCannonDown();
        model.moveCannonDown();
        model.moveCannonDown();
        model.moveCannonDown();
        Assert.assertEquals(model.getCannon().getY(), 150);
    }


}
