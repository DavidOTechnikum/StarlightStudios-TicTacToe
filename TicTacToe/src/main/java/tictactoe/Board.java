package tictactoe;

import java.util.Arrays;

public class Board {
    protected char[][] cells;
    static final int MAX = 3;
    static final int TRUE = 0;
    static final int FALSE = 1;
    static final int EXCEPTION = 2;

    Board() {
        cells = new char[MAX][MAX];
        Arrays.stream(cells).forEach(a -> Arrays.fill(a, ' '));
    }
    void print() {
        System.out.println("   0 1 2");
        for (int i = 0; i < MAX; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < MAX; j++) {
                System.out.print(cells[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }
    boolean isFull() {
        int count = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (cells[i][j] == ' ') {
                    count++;
                }
            }
        }
        return (count == 0);
    }
    void clear() {
        cells = new char[MAX][MAX];
        Arrays.stream(cells).forEach(a -> Arrays.fill(a, ' '));
    }
    boolean place(int row, int col, char marker) {
        if (this.isCellEmpty(row, col) == TRUE) {
            try {
                cells[row][col] = marker;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input, please try again");
                return false;
            }
        } else {
            System.out.println("Invalid input");
            return false;
        }
        return true;
    }
    int isCellEmpty(int row, int col) {
        try {
            if (cells[row][col] == ' ') {
                return TRUE;
            } else {
                return FALSE;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong input, please try again");
        }
        return EXCEPTION;
    }
}
