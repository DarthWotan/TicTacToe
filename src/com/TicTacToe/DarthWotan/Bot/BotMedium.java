package com.TicTacToe.DarthWotan.Bot;

import com.TicTacToe.DarthWotan.General.Grid.Map;
import com.TicTacToe.DarthWotan.Player.Player;

import java.util.Random;

public class BotMedium extends Player {
    private int n;
    private Map.State[][] board;
    public BotMedium(String name, String symbol, Map.State state, Map grid) {
        super(name, symbol, state, grid);
        n = grid.getN();
        board = grid.getBoard();
    }
    @Override
    public void placeStone() {
        int place;
        outputConsole.printBotMessage(name);
        while(true) {
            place = getPlace();
            if(grid.checkIfFree(place)){
                break;
            }
        }
        grid.changeMap(place, state);
    }

    @Override
    public int getPlace() {
        int place;
        Random random = new Random();
        place = checkRow();
        if (place != 0){ // 0 means, there are not 2 in the same row
            return place;
        }
        place = checkColumn();
        if (place != 0){ // 0 means, there are not 2 in the same column
            return place;
        }
        place = checkDiagonal();
        if (place != 0){ // 0 means, there are not 2 in the same diagonal
            return place;
        }
        place = checkAntiDiagonal();
        if (place != 0){ // 0 means, there are not 2 in the same anti-diagonal
            return place;
        }
        while (true) {
            place = random.nextInt(8) + 1;
            if(getGrid().checkIfFree(place)){
                return place;
            }
        }

    }

    private int checkRow(){
        int rs = 0;
        int rs2 = 0;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (board[row][column] != state) {
                    rs += 1;
                }
                if(board[row][column] != Map.State.X){
                    rs2 +=1;
                }
            }
            if(rs == 1 || rs2 == 1){
                System.out.println("got it");
                return getPlaceRow(row);
            }
            rs = 0;
            rs2 = 0;
        }

        return 0;
    }

    private int getPlaceRow(int row){
        for(int column = 0; column < n; column++){
            if(board[row][column] == Map.State.Blank){
                return grid.getPlace(row, column);
            }
        }
        return 0;
    }

    private int checkColumn(){
        int cols = 0;
        int cols2 = 0;
        for (int column = 0; column < n; column++) {
            for (int row = 0; row < n; row++) {
                if (board[row][column] != state) {
                    cols += 1;
                }
                if( board[row][column] != Map.State.X){
                    cols2 += 1;
                }

            }
            if(cols == 1 || cols2 == 1){
                return getPlaceColumn(column);
            }
            cols = 0;
            cols2 = 0;
        }
        return 0;
    }

    private int getPlaceColumn(int column){
        for(int row = 0; row < n; row++){
            if(board[row][column] == Map.State.Blank){
                return grid.getPlace(row, column);
            }
        }
        return 0;
    }

    private int checkDiagonal(){ // todo: überprüfen (bei get methode nachschauen und den state checken)
        int diagonals = 0;
        int diagonals2 = 0;

        for (int i = 0; i < n; i++) {
            if (board[i][i] != state) {
                diagonals += 1;

            }
            if( board[i][i] != Map.State.X){
                diagonals2 += 1;
            }

        }




        if(diagonals == 1 || diagonals2 == 1){
            return getPlaceDiagonal();
        }
        return 0;
    }

    private int checkAntiDiagonal() {
        int antiDiagonals = 0;
        int antiDiagonals2 = 0;

        for (int i = 0; i < n; i++) {
            if (board[i][(n - 1) - i]  != state) {
                antiDiagonals += 1;

            }
            if(board[i][(n - 1) - i] != Map.State.X){
                antiDiagonals2 += 1;
            }



        }
        if(antiDiagonals == 1 || antiDiagonals2 == 1){
            return getPlaceAntiDiagonal();
        }
        return 0;
    }

    private int getPlaceDiagonal() {
        for (int row = 0; row < n; row++) { // maybe not necessary
            for (int column = 0; column < n; column++) {
                if (row == column) { // diagonal
                    for (int i = 0; i < n; i++) {
                        if (board[i][i] == Map.State.Blank) {
                            return grid.getPlace(i, i);
                        }
                    }

                }
            }
        }
        return 0;
    }

    private int getPlaceAntiDiagonal(){
        for (int row = 0; row < n; row++) {// maybe not necessary
            for (int column = 0; column < n; column++) {
                if (row + column == n - 1) { // anti diagonal
                    for (int i = 0; i < n; i++) {
                        if (board[i][(n - 1) - i] == Map.State.Blank) {
                            return grid.getPlace(i, (n - 1) -i );
                        }
                    }
                }
            }
        }
        return 0;
    }
}
