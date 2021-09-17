package game.entities;

import game.Game;

import java.awt.*;

public abstract class Entity {

    protected Game game;
    protected float x, y;       // x, y coordinate
    protected int width, height;
    protected Rectangle bounds;

    public Entity(Game game, float x, float y, int width, int height) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract Rectangle getCollisionBounds();

    public abstract void tick();

    public abstract void render(Graphics g);

    // GETTERS AND SETTERS


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
