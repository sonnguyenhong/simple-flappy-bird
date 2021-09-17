package game.utils;

import java.awt.image.BufferedImage;

public class Utils {

    public static BufferedImage flipVertically(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage res = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for(int y = 0 ; y < height ; y++) {
            for(int x = 0 ; x < width ; x++) {
                res.setRGB(x, (height - 1) - y, image.getRGB(x, y));
            }
        }
        return res;
    }

}
