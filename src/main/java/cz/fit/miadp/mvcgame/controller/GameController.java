package cz.fit.miadp.mvcgame.controller;

import java.awt.event.KeyEvent;
import cz.fit.miadp.mvcgame.model.GameModel;

public class GameController
{
    private GameModel model;
    
    public void setModel(GameModel model)
    {
        this.model = model;
    }

    public void onKeyPress(KeyEvent evt)
    {
        switch(evt.getKeyCode())
        {
            case KeyEvent.VK_UP:
                this.model.moveCannonUp();
                break;
            case KeyEvent.VK_DOWN:
                this.model.moveCannonDown();
                break;
            case KeyEvent.VK_SPACE:
                this.model.cannonShoot();
                break;
            case KeyEvent.VK_A:
                this.model.aimCannonUp();
                break;
            case KeyEvent.VK_Z:
                this.model.aimCannonDown();
                break;
            case KeyEvent.VK_S:
                this.model.incCannonPower();
                break;
            case KeyEvent.VK_X:
                this.model.decCannonPower();
                break;

            default:
                //nothing
        }

        
    }

}