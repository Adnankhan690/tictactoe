package models;

import strategies.botplaying.BotPlayingStrategy;
import strategies.botplaying.EasyBotPlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder

public class BotPlayer extends Player {
    private DifficultyLevel difficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    @Override
    public Cell nextMove(Board board) {
        //TODO: Have a simple factory here based on difficulty level
        botPlayingStrategy = new EasyBotPlayingStrategy();
        //Getting suggestion as to which cell 'BOT' can place a move
        Cell cell = botPlayingStrategy.suggestMove(board);
        //Fill the players detail
        cell.setPlayer(this);
        //Mark the cell as occupied after making a move
        cell.setCellState(CellState.OCCUPIED);

        return cell;
    }

}
