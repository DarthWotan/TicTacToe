package com.TicTacToe.DarthWotan.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AskScanner {
    private String currentName;

    public AskScanner(String currentName) {
        this.currentName = currentName;
    }

    public AskScanner() {
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
                if(checkIfCorrectInputInt(i, 1, 9)){
                    out = i; break;
                }
                else{
                    System.out.println("Invalid answer. Try again!");
                }
            }
            else if (scanner.hasNext()) {
                s = scanner.next();
                if (checkIfCorrectInputString(s, Arrays.asList(new String[]{"a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"}))) {
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

    public boolean askIfPlayAgain(){
        String s;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nDo you want to play again? (y/n)");
            s = scanner.next();
            if (checkIfCorrectInputString(s, Arrays.asList(new String[]{"y", "n"}))) {
                if(s.equals("y")){
                    return true;
                }
                return false;
            }
        }
    }

    public int askIfSinglePlayer(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Singleplayer(1)        Multiplayer(2)");
            if(checkIfInt(scanner)){
                int i = scanner.nextInt();
                switch (i){
                    case 1 -> {
                        return 1;
                    }
                    case 2 -> {
                        return 2;
                    }
                    default -> {
                        break;
                    }
                }
            }
            scanner.next();
            System.out.println("Invalid answer, try again!");
        }
    }

    public int askForDifficulty(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Choose a difficulty \nEasy(1)    Medium(2)    Hard(3)");
            if(checkIfInt(scanner)){
                int i = scanner.nextInt();
                switch (i){
                    case 1: return 1;
                    case 2: return 2;
                    case 3: return 3;
                    default: break;
                }
            }
            System.out.println("Invalid answer, try again!");
        }
    }

    private boolean checkIfCorrectInputInt(int input, int min, int max){

        if(input <=max && input >= min){
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
    private boolean checkIfCorrectInputString(String input, List<String> elements) {
            if(elements.contains(input)) {
                return true;
            }
            else{
                return false;
            }

    }

    private boolean checkIfString(Scanner scanner){
        if(scanner.hasNext()){
            return true;
        }
        return false;

    }
    private boolean checkIfInt(Scanner scanner){
        if(scanner.hasNextInt()){
            return true;
        }
        return false;
    }

}

