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

    /////////////////////////////////////////// WIN // что - то с ним сделать ///////////////////////////
    public boolean Win(Player firstPlayer, Player secondPlayer) {
        for (int i = MIN_FIELD_SIZE; i < MAX_FIELD_SIZE; i++) {
            if (checkNichya(firstPlayer, secondPlayer))
                return true;
            else if ((field[i][0] == field[i][1]) && (field[i][0] == field[i][2]))
                return true;
            else if ((field[0][i]) == field[1][i] && (field[0][i] == field[2][i]))
                    return true;
            else if (field[0][0] == field[1][1] && field[0][0] == field[2][2] || (field[0][2] == field[1][1] && field[0][2] == field[2][0]))
                    return true;
            }
        return false;
    }

    public String searchWinner(Player firstPlayer, Player secondPlayer) {
        if (getWinnerSymbol(firstPlayer, secondPlayer) == firstPlayer.getFieldSymbol()) {
            firstPlayer.putScore();
            return firstPlayer.getPlayerName();
        }
        else if (getWinnerSymbol(firstPlayer, secondPlayer) == secondPlayer.getFieldSymbol()) {
            secondPlayer.putScore();
            return secondPlayer.getPlayerName();
        }
        else if (getWinnerSymbol(firstPlayer, secondPlayer) == '-')
            return "No winner";
        else if (getWinnerSymbol(firstPlayer, secondPlayer) == 'j') {
            return "error";
        }
        return "Game fail";
    }

    private char getWinnerSymbol(Player firstPlayer, Player secondPlayer) {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2])
                return field[i][0];
                else if (field[0][i] == field[1][i] && field[0][i] == field[2][i])
                    return field[0][i];
                else if (field[0][0] == field[1][1] && field[0][0] == field[2][2])
                    return field[0][0];
                else if (field[0][2] == field[1][1] && field[0][2] == field[2][0])
                    return field[0][2];
            }
        if (checkNichya(firstPlayer, secondPlayer))
            return '-';
        return 'j';
    }

    private boolean checkNichya(Player firstPlayer, Player secondPlayer) {
        char ch = field[0][0];
        for (int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                if (ch == firstPlayer.getFieldSymbol() || ch == secondPlayer.getFieldSymbol())
                    ch = field[i][j];
                else
                    ch = '!';
            }
        return ch == firstPlayer.getFieldSymbol() || ch == secondPlayer.getFieldSymbol();
    }
}
