package com.fwb.noughtsAndCrosses.model;

public class Field {

    private static char field[][] = new char[3][3];

    private static final int MAX_FIELD_SIZE = 3;

    public static final int MIN_FIELD_SIZE = 0;

    private static final int NUMBER_ONE_IN_THE_ASCII = 49;

    private int iterator = 0;

    public Field() {
        createField();
    }

    private void createField() {
        for (int lineNumber = MIN_FIELD_SIZE; lineNumber < MAX_FIELD_SIZE; lineNumber++) {
            for (int cellNumber = 0; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                field[lineNumber][cellNumber] = (char) (NUMBER_ONE_IN_THE_ASCII + iterator);
                iterator++;
            }
        }
    }

    public void showField() {
        for (int lineNumber = MIN_FIELD_SIZE; lineNumber < MAX_FIELD_SIZE; lineNumber++) {
            for (int cellNumber = 0; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                System.out.print("[" + field[lineNumber][cellNumber] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void putValue(char value, char symbol) {
        for (int lineNumber = MIN_FIELD_SIZE; lineNumber < MAX_FIELD_SIZE; lineNumber++) {
            for (int cellNumber = 0; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                if (field[lineNumber][cellNumber] == value) {
                    field[lineNumber][cellNumber] = symbol;
                }
            }
        }
    }
}