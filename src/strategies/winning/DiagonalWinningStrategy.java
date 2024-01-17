package strategies.winning;

import models.Board;
import models.Cell;
import models.CellState;
import models.Player;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Cell cell, Board board) {
        Player currentPlayer = cell.getPlayer();
        int row = cell.getRow();;
        int col = cell.getCol();

        int i = 0, j = 0;
        while(i < board.getSize()) {
            Cell currentCell = board.getBoard().get(i).get(j);
            if(!currentCell.getCellState().equals(CellState.EMPTY) ||
                    !currentCell.getPlayer().equals(currentPlayer)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
