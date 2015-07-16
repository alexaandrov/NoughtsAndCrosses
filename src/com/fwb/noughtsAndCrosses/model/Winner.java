package com.fwb.noughtsAndCrosses.model;

public class Winner {

    private char[][] field;

    Player firstPlayer;

    Player secondPlayer;

    private int MIN_FIELD_SIZE;

    private int MAX_FIELD_SIZE;

    private char noWinnerSymbol = '-';

    private char errorSymbol = '!';


    public Winner(char[][] field, Player firstPlayer, Player secondPlayer, int MIN_FIELD_SIZE,
           int MAX_FIELD_SIZE)  {
        this.field = field;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.MIN_FIELD_SIZE = MIN_FIELD_SIZE;
        this.MAX_FIELD_SIZE = MAX_FIELD_SIZE;
    }

    public boolean Win() {
        for (int i = MIN_FIELD_SIZE; i < MAX_FIELD_SIZE; i++) {
            if (noWinnerCheck())
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

    public String searchWinner() {
        if (getWinnerSymbol() == firstPlayer.getFieldSymbol()) {
            firstPlayer.putScore();
            return firstPlayer.getPlayerName();
        }
        else if (getWinnerSymbol() == secondPlayer.getFieldSymbol()) {
            secondPlayer.putScore();
            return secondPlayer.getPlayerName();
        }
        else if (getWinnerSymbol() == noWinnerSymbol)
            return "No winner";
        else if (getWinnerSymbol() == errorSymbol) {
            return "error";
        }
        return "Game fail";
    }


    private char getWinnerSymbol() {
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
        if (noWinnerCheck())
            return noWinnerSymbol;
        return errorSymbol;
    }

    private boolean noWinnerCheck() {
        char ch = field[0][0];
        for (int i = MIN_FIELD_SIZE; i < MAX_FIELD_SIZE; i++)
            for(int j = 0; j < 3; j++) {
                if (ch == firstPlayer.getFieldSymbol() || ch == secondPlayer.getFieldSymbol())
                    ch = field[i][j];
                else
                    ch = errorSymbol;
            }
        return ch == firstPlayer.getFieldSymbol() || ch == secondPlayer.getFieldSymbol();
    }

}
