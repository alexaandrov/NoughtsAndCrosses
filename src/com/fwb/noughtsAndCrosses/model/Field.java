package com.fwb.noughtsAndCrosses.model;

import com.fwb.noughtsAndCrosses.view.Input;

public class Field {

    Input input = new Input();

    private static final int MAX_FIELD_SIZE = 3;

    public static final int MIN_FIELD_SIZE = 0;

    private static char field[][] = new char[MAX_FIELD_SIZE][MAX_FIELD_SIZE];

    private static final int NUMBER_ONE_IN_THE_ASCII = 49;

    private static final int MIN_FIELD_NUMBER = 1;

    private static final int MAX_FIELD_NUMBER = 9;

    private int iterator = 0;

    private static int temp = 0;

    private static int controlStepValue[] = new int[9];

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

    public void putValue(int value, Player player) {
        if ((value < MIN_FIELD_NUMBER || value > MAX_FIELD_NUMBER) || value < findControlStepValue(value)) {
            while ((value < MIN_FIELD_NUMBER || value > MAX_FIELD_NUMBER) || value < findControlStepValue(value)) {
                System.out.print(player.getPlayerName() + " enter number again: ");
                value = input.scanInt();
            }
            findAndPutValue(value, player);
            setControlStepValue(value);
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

    private int findControlStepValue(int number) {
        int somethingNumber = 11;
        for (int i = 0; i < 9; i++) {
            if (controlStepValue[i] == number) {
                number = somethingNumber;
            }
        }
        return number;
    }

    public boolean Win() {
        for (int i = MIN_FIELD_SIZE; i < MAX_FIELD_SIZE; i++) {
            if ((field[i][0] == field[i][1]) && (field[i][0] == field[i][2]))
                return true;
            else {
                if ((field[0][i]) == field[1][i] && (field[0][i] == field[2][i]))
                    return true;
                else if (field[0][0] == field[1][1] && field[0][0] == field[2][2] || (field[0][2] == field[1][1] && field[0][2] == field[2][0]))
                    return true;
            }
        }
        return false;
    }

    public String searchWinner(Player firstPlayer, Player secondPlayer) {
        int firstPlayerCountSymbol = 0;
        int secondPlayerCountSymbol = 0;
        for (int lineNumber = MIN_FIELD_SIZE; lineNumber < MAX_FIELD_SIZE; lineNumber++) {
            for (int cellNumber = 0; cellNumber < MAX_FIELD_SIZE; cellNumber++) {
                if(field[lineNumber][cellNumber] == firstPlayer.getFieldSymbol())
                    firstPlayerCountSymbol++;
                else secondPlayerCountSymbol++;
            }
        }
        if (firstPlayerCountSymbol > secondPlayerCountSymbol) {
            return "The winner is " + firstPlayer.getPlayerName();
        }
        else if (firstPlayerCountSymbol < secondPlayerCountSymbol) {
            return "The winner is " + secondPlayer.getPlayerName();
        }
        return "The bad game";
    }
}
