package com.TicTacToe.DarthWotan.Console;

import com.TicTacToe.DarthWotan.General.Grid.Map;

public class OutputConsole {
    private Map grid;

    public OutputConsole(Map grid) {
        this.grid = grid;
    }

    public void printWinner(String winner){
        System.out.println("Congratulations " + winner + "! You won");
    }

    public void printGrid(){
        int s = 1, e = 3;
        for(int x =0; x<3; x++){
            System.out.print("| ");
            for (int i = s; i <= e; i++) {
                System.out.print(grid.getMap().get(grid.getState(i)) + " | ");
            }
            System.out.println();
            s += 3; e += 3;
        }
    }
}
