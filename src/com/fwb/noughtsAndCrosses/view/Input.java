package com.fwb.noughtsAndCrosses.view;

import com.fwb.noughtsAndCrosses.model.Player;

import java.util.Scanner;

public class Input {

    Scanner scn = new Scanner(System.in);

//    public char scanChar() throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        return (char) br.read();
//    }

    public int scanInt() {
        return scn.nextInt();
    }

    public String scanString() {
        return scn.nextLine();
    }

    public Player scanPlayer() {
        System.out.print("Enter the name of the player: ");
        return new Player(scanString());
    }





}
