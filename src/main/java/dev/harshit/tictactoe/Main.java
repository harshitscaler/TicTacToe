package dev.harshit.tictactoe;

import dev.harshit.tictactoe.controllers.GameController;
import dev.harshit.tictactoe.exceptions.InvalidMoveException;
import dev.harshit.tictactoe.models.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
//        System.out.println("Please enter the game dimension : ");
        int dimension =3;
        List<Player> players = List.of(
                new Player("Harshit", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Scaler" , new Symbol('0'),PlayerType.BOT, BotDifficultyLevel.EASY)

        );
        Game game = gameController.startGame(dimension,players);
//        gameController.printBoard(game);

        while (game.getGameState().equals(GameState.IN_PROGRESS)){
            // print the board
            gameController.printBoard(game);
            // players turn
            gameController.makeMove(game);
        }

        if(!gameController.checkState(game).equals(GameState.ENDED)){
            game.setGameState(GameState.DRAW);
            System.out.println("Game draw");
        }
        else {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }
    }
}