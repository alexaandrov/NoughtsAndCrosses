package com.fwb.noughtsAndCrosses.model;

public class Field {

    private static char field[][] = new char[3][3];

    private int l = 0;

    public Field() {
        createField();
    }

    private void createField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = (char) (49 + l);
                l++;
            }
        }
    }

    public void showField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + field[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void putValue(char value, char symbol) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == value) {
                    field[i][j] = symbol;
                }
            }
    }
}