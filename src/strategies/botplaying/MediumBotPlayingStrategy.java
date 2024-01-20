package strategies.botplaying;

import models.Board;
import models.Cell;
import models.CellState;
import models.Player;

import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell suggestMove(Board board) {
        Random random = new Random();
        int randomI, randomJ;
        do {
            randomI = random.nextInt(board.getSize());
            randomJ = random.nextInt(board.getSize());
        } while (!board.getBoard().get(randomI).get(randomJ).getCellState().equals(CellState.EMPTY));

        return board.getBoard().get(randomI).get(randomJ);
    }
}
