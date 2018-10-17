package cz.fit.miadp.mvcgame;

import cz.fit.miadp.mvcgame.model.GameModel;
import cz.fit.miadp.mvcgame.controller.GameController;
import cz.fit.miadp.mvcgame.view.MainWindow;
import javax.swing.SwingUtilities;

public class TheGame {
    
    public static void main(String[] args) {      
        
        // create and wire MC
        GameModel model =  new GameModel();
        final GameController controller = new GameController(model);

        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow(controller).setVisible(true);
            }
        });
    }
}
