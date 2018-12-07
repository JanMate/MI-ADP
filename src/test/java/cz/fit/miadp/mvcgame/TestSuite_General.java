package cz.fit.miadp.mvcgame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestSuite_GameModel.class,
        TestSuite_GameObject.class
})
public class TestSuite_General {
}
