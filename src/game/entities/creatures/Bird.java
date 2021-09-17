package game.entities.creatures;

import game.Game;
import game.states.StateManager;
import game.entities.Entity;
import game.entities.statics.Pipe;
import game.graphics.Assets;

import java.awt.*;

public class Bird extends Creature {

    private boolean isAlive = true;
    private int heightChange = 4;
    private final float gravity = 2f;
    private float time = 0f;

    public Bird(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        bounds.x = (int) x;
        bounds.y = (int) y;
        bounds.width = width;
        bounds.height = height;
    }

    private boolean checkCollision() {   // return true => collision happened
        for(Entity e : StateManager.getCurrentState().getEntities()) {
            if(e.equals(this)) {
                continue;
            }
            Pipe p;
            if(e instanceof Pipe) {
                p = (Pipe) e;
                if (this.bounds.intersects(p.getCollisionBounds1()) || this.bounds.intersects(p.getCollisionBounds2())) {
                    return true;
                }
            }
        }
        if(this.y + this.height >= game.getHeight() || this.y <= 0) {
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return !checkCollision();
    }

    @Override
    public Rectangle getCollisionBounds() {
        return this.bounds;
    }

    @Override
    public void tick() {
        if(game.getKeyManager().isSpace()) {
            time = 0;
            y -= heightChange;
        } else {
            time = time + 0.1f;
            y = y + (gravity * time * time) / 2;
        }
        bounds.y = (int) y;
        isAlive = checkCollision();
        for(Entity e : StateManager.getCurrentState().getEntities()) {
            if(e.equals(this)) {
                return;
            }
            Pipe p;
            if(e instanceof Pipe) {
                p = (Pipe) e;
                if(p.checkPassed(this)) {
                    score++;
                    p.setPassed(true);
                    System.out.println(score);
                }
                if(p.getX() >= game.getWidth()) {
                    p.setPassed(false);
                    System.out.println("false");
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bird[0], (int) x, (int) y, null);
//        g.setColor(Color.RED);
//        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    // GETTERS
    public int getScore() {
        return score;
    }
}
