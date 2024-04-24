package dev.harshit.tictactoe.controllers;

import dev.harshit.tictactoe.exceptions.InvalidMoveException;
import dev.harshit.tictactoe.models.Game;
import dev.harshit.tictactoe.models.GameState;
import dev.harshit.tictactoe.models.Player;


import java.util.List;

public class GameController {
    public Game startGame(int dimension  , List<Player> players){
       // validate if two players have same symbol then throw some exception.
        // TODO

        return  new Game(dimension,players);
    }

    public  void makeMove(Game game) throws InvalidMoveException {
       game.makeMove();
    }
    public GameState checkState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
    public  void printBoard(Game game){
        game.printBoard();
    }



}
