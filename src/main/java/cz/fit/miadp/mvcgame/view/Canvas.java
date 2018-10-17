package cz.fit.miadp.mvcgame.view;

import cz.fit.miadp.mvcgame.model.GameModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Canvas extends JPanel { 
    GraphicsDrawer drawer = new GraphicsDrawer();
    GameModel model;

    public Canvas(int x, int y, int width, int height) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }

    public void setModel(GameModel model)
    {
        this.model = model;
    }
    
    public void thisIsHowYouForceGuiToRepaint() {        
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.model instanceof GameModel)
        {
            drawer.drawCannon(g, this.model.getCannon() );
        }
    }
    
}
