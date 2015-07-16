package com.fwb.noughtsAndCrosses.controller;

import java.io.IOException;
import java.util.Random;
import com.fwb.noughtsAndCrosses.model.Player;
import com.fwb.noughtsAndCrosses.model.Winner;
import com.fwb.noughtsAndCrosses.view.ConsoleView;
import com.fwb.noughtsAndCrosses.model.Field;

public class Game {

    private String gameName;

    private final int playersCount;

    private final Player[] players;

    private final ConsoleView consoleView = new ConsoleView();

    private int step;

    public Game(String gameName, Player player1, Player player2) {
        this.gameName = gameName;
        this.playersCount = 2;
        players = new Player[playersCount];
        this.players[0] = player1;
        this.players[1] = player2;
        System.out.println('\n' + players[0].getPlayerName() + " and " + players[1].getPlayerName() + " you are playing " + getGameName() + '\n');
        Random rand = new Random();
        this.step = rand.nextInt(playersCount) % playersCount;
    }

    public void startGame() throws IOException {
        do {
            showScore(playersCount - 1);
            showScore(playersCount);
            Field field = new Field();
            Winner winner = new Winner(field.getField(), players[0], players[1], 0, 3);
            field.showField();
            while (!winner.Win()) {
                Player currentPlayer = selectPlayer();
                currentPlayer.sendCoordinate(currentPlayer);
                field.showField();
            }
            System.out.println(winner.searchWinner() + " is win");
            consoleView.printLine();
            System.out.print("Again, y or n: ");
        } while (consoleView.scanChar() != 'n');
    }

    private void showScore(int n) {
        System.out.println(" Score -> " + players[n - 1].getPlayerName() + "(" + players[n - 1].getScore() + ")");
        consoleView.printLine();
    }

    private String getGameName() {
        return gameName;
    }

    private Player selectPlayer() {
        if (getRandStep()) {
            return players[0];
        }
        else {
            return players[1];
        }
    }

    private boolean getRandStep() {
        if (step == 1) {
            step = 0;
            return true;
        }
        else {
            step = 1;
            return false;
        }
    }
}

