package com.fwb.noughtsAndCrosses.view;

import com.fwb.noughtsAndCrosses.model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleView {

    private Scanner scn = new Scanner(System.in);

    public int scanInt() {
        return scn.nextInt();
    }

    public String scanString() {
        return scn.nextLine();
    }

    public Player scanPlayer(char symbol) {
        System.out.print("Enter the name of the player: ");
        return new Player(scanString(), symbol);
    }
    public char scanChar() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    return (char) br.read();
    }

    public void printLine() {
        System.out.println("---------------");
    }

    public int askPlayerCoordinate(Player player) {
        System.out.print(player.getPlayerName() + " enter number: ");
        return scanInt();
    }
}
