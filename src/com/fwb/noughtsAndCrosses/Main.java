package com.fwb.noughtsAndCrosses;

import com.fwb.noughtsAndCrosses.controller.Game;
import com.fwb.noughtsAndCrosses.model.Player;
import com.fwb.noughtsAndCrosses.view.Reader;
import com.fwb.noughtsAndCrosses.model.Field;

import java.io.Console;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        Field field = new Field();
        System.out.println("\t\t***Welcome!***");
        field.showField();
        initializationGameAndPlayers(reader);
    }



    private static void initializationGameAndPlayers(Reader reader) throws IOException {
        Game noughtsAndCrosses = new Game("noughtsAndCrosses", 2, initializationPlayer(reader), initializationPlayer(reader));
        System.out.println(noughtsAndCrosses.getPlayer(1) + " and " + noughtsAndCrosses.getPlayer(2) + " you play: " + '"' + noughtsAndCrosses.getGameName() + '"' + "\n");
        System.out.println();
        noughtsAndCrosses.startGame();

    }

    private static Player initializationPlayer(Reader reader) {
        System.out.print("Enter the name of the player: ");
        Player player = new Player(reader.scanString());
        return player;
    }
}
