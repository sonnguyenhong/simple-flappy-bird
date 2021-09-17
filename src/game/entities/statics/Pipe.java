package game.entities.statics;

import game.Game;
import game.entities.creatures.Bird;
import game.graphics.Assets;

import java.awt.*;

public class Pipe extends StaticEntity {

    private final float DEFAULT_SPEED = 1.0f;
    private final int MAX_OFFSET = 450,
                    MIN_OFFSET = 192;
    private float speed;
    private boolean isGround; // check if pipe is on the ground or above
    private int id;
    private Rectangle bounds1;  // Set collision bounds for below pipe
    private Rectangle bounds2;  // Set collision bounds for above pipe
    private boolean isPassed = false;

    public Pipe(Game game, float x, float y, int width, int height, boolean isGround, int id) {
        super(game, x, y, width, height);
        this.speed = DEFAULT_SPEED;
        this.isGround = isGround;
        this.id = id;

        bounds1 = new Rectangle((int) x, (int) y, width, height);
        bounds2 = new Rectangle((int) x, (int) y - 450, width, height);
    }

    public Rectangle getCollisionBounds1() {
        return this.bounds1;
    }

    public Rectangle getCollisionBounds2() {
        return this.bounds2;
    }

    public boolean checkPassed(Bird bird) {
        if(!isPassed() && bird.getX() + bird.getWidth() >= this.getX() + this.getWidth()) {
            return true;
        }
        return false;
    }

    @Override
    public Rectangle getCollisionBounds() {
        return null;
    }

    @Override
    public void tick() {
        if(!game.isRunning()) {
            return;
        }
        // Cho x lui dan ve ben trai
        x -= speed;
        bounds1.x = (int) x;
        bounds2.x = (int) x;

        if(x <= - Assets.pipe_width) { // Neu x di qua man hinh
            x = game.getWidth(); // Cho x bat dau lai tu ben phai
            //int rand = (int) Math.floor(Math.random()*(MAX_OFFSET-MIN_OFFSET+1)+MIN_OFFSET);
            y = (int) Math.floor(Math.random()*(MAX_OFFSET-MIN_OFFSET+1)+MIN_OFFSET);;
            bounds1.y = (int) y;
            bounds2.y = (int) y - 450;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.pipe, (int) x, (int) y, null);
        g.drawImage(Assets.flipped_pipe, (int) x, (int) y - 450,
                width, height, null);

//        g.setColor(Color.RED);
//        g.fillRect(bounds1.x, bounds1.y, bounds1.width, bounds1.height);
//        g.fillRect(bounds2.x, bounds2.y, bounds2.width, bounds2.height);
    }

    // GETTERS AND SETTERS

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isGround() {
        return isGround;
    }

    public void setGround(boolean ground) {
        isGround = ground;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }
}
