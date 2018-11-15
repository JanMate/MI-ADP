package cz.fit.miadp.mvcgame.model;

public abstract class LifetimeAwareGameObject extends GameObject
{
    private long created = System.currentTimeMillis();

    public long getLifetime()
    {
        return System.currentTimeMillis() - created;
    }
}