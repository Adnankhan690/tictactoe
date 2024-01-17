package models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@SuperBuilder

public class HumanPlayer extends Player {
    private int age;
    private int rank;

    @Override
    public void nextMove(Board board) {
        // 1. Check if there is empty cell in the board
        // 2. Taking input from user - which ror & col they want to put
        // 3. The cell should be empty
        // 4. Place the symbol on the allocated cell - update the state of the board.

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the row:");
        int row = sc.nextInt();
        System.out.println("Please enter the col:");
        int col = sc.nextInt();

        //TODO: Add a custom exception
        if(!board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            throw new IllegalArgumentException("Cells are not empty");
        }
        Cell cell = board.getBoard().get(row).get(col);
        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);
    }
}
