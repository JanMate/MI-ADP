package cz.fit.miadp.mvcgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import cz.fit.miadp.mvcgame.controller.GameController;
import cz.fit.miadp.mvcgame.model.Enemy;
import cz.fit.miadp.mvcgame.model.GameModel;
import cz.fit.miadp.mvcgame.model.GameObject;
import cz.fit.miadp.mvcgame.model.Missile;
import cz.fit.miadp.mvcgame.observer.IObserver;


public class Canvas extends JPanel implements IObserver { 
    GraphicsDrawer drawer = new GraphicsDrawer();
    GameModel model;

    public Canvas(int x, int y, int width, int height) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }

    public GameController createController()
    {
        GameController ctrl = new GameController();
        //ctrl.setView(this);
        return ctrl;
    }

    public void setModel(GameModel model)
    {
        if(this.model != null && this.model != model)
            this.model.deattachObserver(this);

        this.model = model;
        this.model.attachObserver(this);
    }
    
    public void update() {        
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawer.setGraphics(g);

        if(this.model instanceof GameModel)
        {
            for(GameObject go : this.model.getGameObjects() )
                go.acceptVisitor(drawer);
        }
    }
    
}
