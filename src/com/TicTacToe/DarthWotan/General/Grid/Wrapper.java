package com.TicTacToe.DarthWotan.General.Grid;

public class Wrapper {
    int row, column;
    String symbol;

    public Wrapper(int row, int column, String symbol) {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
