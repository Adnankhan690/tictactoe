package models;

import botplaying.BotPlayingStrategy;
import botplaying.EasyBotPlayingStrategy;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder

public class BotPlayer extends Player {
    private DifficultyLevel difficultyLevel;

    @Override
    public void nextMove() {
        //TODO: Have a simple factory here based on difficulty level
        BotPlayingStrategy botPlayingStrategy = new EasyBotPlayingStrategy();
    }

}
