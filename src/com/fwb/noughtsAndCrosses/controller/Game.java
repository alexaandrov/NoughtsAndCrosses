package com.fwb.noughtsAndCrosses.controller;

import java.io.IOException;
import java.util.Random;
import com.fwb.noughtsAndCrosses.model.Player;
import com.fwb.noughtsAndCrosses.view.ConsoleView;
import com.fwb.noughtsAndCrosses.model.Field;

public class Game {

    private String gameName;

    private final int playersCount;

    private final Player[] players;

    private Random rand = new Random();

    private final ConsoleView consoleView = new ConsoleView();

    private int step;

    public Game(String gameName, Player player1, Player player2) {
        this.gameName = gameName;
        this.playersCount = 2;
        players = new Player[playersCount];
        this.players[0] = player1;
        this.players[1] = player2;
        System.out.println('\n' + players[0].getPlayerName() + " and " + players[1].getPlayerName() + " you are playing " + getGameName() + '\n');
        this.step = rand.nextInt(playersCount) % playersCount;
    }

    public void startGame() throws IOException {
        do {
            showScore(playersCount - 1);
            showScore(playersCount);
            Field field = new Field();
            field.showField();
            while (!field.Win(players[0], players[1])) {
                Player currentPlayer = selectPlayer();
                currentPlayer.putValue(currentPlayer);
                field.showField();
            }
            System.out.println(field.searchWinner(players[0], players[1]) + " is win");
            consoleView.printLine();
            System.out.println("Again, y or n: ");
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
        if (randStep()) {
            return players[0];
        }
        else {
            return players[1];
        }
    }

    private boolean randStep() {
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

