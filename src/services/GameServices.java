package services;

import exceptions.InvalidCellException;
import models.*;
import strategies.winning.WinningStrategy;
import java.util.List;
import java.util.Scanner;

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
            System.out.printf("It's [%s] move...\n",currentPlayer.getName());
            Cell cell = null;
            //Handling the exception thrown by the Human-Player
            try {
                cell = currentPlayer.nextMove(game.getBoard());
            } catch (InvalidCellException e) {//TODO put delay after Incorrect cell
                System.out.println("        xxx Incorrect cell xxx \n" +
                        "Please re-check the cell you have entered!");
                continue;
            }
            //Adding the move in the lis-of-moves
            game.getMoves().add(new Move(currentPlayer, cell));
            //To print the board to the user
            game.getBoard().display();

            //Checking if the player has won ?
            for(WinningStrategy winningStrategy : game.getWinningStrategies()) {
                if(winningStrategy.checkWin(cell, game.getBoard())) {
                    game.setGameState(GameState.SUCCESS);
                    System.out.printf("         Player %s has won!!!", currentPlayer.getName());
                    return;
                }
            }
            //Making sure Bot does not have Undo-Feature
            if(currentPlayer.getPlayerType().equals(PlayerType.HUMAN)) {
                aksIfPlayerWantsToUndo();
            }
            game.setNextPlayerIndex((game.getNextPlayerIndex() + 1) % game.getPlayers().size());
        }
        //Checking if the Game is Draw ?
        if(!game.getGameState().equals(GameState.SUCCESS)) {
            game.setGameState(GameState.DRAW);
            System.out.println("No more cells to play, hence game is draw");
        }
    }
    public void aksIfPlayerWantsToUndo() {
        System.out.println("Would you like to undo the last move ? (Y/N): ");
        Scanner sc = new Scanner(System.in);
        String response = sc.next();
        if(response.equals("Y")) {
            undoLastMove();
            game.board.display(); //Also displaying the board after Undo-feature is applied
        }
    }

    public void undoLastMove() {
        //TODO PUT WAIT FUNCTION FOR THIS TO REMOVE LAST MOVE
        System.out.println("Please wait removing the last move.....");
        List<Move> move = game.getMoves();
        //We will also update the cell
        Cell cell = move.get(move.size() - 1).getCell();
        //Printing the last removed move
        System.out.println(move.get(move.size() - 1));

        move.remove(move.get(move.size() - 1));
        //Updating that cell as EMPTY again
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);
        //Update the player index also by -1
        game.setNextPlayerIndex(game.getNextPlayerIndex() - 1);
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
