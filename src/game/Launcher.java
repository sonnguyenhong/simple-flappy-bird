package game;

public class Launcher {

    // Start game
    public static void main(String[] args) {
        Game game = new Game("Flappy Bird", 288, 512);
        game.start();
    }
}
