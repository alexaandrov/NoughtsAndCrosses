package com.fwb.noughtsAndCrosses.controller;

import com.fwb.noughtsAndCrosses.model.Player;

public class Game {

    private String gameName;

    private int playersCount;

    private Player[] players;

    public Game(String gameName, int playersCount, Player player1, Player player2) {
        this.gameName = gameName;
        this.playersCount = playersCount;
        players = new Player[playersCount];
        this.players[0] = player1;
        this.players[1] = player2;
    }


    public String getGameName() {
        return gameName;
    }

    public String getPlayer(int playerNumber) {
        return players[playerNumber - 1].getPlayerName();
    }


}

