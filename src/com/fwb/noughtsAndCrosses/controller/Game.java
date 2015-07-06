package com.fwb.noughtsAndCrosses.controller;

import com.fwb.noughtsAndCrosses.model.Player;
import java.util.Random;
import com.fwb.noughtsAndCrosses.view.Reader;
import java.io.IOException;

public class Game {

    private String gameName;

    private int playersCount;

    private Player[] players;

    private Random rand = new Random();

    private Reader reader = new Reader();

    private char Symbol = 'x';

    public Game(String gameName, int playersCount, Player player1, Player player2) {
        this.gameName = gameName;
        this.playersCount = playersCount;
        players = new Player[playersCount];
        this.players[0] = player1;
        this.players[1] = player2;
    }

    public void startGame() throws IOException {
        for (int i = 0; i < 9; i++) {
            selectPlayer().putValue(reader.scanChar(), Symbol);
            selectPlayer().showField();
        }
    }

    private Player selectPlayer() {
        if (rand.nextBoolean() == true) {
            System.out.println(players[0].getPlayerName() + " enter number:");
            return players[0];
        }
        else {
            System.out.println(players[1].getPlayerName() + " enter number:");
            return players[1];
        }
    }


    public String getGameName() {
        return gameName;
    }

    public String getPlayer(int playerNumber) {
        return players[playerNumber - 1].getPlayerName();
    }


}

