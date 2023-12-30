package tictactoe;

import java.util.Arrays;

/**
 * Class for Board
 * TicTacToe board is a 3x3 grid
 * methods:
 * print() - prints the board
 * isFull() - checks if board is full
 * clear() - clears the board
 * place() - places a marker on the board
 * isCellEmpty() - checks if cell is empty
 */
public class Board {
    protected char[][] cells;
    static final int MAX = 3;
    static final int TRUE = 0;
    static final int FALSE = 1;
    static final int EXCEPTION = 2;

    /**
     * Constructor for Board
     */
    Board() {
        cells = new char[MAX][MAX];
        Arrays.stream(cells).forEach(a -> Arrays.fill(a, ' '));
    }

    /**
     * Prints the board
     */
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

    /**
     * Checks if board is full
     *
     * @return true if full
     */
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

    /**
     * Clears the board
     */
    void clear() {
        cells = new char[MAX][MAX];
        Arrays.stream(cells).forEach(a -> Arrays.fill(a, ' '));
    }

    /**
     * Places a marker on the board
     *
     * @param row    row
     * @param col    column
     * @param marker marker
     * @return true if successful
     */
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

    /**
     * Checks if cell is empty
     *
     * @param row row
     * @param col column
     * @return TRUE if empty
     */
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
