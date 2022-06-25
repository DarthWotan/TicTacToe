package com.TicTacToe.DarthWotan.General.Grid;

import java.util.HashMap;

public class Map {
    public enum State{Blank,X, O}
    private State[][] board;
    private int n = 3;
    private HashMap<State, String> map = new HashMap<State, String>();

    public Map() {
        board = new State[n][n];
        setBoard();
    }

    private void setBoard(){
        for(int x =0; x<n; x++){
            for(int y = 0; y<n; y++){
                board[y][x] = State.Blank;
                map.put(board[y][x], "-");
            }
        }
    }
    public void resetBoard(){
        setBoard();
    }
    public void changeMap(int p, State v){
        int row = getRow(p), column = getColumn(p);
        board[row][column] = v;
        if(v == State.X){
            map.put(board[row][column], "X");
        }
        else{
            map.put(board[row][column], "O");

        }
    }

    public State getState(int place){
        int row = getRow(place), column = getColumn(place);
        return board[row][column];
    }
    public int getRow(int place){
        switch (place){
            case 1, 2, 3 -> {
                return 0;
            }
            case 4, 5, 6 -> {
                return 1 ;
            }
            case 7, 9, 8 -> {
                return 2 ;
            }
        }
        return 3;
    }

    public int getColumn(int place){
        switch (place){
            case 1, 4, 7 -> {
                return 0 ;
            }
            case 2, 5, 8 -> {
                return 1 ;
            }
            case 3, 6, 9 -> {
                return 2 ;
            }
        }
        return 3;
    }

    public int getPlace(int row, int column){
        if(row == 0) {
            if(column == 0) return 1;
            if(column == 1) return 2;
            if(column == 2) return 3;
        }
        if(row == 1) {
            if(column == 0) return 4;
            if(column == 1) return 5;
            if(column == 2) return 6;
        }
        if(row == 2) {
            if(column == 0) return 7;
            if(column == 1) return 8;
            if(column == 2) return 9;
        }
        return 0;
    }

    public boolean checkIfFree(int place){
        if(map.get(getState(place)).equals("-")){
            return true;
        }
        else{
            return false;
        }
    }


    public State[][] getBoard() {
        return board;
    }

    public int getN() {
        return n;
    }

    public HashMap<State, String> getMap() {
        return map;
    }
}
