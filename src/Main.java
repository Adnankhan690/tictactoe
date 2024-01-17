import controllers.GameController;
import controllers.PlayerController;
import models.DifficultyLevel;
import models.Game;
import models.Player;
import strategies.winning.ColumnWinningStrategy;
import strategies.winning.CornerWinningStrategy;
import strategies.winning.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Tic-Tac-Toe Game!!");


        System.out.println("Let's start playing...");
        System.out.println("How many players would be playing ?");



        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Enter the dimension of the Board");
        int dimension = sc.nextInt();

        List<Player> players = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            System.out.println("Please enter details of the player --> " +(i + 1));
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Symbol: ");
            String symbol = sc.next();
            System.out.print("Is this player a BOT? (Y/N): ");

            if (sc.next().equals("Y")) {
                System.out.println("What's the level of BOT (E/M/H): ");
                String level = sc.next();
                DifficultyLevel difficultyLevel;
                switch(level) {
                    case "E":
                        difficultyLevel = DifficultyLevel.EASY;
                    case "M":
                        difficultyLevel = DifficultyLevel.MEDIUM;
                    default:
                        difficultyLevel = DifficultyLevel.HARD;
                }
                players.add(PlayerController.createBot(name, symbol.charAt(0), difficultyLevel));
            } else {
              players.add(PlayerController.createPlayer(name, symbol.charAt(0)));
            }

        }

        Game game = GameController.initiateGame(dimension,
                players,
                List.of(new RowWinningStrategy(), new ColumnWinningStrategy(),
                       new CornerWinningStrategy()));

        System.out.println("Are you ready to start the Game? (Y/N):");

        if(sc.next().equals("Y")) {
            GameController gc = new GameController(game);
            gc. startGame();
        }

        System.out.println(" -Game Ended-");

    }
}