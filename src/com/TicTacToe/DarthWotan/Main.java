package com.TicTacToe.DarthWotan;

import com.TicTacToe.DarthWotan.Console.OutputConsole;
import com.TicTacToe.DarthWotan.General.CheckWinner;
import com.TicTacToe.DarthWotan.General.Grid.Map;
import com.TicTacToe.DarthWotan.General.SwitchPlayer;
import com.TicTacToe.DarthWotan.Player.Player;

public class Main {
    public static void main(String[] args) {
        Map grid = new Map();
        OutputConsole test = new OutputConsole(grid);
        test.printGrid();
        Player p = new Player("Player1", "X", Map.State.X, grid);
        Player p2 = new Player("Player2", "O", Map.State.O, grid);
        CheckWinner checkWinner = new CheckWinner(grid, p);
        SwitchPlayer switchPlayer = new SwitchPlayer(p, p2);
        switchPlayer.playGame();


    }
}
