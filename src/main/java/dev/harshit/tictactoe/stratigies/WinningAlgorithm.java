package dev.harshit.tictactoe.stratigies;

import dev.harshit.tictactoe.models.Board;
import dev.harshit.tictactoe.models.Move;

import java.util.HashMap;

public class WinningAlgorithm {
    // hashmap of row number and hashmap of that array
    HashMap<Integer,HashMap<Character , Integer>> rowMaps = new HashMap<>();
    HashMap<Integer,HashMap<Character , Integer>> colMaps = new HashMap<>();
    HashMap<Character,Integer> leftDiagnal = new HashMap<>();
    HashMap<Character,Integer> rightDiagnal = new HashMap<>();


    public boolean checkWinner(Board board , Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Character character = move.getPlayer().getSymbol().getCharacter();
        if(!rowMaps.containsKey(row)){
            rowMaps.put(row,new HashMap<>());
        }
        HashMap<Character , Integer> currRowMap = rowMaps.get(row);
        if(!currRowMap.containsKey(character)){
            currRowMap.put(character,1);
        }
        else {
            currRowMap.put(character,currRowMap.get(character)+1);
        }
        if(currRowMap.get(character) == board.getSize()){
            return true;
        }
        // col
        if(!colMaps.containsKey(col)){
            colMaps.put(col,new HashMap<>());
        }
        HashMap<Character , Integer> currColMaps = colMaps.get(col);
        if(!currColMaps.containsKey(character)){
            currColMaps.put(character,1);
        }
        else {
            currColMaps.put(character,currColMaps.get(character)+1);
        }
        if(currColMaps.get(character) == board.getSize()){
            return true;
        }
        // left fiagnal
        if(row == col){
            if(!leftDiagnal.containsKey(character)){
                leftDiagnal.put(character,1);
            }
            else{
                leftDiagnal.put(character,leftDiagnal.get(character)+1);
            }

            if(leftDiagnal.get(character) == board.getSize()){
                return true;
            }
        }

        if(row+col == board.getSize()-1){
            if(!rightDiagnal.containsKey(character)){
                rightDiagnal.put(character,1);
            }
            else{
                rightDiagnal.put(character,rightDiagnal.get(character)+1);
            }

            if(rightDiagnal.get(character) == board.getSize()){
                return true;
            }
        }
            return false;
    }

}
