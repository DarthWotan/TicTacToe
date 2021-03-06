package com.TicTacToe.DarthWotan.Player;

import com.TicTacToe.DarthWotan.Console.Input;
import com.TicTacToe.DarthWotan.Console.OutputConsole;
import com.TicTacToe.DarthWotan.General.Grid.Map;

public class Player {
    protected String symbol = "X", name;
    protected Map.State state = Map.State.X;
    protected OutputConsole outputConsole;


    protected Map grid;
    protected int score;

    public Player(String name, String symbol , Map.State state, Map grid) {
        this.symbol = symbol;
        this.name = name;
        this.state = state;
        this.grid = grid;
        this.score = 0;
        this.outputConsole = new OutputConsole(grid);

    }

    public int getPlace(){
        Input input = new Input(name);
        return input.getInputConsole();
    }

    public void placeStone() {
        int place;
        while(true) {
            place = getPlace();
            if(grid.checkIfFree(place)){
                break;
            }
            outputConsole.printPlaceError();
        }
        grid.changeMap(place, state);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Map getGrid() {
        return grid;
    }
    public Map.State getState() {
        return state;
    }
}
