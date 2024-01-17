package models;

import lombok.*;
import strategies.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Game {
    public Board board;
    private List<Player> players;
    //To support Un-Do Feature, We can use Stack too, List is an abstract type of stack
    private List<Move> moves;
    //Which player to play next ?
    private int nextPlayerIndex;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;
    private Player winner;

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.gameState = GameState.INIT;

    }
}
