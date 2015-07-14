package com.fwb.noughtsAndCrosses;

import java.io.IOException;
import com.fwb.noughtsAndCrosses.controller.Game;
import com.fwb.noughtsAndCrosses.view.ConsoleView;

public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleView consoleView = new ConsoleView();
        System.out.println("\t\t***Welcome!***");
        Game game = new Game("Noughts and Crosses", consoleView.scanPlayer('X'), consoleView.scanPlayer('O'));
        game.startGame();
    }
}
