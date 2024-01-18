package models;

import lombok.Getter;
import strategies.botplaying.BotPlayingStrategy;
import strategies.botplaying.EasyBotPlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter

public class BotPlayer extends Player {
    private DifficultyLevel difficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    @Override
    public Cell nextMove(Board board) {
        //Getting suggestion as to which cell 'BOT' can place a move
        Cell cell = botPlayingStrategy.suggestMove(board);
        //Fill the players detail
        cell.setPlayer(this);
        //Mark the cell as occupied after making a move
        cell.setCellState(CellState.OCCUPIED);

        return cell;
    }
}
