package models;

import exceptions.InvalidCellException;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class Player {
    private String name;
    private int player_id;
    private char symbol;
    private int rank;
    private PlayerType playerType;

    public abstract Cell nextMove(Board board) throws InvalidCellException;
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", symbol=" + symbol +
                ", playerType=" + playerType +
                '}';
    }
}
