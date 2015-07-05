package com.fwb.noughtsAndCrosses.model;

public class Field {

    private static final int FIELD_SIZE = 4;

    private static final int MIN_FIELD_SIZE = 1;

    private static final char FIELD_CELL = '-';

    private static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

    Field() {
        createField();
    }

    public void showField() {
        for(int lineNumber = MIN_FIELD_SIZE; lineNumber < FIELD_SIZE; lineNumber++) {
            for (int cellNumber = MIN_FIELD_SIZE; cellNumber < FIELD_SIZE; cellNumber++) {
                System.out.print("[" + field[lineNumber][cellNumber] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void putValue(int lineNumber, int cellNumber, char value) {
        field[lineNumber][cellNumber] = value;
    }

    private void createField() {
        for(int lineNumber = MIN_FIELD_SIZE; lineNumber < FIELD_SIZE; lineNumber++) {
            for(int cellNumber = MIN_FIELD_SIZE; cellNumber < FIELD_SIZE; cellNumber++) {
                field[lineNumber][cellNumber] = FIELD_CELL;
            }
        }
    }
}
