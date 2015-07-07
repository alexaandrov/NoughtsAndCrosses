package com.fwb.noughtsAndCrosses;

import java.io.IOException;
import com.fwb.noughtsAndCrosses.controller.Game;
import com.fwb.noughtsAndCrosses.view.Reader;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        System.out.println("\t\t***Welcome!***");
        Game game = new Game("Noughts and Crosses", reader.scanPlayer(), reader.scanPlayer());
        game.field.showField();
        game.startGame();
    }
}
