package cz.fit.miadp.mvcgame.controller;

import java.awt.event.KeyEvent;
import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class GameController
{
    private IGameModel model;
    
    public void setModel(IGameModel model)
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
            case KeyEvent.VK_Q:
                this.model.switchMovementStrategy();
                break;
            case KeyEvent.VK_W:
                this.model.cannonToggleShootingMode();
                break;
            default:
                //nothing
        }

        
    }

}