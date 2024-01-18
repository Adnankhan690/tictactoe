package models;

import exceptions.InvalidCellException;
import lombok.experimental.SuperBuilder;
import java.util.Scanner;

@SuperBuilder
public class HumanPlayer extends Player {
    private int age;
    private int rank;

    @Override
    public Cell nextMove(Board board) throws InvalidCellException {
        // 1. Check if there is empty cell in the board
        // 2. Taking input from user - which ror & col they want to put
        // 3. The cell should be empty
        // 4. Place the symbol on the allocated cell - update the state of the board.

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the row:");
        int row = sc.nextInt();
        row--; //To make the row and col start from 1(User count rows-col from 1)
        System.out.println("Please enter the col:");
        int col = sc.nextInt();
        col--; //To make the row and col start from 1(User count rows-col from 1)
        
        //Throwing the exception if user enters wrong/occupied cell
        if( (row < 0 || row >= board.getSize() )
            && ( col < 0 || col >= board.getSize() )
              ||  !board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            throw new InvalidCellException();
        }
        Cell cell = board.getBoard().get(row).get(col);
        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);

        return cell;
    }
}
