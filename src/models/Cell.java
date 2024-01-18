package models;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + (row + 1) + // To show to the user the correct row,col according to him
                ", col=" + (col + 1) +
                ", cellState=" + cellState +
                '}';
    }
}
