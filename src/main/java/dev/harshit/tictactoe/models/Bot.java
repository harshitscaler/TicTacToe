package dev.harshit.tictactoe.models;
public class Bot extends Player {
    private dev.harshit.tictactoe.models.BotDifficultyLevel botDifficultyLevel;
    public  Bot(String name, Symbol symbol, PlayerType playerType , BotDifficultyLevel botDifficultyLevel){
        super(name,symbol,playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

}
