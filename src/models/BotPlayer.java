package models;

import strategies.botplaying.BotPlayingStrategy;
import strategies.botplaying.EasyBotPlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder

public class BotPlayer extends Player {
    private DifficultyLevel difficultyLevel;
    BotPlayingStrategy botPlayingStrategy = new EasyBotPlayingStrategy();

    @Override
    public void nextMove(Board board) {
        //TODO: Have a simple factory here based on difficulty level
        //Getting suggestion as to which cell 'BOT' can place a move
        Cell cell = botPlayingStrategy.suggestMove(board);
        //Updating that cell of the "Board's" cell, Hence we need different instance
        //Both above and below instance are different.
        Cell boardCell = board.getBoard().get(cell.getRow()).get(cell.getCol());
        //Fill the players detail
        boardCell.setPlayer(this);
        //Mark the cell as occupied after making a move
        boardCell.setCellState(CellState.OCCUPIED);


    }

}
