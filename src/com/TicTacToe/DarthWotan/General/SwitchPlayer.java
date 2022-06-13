package com.TicTacToe.DarthWotan.General;

import com.TicTacToe.DarthWotan.Bot.BotEasy;
import com.TicTacToe.DarthWotan.Console.OutputConsole;
import com.TicTacToe.DarthWotan.Player.Player;
// class which switches players/let them play
public class SwitchPlayer {
    private String namePlayer1, namePlayer2;
    private Player player1, player2, currentPlayer;
    private CheckWinner gameisrunning;
    private OutputConsole outputConsole;


    public SwitchPlayer(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        namePlayer1 = player1.getName();
        namePlayer2 = player2.getName();
        outputConsole = new OutputConsole(player1.getGrid());

    }

    private void switchPlayer(){
        if(currentPlayer == player1){
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    public void playGame(){
        int moves = 0;
        while(true){
            moves += 1;
            gameisrunning = new CheckWinner(currentPlayer.getGrid(), currentPlayer, moves);
            currentPlayer.placeStone();
            outputConsole.printGrid();
            if(!gameisrunning.gameIsGoing()){
                if(gameisrunning.win()) {
                    outputConsole.printWinner(currentPlayer.getName());
                }
                else {
                    outputConsole.printTie();
                }
                break;
            }
            switchPlayer();

        }
    }
}

