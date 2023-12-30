package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe() {
    }

    /**
     *
     */
    void start() {
        Scanner scanner = null;
        try{
            scanner = new Scanner(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("\nPlayer 1: Please choose your marker (x or o)");
        boolean scanOk = false;

        while (!scanOk) {
            assert scanner != null;
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
        //scanner.close();

        board = new Board();
    }

    void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else if (currentPlayer == player2) {
            currentPlayer = player1;
        }
    }

    boolean hasWinner() {
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
        if (board.cells[0][0] != ' ' && board.cells[0][0] == board.cells[1][1] && board.cells[0][0] == board.cells[2][2]) {
            return true;
        } else return (board.cells[0][2] != ' ' && board.cells[0][2] == board.cells[1][1] && board.cells[0][2] == board.cells[2][0]);
    }

}
