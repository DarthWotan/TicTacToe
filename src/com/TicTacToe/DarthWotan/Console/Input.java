package com.TicTacToe.DarthWotan.Console;

public class Input {
    private String currentName;
    public Input(String currentName) {
        this.currentName = currentName;

    }
    public int getInputConsole(){
        AskScanner input = new AskScanner(currentName); // I used it this way, so that I can change the way of the input (e.g. in an interface etc.)x
        return input.askForPlace();
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }
}
