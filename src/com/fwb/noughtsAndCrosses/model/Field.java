package com.fwb.noughtsAndCrosses.model;

import com.fwb.noughtsAndCrosses.view.ConsoleView;

public class Field {

    ConsoleView consoleView = new ConsoleView();

    private static final int MAX_FIELD_SIZE = 3;

    public static final int MIN_FIELD_SIZE = 0;

    private static char field[][] = new char[MAX_FIELD_SIZE][MAX_FIELD_SIZE];

    private static final int NUMBER_ONE_IN_THE_ASCII = 49;

    private static final int MIN_FIELD_NUMBER = 1;

    private static final int MAX_FIELD_NUMBER = 9;

    private static int temp;

    private int iterator;

    private static int[] controlStepValue;

    public Field() {
        createField();
        temp = 0;
        iterator = 0;
        controlStepValue = new int[9];
    }

    public void createField() {
        for (int lineNumber = MIN_FIELD_SIZE; lineNumber < MAX_FIELD_SIZE; lineNumber++) {
            for (int cellNumber = 0; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                field[lineNumber][cellNumber] = (char) (NUMBER_ONE_IN_THE_ASCII + iterator);
                iterator++;
            }
        }
    }

    public char[][] getField() {
        return field;
    }

    public void showField() {
        for (int lineNumber = MIN_FIELD_SIZE; lineNumber < MAX_FIELD_SIZE; lineNumber++) {
            System.out.print(" | ");
            for (int cellNumber = 0; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                System.out.print(field[lineNumber][cellNumber] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void putValue(Player player) {
        int value = consoleView.askPlayerCoordinate(player);
        if ((value < MIN_FIELD_NUMBER || value > MAX_FIELD_NUMBER) || value < findControlStepValue(value)) {
            while ((value < MIN_FIELD_NUMBER || value > MAX_FIELD_NUMBER) || value < findControlStepValue(value)) {
                value = consoleView.askPlayerCoordinate(player);
            }
            setControlStepValue(value);
            findAndPutValue(value, player);
        } else {
            setControlStepValue(value);
            findAndPutValue(value, player);
        }
    }

    private void findAndPutValue(int value, Player player) {
        for (int lineNumber = MIN_FIELD_SIZE; lineNumber < MAX_FIELD_SIZE; lineNumber++) {
            for (int cellNumber = 0; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                if (field[lineNumber][cellNumber] == NUMBER_ONE_IN_THE_ASCII - 1 + value) {
                    field[lineNumber][cellNumber] = player.getFieldSymbol();
                }
            }
        }
    }

    private void setControlStepValue(int value) {
        controlStepValue[temp] = value;
        temp++;
    }

    private int findControlStepValue(int value) {
        int somethingNumber = 11;
        for (int i = 0; i < 9; i++) {
            if (controlStepValue[i] == value) {
                value = somethingNumber;
            }
        }
        return value;
    }
}
