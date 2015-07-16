package com.fwb.noughtsAndCrosses.model;

public class Player {

    private final String name;

    private final char fieldSymbol;

    private int score;

    public Player(String name, char fieldSymbol) {
        this.name = name;
        this.fieldSymbol = fieldSymbol;
        score = 0;
    }

    public char getFieldSymbol() {
        return fieldSymbol;
    }

    public String getPlayerName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void putScore() {
        this.score++;
    }
}
