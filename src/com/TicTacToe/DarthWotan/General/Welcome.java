package com.TicTacToe.DarthWotan.General;

import com.TicTacToe.DarthWotan.Console.OutputConsole;
import com.TicTacToe.DarthWotan.General.Grid.Map;
import com.TicTacToe.DarthWotan.Player.Player;

public class Welcome {
    private String p1Name, p2Name;
    private Player p1, p2;
    private Map grid = new Map();
    private SwitchPlayer gameMaster = new SwitchPlayer(p1, p2);
    private OutputConsole outputConsole = new OutputConsole(grid);


    public Welcome() {

    }
    public void start(){
        getName();
        p1 = new Player(p1Name, "X", Map.State.X, grid);
        p2 = new Player(p2Name, "O", Map.State.O, grid);
        outputConsole.welcome(p1Name, p2Name);
        gameMaster.playGame();
    }

    private void getName(){
        p1Name = outputConsole.getPlayerName();
        p2Name = outputConsole.getPlayerName();
    }
}
