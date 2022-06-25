package com.TicTacToe.DarthWotan.General;

import com.TicTacToe.DarthWotan.Bot.BotEasy;
import com.TicTacToe.DarthWotan.Bot.BotHard;
import com.TicTacToe.DarthWotan.Bot.BotMedium;
import com.TicTacToe.DarthWotan.Console.AskScanner;
import com.TicTacToe.DarthWotan.Console.OutputConsole;
import com.TicTacToe.DarthWotan.General.Grid.Map;
import com.TicTacToe.DarthWotan.Player.Player;

public class Welcome {
    private String p1Name, p2Name;
    private Player p1, p2;
    private Map grid = new Map();
    private SwitchPlayer gameMaster;
    private OutputConsole outputConsole = new OutputConsole(grid);
    private AskScanner askScanner = new AskScanner();


    public Welcome() {

    }

    public void start(){
        int mode = askScanner.askIfSinglePlayer();
        int difficulty, oldScore;
        getName(mode);

        p1 = new Player(p1Name, "X", Map.State.X, grid);
        if(mode == 2) {
            p2 = new Player(p2Name, "O", Map.State.O, grid);
        }
        else {
            difficulty = askScanner.askForDifficulty();
            p2 = getP2Bot(difficulty);
        }
        while(true){
        gameMaster = new SwitchPlayer(p1, p2);

        outputConsole.welcome(p1Name, p2Name);

            outputConsole.printGrid();
            gameMaster.playGame();
            outputConsole.printScore(p1, p2);
            if(!askScanner.askIfPlayAgain()){
                break;
            }
            grid.resetBoard();
            mode = askScanner.askIfSinglePlayer();
            if (mode == 2) {
                getName(2);
                p1.setName(p1Name);
                oldScore = p2.getScore();
                p2 = new Player(p2Name, "O", Map.State.O, grid);
                p2.setScore(oldScore);
            }
            else {
                oldScore = p2.getScore();
                difficulty = askScanner.askForDifficulty();
                p2 = getP2Bot(difficulty);
                p2.setScore(oldScore);
            }
        }
    }

    private Player getP2Bot(int difficulty){
        switch (difficulty){
            case 1: return new BotEasy(p2Name, "O", Map.State.O, grid);
            case 2: return new BotMedium(p2Name, "O", Map.State.O, grid);
            case 3: return new BotHard(p2Name, "O", Map.State.O, grid);
        }
        return new Player(p2Name, "O", Map.State.O, grid);
    }
    private void getName(int playerNumber){


        p1Name = outputConsole.getPlayerName();
        outputConsole.welcomePlayer(p1Name);

        if(playerNumber == 2) {
            p2Name = outputConsole.getPlayerName();
            outputConsole.welcomePlayer(p2Name);
        }
        else {
            p2Name = "Bot";
        }
    }
}
