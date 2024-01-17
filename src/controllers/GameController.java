package controllers;

import models.Game;
import models.GameState;
import models.Player;
import services.GameServices;
import strategies.winning.WinningStrategy;

import java.util.List;

public class GameController {
    Game game;
    GameServices gameServices;
    public GameController(Game game) {
        this.game = game;
        this.gameServices = new GameServices(game);
    }
    public static Game initiateGame(int dimension, List<Player> players,
                                    List<WinningStrategy> winningStrategies) {
        return new Game(dimension, players, winningStrategies);
    }
    public void startGame() {
        game.setGameState(GameState.INIT);
        gameServices.executeNextMoves();
    }
}
