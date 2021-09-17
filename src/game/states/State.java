package game.states;

import game.Game;
import game.entities.Entity;

import java.awt.*;
import java.util.ArrayList;

public abstract class State {

    private Game game;
    protected ArrayList<Entity> entities;

    public State(Game game) {
        this.game = game;
        entities = new ArrayList<Entity>();
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    // GETTERS AND SETTERS
    public Game getGame() {
        return this.game;
    }

    public ArrayList<Entity> getEntities() {
        return this.entities;
    }

}
