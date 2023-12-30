package tictactoe;

import java.util.Scanner;

/**
 * Class for TicTacToe
 * TicTacToe is a game for two players, X and O, who take turns marking the spaces in a 3×3 grid.
 * methods:
 * main() - starts the game
 * inputCheck() - checks if userinput is valid
 * hasWinner() - checks if there is a winner
 * switchCurrentPlayer() - switches the current player
 * start() - starts the game
 */
public class TicTacToe {
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe() {
    }

    /**
     * Starts the game
     */
    void start() {
        Scanner scanner;
        try{
            scanner = new Scanner(System.in);
        } catch (Exception e) {
            throw new RuntimeException("Scanner failed");
        }
        System.out.println("Welcome to Tic Tac Toe!\nPlayer 1: Please choose your marker (x or o)");
        boolean scanOk = false;

        while (!scanOk) {
            char c = scanner.next().charAt(0);
            if (c == 'o') {
                player1 = new Player('o');
                player2 = new Player('x');
                scanOk = true;
            } else if (c == 'x') {
                player1 = new Player('x');
                player2 = new Player('o');
                scanOk = true;
            } else {
                System.out.println("Invalid input, please try again");
            }
        }
        System.out.println("Thank you. That leaves Player 2 with " + player2.getMarker());
        System.out.println("______\n");
        scanner.close();
        board = new Board();
    }

    /**
     * Switches the current player
     */
    void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else if (currentPlayer == player2) {
            currentPlayer = player1;
        }
    }

    /**
     * checks if game has been won horizontally
     * @return true if won
     */
    boolean wonHorizontally() {
        int count = 0;
        for (int i = 0; i < Board.MAX; i++) {
            if (board.cells[i][0] == ' ') {
                continue;
            }
            if (board.cells[i][0] == board.cells[i][1]) {
                count++;
            }
            if (board.cells[i][0] == board.cells[i][2]) {
                count++;
            }
            if (count == 2) {
                return true;
            }
            count = 0;
        }
        return false;
    }

    /**
     * checks if game has been won vertically
     * @return true if won
     */
    boolean wonVertically() {
        int count = 0;
        for (int j = 0; j < Board.MAX; j++) {
            if (board.cells[0][j] == ' ') {
                continue;
            }
            if (board.cells[0][j] == board.cells[1][j]) {
                count++;
            }
            if (board.cells[0][j] == board.cells[2][j]) {
                count++;
            }
            if (count == 2) {
                return true;
            }
            count = 0;
        }
        return false;
    }

    /**
     * Checks if game has been won diagonally
     * @return true if won
     */
    boolean wonDiagonal(){
        if (board.cells[0][0] != ' ' &&
                board.cells[0][0] == board.cells[1][1] && board.cells[0][0] == board.cells[2][2]) {
            return true;
        } else return (board.cells[0][2] != ' ' &&
                board.cells[0][2] == board.cells[1][1] && board.cells[0][2] == board.cells[2][0]);
    }
    /**
     * Checks if there is a winner
     *
     * @return true if there is a winner
     */
    boolean hasWinner() {
        return wonDiagonal() || wonHorizontally() || wonVertically();
    }
}
