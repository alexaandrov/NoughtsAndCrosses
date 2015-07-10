package com.fwb.noughtsAndCrosses.model;

public class Player extends Field {

    private final String name;

    private final char fieldSymbol;

    public Player(String name, char fieldSymbol) {
        this.name = name;
        this.fieldSymbol = fieldSymbol;
    }

    public char getFieldSymbol() {
        return fieldSymbol;
    }

    public String getPlayerName() {
        return name;
    }



}
