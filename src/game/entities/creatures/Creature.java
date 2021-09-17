package game.entities.creatures;

import game.Game;
import game.entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity {

    protected boolean isAlive;
    protected int score;

    public Creature(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        this.isAlive = true;
        this.score = 0;
    }

    // GETTERS AND SETTERS
    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getScore() {
        return this.score;
    }

}
