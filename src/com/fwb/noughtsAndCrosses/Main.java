package com.fwb.noughtsAndCrosses;

import java.io.IOException;
import com.fwb.noughtsAndCrosses.controller.Game;
import com.fwb.noughtsAndCrosses.view.Input;


public class Main {

    public static void main(String[] args) throws IOException {
        Input input = new Input();
        System.out.println("\t\t***Welcome!***");
        Game game = new Game("Noughts and Crosses", input.scanPlayer(), input.scanPlayer());
        game.field.showField();
        game.startGame();
    }
}
