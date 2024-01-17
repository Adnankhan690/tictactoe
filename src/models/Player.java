package models;

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

    public abstract void nextMove(Board board);

}
