package cz.fit.miadp.mvcgame;

import cz.fit.miadp.mvcgame.model.GameModel;
import cz.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.fit.miadp.mvcgame.proxy.IGameModel;
import cz.fit.miadp.mvcgame.view.MainWindow;
import javax.swing.SwingUtilities;

public class TheGame {
    
    public static void main(String[] args) {      
        
        // create
        final IGameModel model =  new GameModel();
        final IGameModel proxy = new GameModelProxy(model);

        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow(proxy).setVisible(true);
            }
        });
    }
}
