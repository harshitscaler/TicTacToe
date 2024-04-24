package dev.harshit.tictactoe.models;

public class Cell {
    int row;
    int col;
    private Player player;

    private CellState state ;
    public  Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.state = CellState.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
