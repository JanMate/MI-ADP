package cz.fit.miadp.mvcgame;

import cz.fit.miadp.mvcgame.view.MainWindow;
import javax.swing.SwingUtilities;

public class TheGame {
    
    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow().setVisible(true);
            }
        });
    }
}
