package com.TicTacToe.DarthWotan.General;

import com.TicTacToe.DarthWotan.General.Grid.Map;
import com.TicTacToe.DarthWotan.Player.Player;

import java.util.HashMap;

public class CheckWinner {
    private Map grid;
    private int n, m;
    private HashMap<Map.State, String> map;
    private Map.State[][] board;
    private Player currentPlayer;
    private String symbol;

    public CheckWinner(Map grid, Player currentPlayer, int moves) {
        this.grid = grid;
        map = grid.getMap();
        this.currentPlayer = currentPlayer;
        symbol = currentPlayer.getSymbol();
        board = grid.getBoard();
        n = grid.getN();
        this.m = moves;
    }

    public boolean gameIsGoing() {
        if (win() ||tie(m) ) {
            return false;
        } else {
            return true;
        }
    }

    private boolean tie(int moves) {
        if (moves == Math.pow(n, 2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean win() {
        checkRow();
        if (checkRow() || checkColumn() || checkDiagonal()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkRow() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x] != currentPlayer.getState()) {
                    break;
                }
                if (x == n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumn() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (board[y][x] != currentPlayer.getState())
                    break;

                if (y == n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        for (int x = 0; x < n; x++) { // maybe not necessary
            for (int y = 0; y < n; y++) {
                if (x == y) { // diagonal
                    for (int i = 0; i < n; i++) {
                        if (board[i][i] != currentPlayer.getState()) {
                            break;
                        }
                        if (i == n - 1) {
                            return true;
                        }
                    }
                }
                if (x + y == n - 1) { // anti diagonal
                    for (int i = 0; i < n; i++) {
                        if (board[i][(n - 1) - i] != currentPlayer.getState()) {
                            break;
                        }
                        if (i == n - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
