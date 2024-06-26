package dev.harshit.tictactoe.models;

import dev.harshit.tictactoe.exceptions.InvalidMoveException;
import dev.harshit.tictactoe.stratigies.WinningAlgorithm;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> moves;


    private GameState gameState;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimension ,List<Player> players ){
        this.board = new Board(dimension);
        this.players=players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerMoveIndex = 0;
        this.winningAlgorithm = new WinningAlgorithm();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {

        return gameState;
    }

    public void setGameState(GameState gameState) {

        this.gameState = gameState;
    }

    public void printBoard(){
        this.board.printBoard();
    }
    private boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()){
            return false;
        }

        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void makeMove() throws InvalidMoveException {
        // runtime polymorphism
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("It is " + currentPlayer.getName() + " 's move");
        // move that currentplayer make to make the move
        Move move = currentPlayer.makeMove(board);

        if(!validateMove(move)){
            // throw an exception
            throw new InvalidMoveException("Invalid move made by " +currentPlayer.getName() );
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(cellToChange , currentPlayer);
        // game will validate the move.
        moves.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();
        if(winningAlgorithm.checkWinner(board,finalMove)){
            gameState= GameState.ENDED;
            winner=currentPlayer;
        }
    }




}
