package dev.harshit.tictactoe.models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;


    private PlayerType playerType;
    private Scanner scanner = new Scanner(System.in);
    public  Player(String name,Symbol symbol, PlayerType playerType){
        this.name = name;
        this.symbol=symbol;
        this.playerType=playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }


    public PlayerType getPlayerType() {

        return playerType;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPlayerType(PlayerType playerType) {

        this.playerType = playerType;
    }
    public Move makeMove(Board board){
        // ask the user where they want to place the symbol.
        System.out.println("Please enter the row number where you want to make a row");
        int row = scanner.nextInt();
        System.out.println("Please enter the col number where you want to make a col");
        int col = scanner.nextInt();
        return new Move(new Cell(row,col),this);

    }
}
