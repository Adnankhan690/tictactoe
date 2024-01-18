package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Move {
    private Player player;
    private Cell cell;

    @Override
    public String toString() {
        return "Old Move[ " +  player +
                ", " + cell +
                " ]";
    }
}
