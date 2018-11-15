package cz.fit.miadp.mvcgame.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cz.fit.miadp.mvcgame.controller.GameController;
import cz.fit.miadp.mvcgame.proxy.IGameModel;

public class MainWindow extends JFrame {


    public MainWindow(final IGameModel model) {
        try {
            Canvas view = new Canvas(0, 0, model.getMaxX(), model.getMaxY());
            // wire MVC
            final GameController ctrl = view.createController();
            ctrl.setModel(model);
            view.setModel(model);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("MyShooter");
            this.setResizable(false);

            Dimension obrazovka = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                (int) (obrazovka.getWidth() / 2 - (model.getMaxX()/2 )),
                (int) (obrazovka.getHeight() / 2 - (model.getMaxY()/2 ))
            );

            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent evt) {
                    ctrl.onKeyPress(evt);
                }
            });

            this.add(view);
            this.pack();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public void showHelp() {
        JOptionPane.showMessageDialog(this, 
              "Controls: \n"
              + "here goes some description...");
    }
}
