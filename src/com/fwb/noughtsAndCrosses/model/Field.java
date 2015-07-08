package com.fwb.noughtsAndCrosses.model;

import com.fwb.noughtsAndCrosses.view.Reader;

public class Field {

    Reader reader = new Reader();

    private static final int MAX_FIELD_SIZE = 3;

    public static final int MIN_FIELD_SIZE = 0;

    private static char field[][] = new char[MAX_FIELD_SIZE][MAX_FIELD_SIZE];

    private static final int NUMBER_ONE_IN_THE_ASCII = 49;

    private static final int MIN_FIELD_NUMBER = 1;

    private static final int MAX_FIELD_NUMBER = 9;

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

    public void putValue(int value, char fieldSymbol) {
        if (value < MIN_FIELD_NUMBER || value > MAX_FIELD_NUMBER) {
            while (value < MIN_FIELD_NUMBER || value > MAX_FIELD_NUMBER) {
                System.out.print( "Enter number again: ");
                value = reader.scanInt();
            }
            findAndPutValue(value, fieldSymbol);
        } else {
            findAndPutValue(value, fieldSymbol);
        }
    }

    private void findAndPutValue(int value, char fieldSymbol) {
        for (int lineNumber = MIN_FIELD_SIZE; lineNumber < MAX_FIELD_SIZE; lineNumber++) {
            for (int cellNumber = 0; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                if (field[lineNumber][cellNumber] == NUMBER_ONE_IN_THE_ASCII - 1 + value) {
                    field[lineNumber][cellNumber] = fieldSymbol;
                }
            }
        }
    }
}
