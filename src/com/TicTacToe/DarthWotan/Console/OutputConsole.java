package com.TicTacToe.DarthWotan.Console;

import com.TicTacToe.DarthWotan.General.Grid.Map;

import java.util.Scanner;

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
        System.out.println(" ");
    }

    public void printPlaceError(){
        System.out.println("Sorry this field is already taken. Try again!");
    }

    public void printTie(){System.out.println("Tie! No winner!");}
    public void welcome(String name1, String name2){
        System.out.println("Welcome " + name1 + " and " + name2 + "!");
        System.out.println("The rules are simple: ");
        System.out.println("You have a 3x3 grid. You can place your token wherever you want as soon as it is empty ('-') ");
        System.out.println("You can place your token whether with 1-9 or with a1-a3, b1-b3 and c1-c3. \n ");
    }
    public String getPlayerName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.next();
        return name;
    }
    public void welcomePlayer(String name){
        System.out.println("Welcome "+name+"!");
    }

    public void printBotMessage(String name){
        System.out.println(name + " is thinking...");
    }

}
