package com.TicTacToe.DarthWotan.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AskScanner {
    private String currentName;

    public AskScanner(String currentName) {
        this.currentName = currentName;
    }

    public int askForPlace(){
        Scanner scanner = new Scanner(System.in);
        int i;
        String s;
        int out = 0;
        System.out.println(currentName + " where do you want to place your tile?");
        while (true) {
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                if(checkIfCorrectInputInt(i)){
                    out = i; break;
                }
                else{
                    System.out.println("Invalid answer. Try again!");
                }
            }
            else if (scanner.hasNext()) {
                s = scanner.next();
                if (checkIfCorrectInputString(s)) {
                    out = decodeStringToInt(s);
                    break;
                }
                else{
                    System.out.println("Invalid answer. Try again!");
                }
            }

        }
        return out;
    }

    private boolean checkIfCorrectInputInt(int input){

        if(input <=9 && input >= 1){
            return true;
        }
        else {
            return false;
        }
    }

    private int decodeStringToInt(String input){
        switch (input){
            case "a1" -> {
                return 1;
            }
            case "a2" -> {
                return 2;
            }
            case "a3" -> {
                return 3;
            }
            case "b1" -> {
                return 4;
            }
            case "b2" -> {
                return 5;
            }
            case "b3" -> {
                return 6;
            }
            case "c1" -> {
                return 7;
            }
            case "c2" -> {
                return 8;
            }
            case "c3" -> {
                return 9;
            }
            default -> {
                return 0;
            }
        }
    }
    private boolean checkIfCorrectInputString(String input) {
            if(input.equals("a1") || input.equals("a2") || input.equals("a3") || input.equals("b1") || input.equals("b2") || input.equals("b3") || input.equals("c1") || input.equals("c2") || input.equals("c3") ) {
                return true;
            }
            else{
                return false;
            }

    }

    private String checkIfString(Scanner scanner){
        while(true){
            if(scanner.hasNext()){
                return scanner.next();
            }
        }

    }

    public String getPlayerName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = checkIfString(scanner);
        return name;
    }
}

