package strategies.winning;

import models.Board;
import models.Cell;
import models.CellState;
import models.Player;

public class ColumnWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWin(Cell cell, Board board) {
        Player currentPlayer = cell.getPlayer();

        int col = cell.getCol();

        for(int j = 0; j < board.getSize(); j++) {
            Cell currentCell = board.getBoard().get(j).get(col);
            if(currentCell.getCellState().equals(CellState.EMPTY) ||
                    !currentCell.getPlayer().equals(currentPlayer)) {
                return false;
            }
        }
        return true;
    }
}
