package botplaying;

import models.Board;
import models.Cell;
import models.Move;

public interface BotPlayingStrategy {
    Cell suggestMove(Board board);
}
