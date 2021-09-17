package game.states;

import game.Game;
import game.graphics.Assets;

import java.awt.*;

public class MenuState extends State {

    public MenuState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        if(getGame().getKeyManager().isSpace()) {
            StateManager.setState(new GameState(getGame()));
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menu, getGame().getWidth() / 4, getGame().getHeight() / 4, getGame().getWidth() / 2, getGame().getHeight() / 2, null);
    }
}
