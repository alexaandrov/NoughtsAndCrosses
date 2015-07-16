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

    private static int[] availableStepsCount;

    public Field() {
        createField();
        temp = 0;
        iterator = 0;
        availableStepsCount = new int[9];
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
            for (int cellNumber = MIN_FIELD_SIZE; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                System.out.print(field[lineNumber][cellNumber] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void sendCoordinate(Player player) {
        int coordinate = consoleView.askPlayerCoordinate(player);
        if ((coordinate < MIN_FIELD_NUMBER || coordinate > MAX_FIELD_NUMBER) || coordinate < findStepCoordinate(coordinate)) {
            while ((coordinate < MIN_FIELD_NUMBER || coordinate > MAX_FIELD_NUMBER) || coordinate < findStepCoordinate(coordinate)) {
                coordinate = consoleView.askPlayerCoordinate(player);
            }
            findAndPutCoordinate(coordinate, player);
        } else {
            findAndPutCoordinate(coordinate, player);
        }
    }


    private void findAndPutCoordinate(int coordinate, Player player) {
        saveStepCoordinate(coordinate);
        for (int lineNumber = MIN_FIELD_SIZE; lineNumber < MAX_FIELD_SIZE; lineNumber++) {
            for (int cellNumber = 0; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                if (field[lineNumber][cellNumber] == NUMBER_ONE_IN_THE_ASCII - 1 + coordinate) {
                    field[lineNumber][cellNumber] = player.getFieldSymbol();
                }
            }
        }
    }

    private void saveStepCoordinate(int value) {
        availableStepsCount[temp] = value;
        temp++;
    }

    private int findStepCoordinate(int stepCoordinate) {
        int firstStep = 0;
        int lastStep = 9;
        int somethingNumberMoreThenNine = 11;

        for (int i = firstStep; i < lastStep; i++) {
            if (availableStepsCount[i] == stepCoordinate) {
                stepCoordinate = somethingNumberMoreThenNine;
            }
        }
        return stepCoordinate;
    }
}
