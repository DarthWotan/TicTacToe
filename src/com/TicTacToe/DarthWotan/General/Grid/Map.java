package com.TicTacToe.DarthWotan.General.Grid;

import java.util.HashMap;

public class Map {
    public enum State{Blank,X, O}
    private State[][] board;
    private int n = 3;
    private HashMap<State, String> map = new HashMap<State, String>();

    public Map() {
        board = new State[n][n];
        map.put(board[0][0], "-");
        map.put(board[0][1], "-");
        map.put(board[0][2], "-");
        map.put(board[1][0], "-");
        map.put(board[1][1], "-");
        map.put(board[1][2], "-");
        map.put(board[2][0], "-");
        map.put(board[2][1], "-");
        map.put(board[2][2], "-");
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
