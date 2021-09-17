package game.graphics;

import game.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static Font font80;

    public static final int bird_width = 34, bird_height = 24;
    public static final int pipe_width = 52, pipe_height = 320;
    public static final int bg_width = 288, bg_height = 512;
    public static final int base_width = 288, base_height = 112;
    public static final int gameover_width = 192, gameover_height = 42;

    public static BufferedImage[] bird;
    public static BufferedImage pipe, flipped_pipe;
    public static BufferedImage background;
    public static BufferedImage menu;
    public static BufferedImage gameover;

    public static void init() {

        font80 = FontLoader.loadFont("resources/fonts/flappy-font.TTF", 80);

        bird = new BufferedImage[3];
        bird[0] = ImageLoader.loadImage("/sprites/yellowbird-downflap.png");
        bird[1] = ImageLoader.loadImage("/sprites/yellowbird-midflap.png");
        bird[2] = ImageLoader.loadImage("/sprites/yellowbird-upflap.png");

        pipe = ImageLoader.loadImage("/sprites/pipe-green.png");
        flipped_pipe = Utils.flipVertically(pipe);

        background = ImageLoader.loadImage("/sprites/background-day.png");
        menu = ImageLoader.loadImage("/sprites/message.png");
        gameover = ImageLoader.loadImage("/sprites/gameover.png");
    }

}
