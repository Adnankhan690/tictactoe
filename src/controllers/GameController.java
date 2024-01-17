package controllers;

import models.Game;
import models.GameState;
import models.Player;
import strategies.winning.WinningStrategy;

import java.util.List;

public class GameController {
    Game game;
    public GameController(Game game) {
        this.game = game;
    }
    public static Game initiateGame(int dimension, List<Player> players,
                                    List<WinningStrategy> winningStrategies) {
        return new Game(dimension, players, winningStrategies);
    }
    public void startGame() {
    game.setGameState(GameState.INIT);
    //While there is space in the board
        //Print-out which player move it is
        //get the player and call the next move
        //Display the board
        //Iterate over all the winning strategy to check if the player has won
        //Update the next player index
    }
}
