package com.fwb.noughtsAndCrosses.view;

import java.io.*;

import java.util.Scanner;

public class Reader {

    Scanner scn = new Scanner(System.in);

    public char scanChar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return (char) br.read();

    }

    public int scanInt() {
        return scn.nextInt();
    }

    public String scanString() {
        return scn.nextLine();
    }





}
