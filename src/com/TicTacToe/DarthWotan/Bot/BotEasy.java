package com.TicTacToe.DarthWotan.Bot;

import com.TicTacToe.DarthWotan.General.Grid.Map;
import com.TicTacToe.DarthWotan.Player.Player;

import java.util.Random;

public class BotEasy extends Player {

    public BotEasy(String name, String symbol, Map.State state, Map grid) {
        super(name, symbol, state, grid);
    }

    @Override
    public int getPlace() {
        int place;
        Random random = new Random();
        while (true) {
            place = random.nextInt(8) + 1;
            if(getGrid().checkIfFree(place)){
                return place;
            }
        }
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
