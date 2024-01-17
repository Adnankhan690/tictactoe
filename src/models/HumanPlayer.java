package models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder

public class HumanPlayer extends Player {
    private int age;
    private int rank;

    @Override
    public void nextMove() {

    }
}
