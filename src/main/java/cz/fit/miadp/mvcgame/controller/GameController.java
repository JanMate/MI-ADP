package cz.fit.miadp.mvcgame.controller;

import java.awt.event.KeyEvent;
import cz.fit.miadp.mvcgame.view.Canvas;
import cz.fit.miadp.mvcgame.model.GameModel;

public class GameController
{
    private GameModel model;
    private Canvas view;

    public GameController(GameModel model)
    {
        this.model = model;
    }

    public void setView(Canvas view)
    {
        this.view = view;
    }

    public GameModel getModel()
    {
        return this.model;
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
            default:
                //nothing
        }

        if(this.view instanceof Canvas)
        {
            this.view.thisIsHowYouForceGuiToRepaint();
        }
    }

}