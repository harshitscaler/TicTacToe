package dev.harshit.tictactoe.controllers;

import dev.harshit.tictactoe.models.Game;
import dev.harshit.tictactoe.models.Player;


import java.util.List;

public class GameController {
    public Game startGame(int dimension  , List<Player> players){
       // validate if two players have same symbol then throw some exception.
        return  new Game(dimension,players);
    }



}
