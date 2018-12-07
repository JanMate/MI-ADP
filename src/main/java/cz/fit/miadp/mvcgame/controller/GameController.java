package cz.fit.miadp.mvcgame.controller;

import java.awt.event.KeyEvent;

import cz.fit.miadp.mvcgame.command.*;
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
                this.model.registerCmd( new CannonUpCommand( this.model ));
                break;
            case KeyEvent.VK_DOWN:
                this.model.registerCmd( new CannonDownCommand( this.model ));
                break;
            case KeyEvent.VK_SPACE:
                //this.model.cannonShoot();
                this.model.registerCmd( new CannonShootCommand( this.model ) );
                break;
            case KeyEvent.VK_A:
                this.model.registerCmd( new AimCannonUpCommand( this.model ));
                break;
            case KeyEvent.VK_Z:
                if((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)
                {
                    // CTRL+Z => undo last cmd
                    this.model.registerCmd( new UndoLastCommand( this.model ) );
                }else{
                    this.model.registerCmd( new AimCannonDownCommand( this.model ));
                }
                break;
            case KeyEvent.VK_S:
                this.model.registerCmd( new IncrementCannonPowerCommand( this.model ));
                break;
            case KeyEvent.VK_X:
                this.model.registerCmd( new DecrementCannonPowerCommand( this.model ));
                break;
            case KeyEvent.VK_Q:
                this.model.registerCmd( new SwitchMovementStrategyCommand( this.model ));
                break;
            case KeyEvent.VK_W:
                this.model.registerCmd( new CannonToggleShootingModeCommand( this.model ));
                break;
            default:
                //nothing
        }

        
    }

}