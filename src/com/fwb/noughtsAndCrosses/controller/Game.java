package com.fwb.noughtsAndCrosses.controller;

import java.io.IOException;
import java.util.Random;
import com.fwb.noughtsAndCrosses.model.Player;
import com.fwb.noughtsAndCrosses.view.Input;
import com.fwb.noughtsAndCrosses.model.Field;

public class Game {

    private String gameName;

    private final int playersCount;

    private Player[] players;

    private Random rand = new Random();

    private Input input = new Input();

    private int step;

    public Field field = new Field();

    public Game(String gameName, Player player1, Player player2) {
        this.step = rand.nextInt(5000) % 2;
        this.gameName = gameName;
        this.playersCount = 2;
        players = new Player[playersCount];
        this.players[0] = player1;
        this.players[1] = player2;
        System.out.println('\n' + players[0].getPlayerName() + " and " + players[1].getPlayerName() + " you are playing " + getGameName() + '\n');
    }

    public void startGame() throws IOException {
        for (int i = 0; i < 9; i++) {
            Player currentPlayer = selectPlayer();
            currentPlayer.putValue(input.scanInt(), currentPlayer);
            field.showField();
        }
    }

    private String getGameName() {
        return gameName;
    }

    private Player selectPlayer() {
        if (randStep()) {
            System.out.print(players[0].getPlayerName() + " enter number: ");
            return players[0];
        }
        else {
            System.out.print(players[1].getPlayerName() + " enter number: ");
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

