package cz.fit.miadp.mvcgame;

import cz.fit.miadp.mvcgame.model.GameModel;
import cz.fit.miadp.mvcgame.view.MainWindow;
import javax.swing.SwingUtilities;

public class TheGame {
    
    public static void main(String[] args) {      
        
        // create
        final GameModel model =  new GameModel();

        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow(model).setVisible(true);
            }
        });
    }
}
