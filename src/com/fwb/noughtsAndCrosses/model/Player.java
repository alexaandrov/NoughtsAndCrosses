package com.fwb.noughtsAndCrosses.model;

public class Player extends Field {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return name;
    }
}
