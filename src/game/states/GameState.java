package game.states;

import game.Game;
import game.entities.creatures.Bird;
import game.entities.creatures.Creature;
import game.entities.statics.Pipe;
import game.entities.statics.StaticEntity;
import game.graphics.Assets;
import game.graphics.Text;

import java.awt.*;

public class GameState extends State {

    private StaticEntity[] pipes;
    private Creature bird;

    //private int random_offset; // use to move pipe randomly

    public GameState(Game game) {
        super(game);

        this.pipes = new StaticEntity[2];

        pipes[0] = new Pipe(game, game.getWidth(), game.getHeight() - Assets.pipe_height + 130,
                Assets.pipe_width, Assets.pipe_height, true, 0);

        pipes[1] = new Pipe(game, game.getWidth() + 170, game.getHeight() - Assets.pipe_height + 100,
                Assets.pipe_width, Assets.pipe_height, true, 1);

        this.bird = new Bird(game, (game.getWidth() - Assets.bird_width) / 2, (game.getHeight() - Assets.bird_height) / 2,
                Assets.bird_width, Assets.bird_height);

        entities.add(pipes[0]);
        entities.add(pipes[1]);
        entities.add(bird);
    }

    @Override
    public void tick() {
        for(StaticEntity p : pipes) {
            p.tick();
        }
        this.bird.tick();
        if(!this.bird.isAlive()) {
            StateManager.setState(getGame().getGameoverState());
        }
    }

    @Override
    public void render(Graphics g) {
        for(StaticEntity p : pipes) {
            p.render(g);
        }
        Text.drawString(g, Integer.toString(this.bird.getScore()), getGame().getWidth() / 2, 50, true, Color.WHITE, Assets.font80);
        this.bird.render(g);
    }

    // GETTERS

    public StaticEntity[] getPipes() {
        return pipes;
    }

    public Creature getBird() {
        return bird;
    }
}
