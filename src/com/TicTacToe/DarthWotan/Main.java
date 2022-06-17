package com.TicTacToe.DarthWotan;

import com.TicTacToe.DarthWotan.Bot.BotEasy;
import com.TicTacToe.DarthWotan.Console.AskScanner;
import com.TicTacToe.DarthWotan.Console.OutputConsole;
import com.TicTacToe.DarthWotan.General.CheckWinner;
import com.TicTacToe.DarthWotan.General.Grid.Map;
import com.TicTacToe.DarthWotan.General.SwitchPlayer;
import com.TicTacToe.DarthWotan.General.Welcome;
import com.TicTacToe.DarthWotan.Player.Player;

public class Main {
    public static void main(String[] args) {
        Welcome startGame = new Welcome();
        // startGame.start();
        Map grid = new Map();
        BotEasy bot = new BotEasy("Bot","X", Map.State.X, grid);
        bot.placeStone(bot.getPlace());
        OutputConsole outputConsole  = new OutputConsole(grid);
        outputConsole.printGrid();
    }
}
