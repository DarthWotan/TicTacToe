package com.TicTacToe.DarthWotan.Bot;

import com.TicTacToe.DarthWotan.General.Grid.Map;
import com.TicTacToe.DarthWotan.Player.Player;

public class BotHard extends Player {
    public BotHard(String name, String symbol, Map.State state, Map grid) {
        super(name, symbol, state, grid);
    }
    public void placeStone() {
        int place;
        outputConsole.printBotMessage(name);
        while(true) {
            place = getPlace();
            if(grid.checkIfFree(place)){
                break;
            }
        }
        grid.changeMap(place, state);
    }
}
