package cz.fit.miadp.mvcgame.view;

import cz.fit.miadp.mvcgame.model.*;
import cz.fit.miadp.mvcgame.visitor.IVisitor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GraphicsDrawer implements IVisitor {
    private static final int INFO_X = 5;
    private static final int INFO_Y = 15;
    
    private Graphics g;

    private BufferedImage cannonImage;
    private BufferedImage enemyImage1;
    private BufferedImage enemyImage2;
    private BufferedImage missileImage;
    private BufferedImage collisionImage;
 

    public GraphicsDrawer() {
        try {
            cannonImage = ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
            enemyImage1 = ImageIO.read(getClass().getResourceAsStream("/images/enemy1.png"));
            enemyImage2 = ImageIO.read(getClass().getResourceAsStream("/images/enemy2.png"));
            missileImage = ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
            collisionImage = ImageIO.read(getClass().getResourceAsStream("/images/collision.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public void setGraphics(Graphics g)
    {
        this.g = g;
    }

    public void visitCannon(Cannon cannon) {
        if(g == null) return;
        drawCannon(g, cannon);
    }
    public void visitEnemy(Enemy enemy) {
        if(g == null) return;
        drawEnemy(g, enemy);
    }
    public void visitMissile(Missile missile) {
        if(g == null) return;
        drawMissile(g, missile);
    }
    public void visitInfo(ModelInfo info) {
        if(g == null) return;
        drawInfo(g, info);
    }
    public void visitCollision(Collision collision) {
        if(g == null) return;
        drawCollision(g, collision);
    }
    
    public void drawCannon(Graphics g, Cannon cannon) {
        g.drawImage(cannonImage, 
              cannon.getX() - cannonImage.getWidth()/2, 
              cannon.getY() - cannonImage.getHeight()/2, null);
    }
    
    public void drawMissile(Graphics g, Missile missile) {
        g.drawImage(missileImage, 
              missile.getX() - missileImage.getWidth()/2, 
              missile.getY() - missileImage.getHeight()/2, null);
    }
    
    public void drawEnemy(Graphics g, Enemy enemy) {
        g.drawImage(enemyImage1, 
              enemy.getX() - enemyImage1.getWidth()/2, 
              enemy.getY() - enemyImage1.getHeight()/2, null);
    }
    
    public void drawCollision(Graphics g, Collision collision) {        
        g.drawImage(collisionImage, 
              collision.getX() - collisionImage.getWidth()/2, 
              collision.getY() - collisionImage.getHeight()/2, null);
    }
    
    public void drawInfo(Graphics g, ModelInfo info) {
        g.drawString(info.getText(), info.getX(), info.getY());
    }
    
    


}
