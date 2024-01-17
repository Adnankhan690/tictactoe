package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class Board {
    private int size;
    private List<List<Cell>> board;

    Board(int size) {
        this.size = size;
        createBoard();
    }
    public void createBoard() {
        this.board = new ArrayList<>();
        for(int i = 0; i < this.size; i++) {
            board.add(new ArrayList<>());
            for(int j = 0; j < this.size; j++) {
                //It will add j-cells in the ith row
                board.get(i).add((new Cell(i, j)));
            }
        }
    }

    public void display() {
        for(int i = 0; i < this.size; i++) {
            System.out.print("  |\t");
            for(int j = 0; j < this.size; j++) {
                if(board.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    System.out.print("  |\t");
                }
                else {
                    System.out.print(board.get(i).get(j).getPlayer().getSymbol()+ " |\t");
                }
            }
            System.out.println();
        }
    }
}
