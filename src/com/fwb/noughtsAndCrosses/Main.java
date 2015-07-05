package com.fwb.noughtsAndCrosses;

import com.fwb.noughtsAndCrosses.controller.Game;
import com.fwb.noughtsAndCrosses.model.Player;
import com.fwb.noughtsAndCrosses.view.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        System.out.println("\t\t***Welcome!***");
        initializationGameAndPlayers(reader);
        System.out.println();

    }

    private static void initializationGameAndPlayers(Reader reader) {
        Game noughtsAndCrosses = new Game("noughtsAndCrosses", 2, initializationPlayer(reader), initializationPlayer(reader));
        System.out.println(noughtsAndCrosses.getPlayer(1) + " and " + noughtsAndCrosses.getPlayer(2) + " you play: " + '"' + noughtsAndCrosses.getGameName() + '"' + "\n");
    }

    private static Player initializationPlayer(Reader reader) {
        System.out.print("Enter the name of the player: ");
        Player player = new Player(reader.scanString());
        return player;
    }
}
