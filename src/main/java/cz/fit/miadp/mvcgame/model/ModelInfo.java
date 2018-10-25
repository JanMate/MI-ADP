package cz.fit.miadp.mvcgame.model;

public class ModelInfo extends GameObject {

    private GameModel model;

    public ModelInfo(GameModel model)
    {
        this.model = model;
    }

    public String getText()
    {
        return "Score: " + this.model.getScore();
    }
}
