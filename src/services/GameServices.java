package services;

import models.*;
import strategies.winning.WinningStrategy;

public class GameServices  {
    private Game game;

    public GameServices(Game game) {
        this.game = game;
    }

    //All the logic will reside here as to How and when 'nextMoves' will be executed

    //While there is space in the board
    //Print-out which player move it is
    //get the player and call the next move
    //Display the board
    //Iterate over all the winning strategy to check if the player has won
    //Update the next player index
    public void executeNextMoves() {
        while(checkEmptySpace()) {
            Player currentPlayer = game.getPlayers().get(game.getNextPlayerIndex());
            System.out.printf("It's %s move...\n",currentPlayer.getName());
            Cell cell = currentPlayer.nextMove(game.getBoard());
            //To print the board to the user
            game.getBoard().display();

            for(WinningStrategy winningStrategy : game.getWinningStrategies()) {
                if(winningStrategy.checkWin(cell, game.getBoard())) {
                    game.setGameState(GameState.SUCCESS);
                    System.out.printf("Player %s has won!!!", currentPlayer.getName());
                    return;
                }
            }
            game.setNextPlayerIndex((game.getNextPlayerIndex() + 1) % game.getPlayers().size());
        }

        if(!game.getGameState().equals(GameState.SUCCESS)) {
            game.setGameState(GameState.DRAW);
            System.out.println("No more cells to play, hence game is draw");
        }
    }

    public boolean checkEmptySpace() {
        Board board = game.getBoard();

        int n = board.getSize();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Cell currentCell = board.getBoard().get(i).get(j);
                if(currentCell.getCellState().equals(CellState.EMPTY)) {
                    return true;
                }
            }
        }
        return false;
    }

}
