package game.states;

import game.Game;
import game.graphics.Assets;

import java.awt.*;

public class GameOverState extends State {

    public GameOverState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        if(getGame().getKeyManager().isSpace()) {
            //getGame().getKeyManager().setSpace(false);
            StateManager.setState(new MenuState(getGame()));
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.gameover, (getGame().getWidth() - Assets.gameover_width) / 2, (getGame().getHeight() - Assets.gameover_height) / 2,
                Assets.gameover_width, Assets.gameover_height, null);
    }
}
