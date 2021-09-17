package game;

import game.states.*;
import game.display.Display;
import game.graphics.Assets;
import game.input.KeyManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    private int width, height;  // width and height of game window
    private String title;
    private boolean running = false;
    private Thread thread;

    // State
    private State menuState;
    private State gameState;
    private State gameoverState;

    // Graphics stuff
    private BufferStrategy bs;
    private Graphics g;

    // Input
    private KeyManager keyManager;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);

        Assets.init();

        menuState = new MenuState(this);
        gameState = new GameState(this);
        gameoverState = new GameOverState(this);
        StateManager.setState(menuState);
    }


    // Update everything for a game
    private void tick() {
        keyManager.tick();
        if(StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().tick();
        }
    }


    // Render everything for a game
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        // Clear screen
        g.clearRect(0, 0, width, height);
        // Start drawing
        // drawing background
        g.drawImage(Assets.background, 0, 0, width, height, null);

        // drawing stuff
        if(StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().render(g);
        }

        // End drawing
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
            }

            if(timer >= 1000000000) {
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public synchronized void start() {
        if(running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running) {
            return;
        }

        running = false;
        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    // GETTERS AND SETTERS


    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public KeyManager getKeyManager() {
        return this.keyManager;
    }

    public State getMenuState() {
        return menuState;
    }

    public State getGameState() {
        return gameState;
    }

    public State getGameoverState() {
        return gameoverState;
    }
}
