package cz.fit.miadp.mvcgame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import cz.fit.miadp.mvcgame.model.GameModelTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    GameModelTest.class
})
public class TestSuite_GameModel {
}
