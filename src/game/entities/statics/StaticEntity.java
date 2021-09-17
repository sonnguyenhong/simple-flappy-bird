package game.entities.statics;

import game.Game;
import game.entities.Entity;

import java.awt.*;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
    }

}
