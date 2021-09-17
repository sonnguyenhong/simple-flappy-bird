package game.states;

import game.Game;

public class StateManager {

    public static State currentState = null;
    private Game game;

    public StateManager(Game game, State state) {
        this.game = game;
        currentState = state;
    }

    public static void setState(State state) {
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }

}
