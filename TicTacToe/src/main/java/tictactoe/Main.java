package tictactoe;

import java.util.Scanner;

/**
 * Main class for TicTacToe
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.currentPlayer = ticTacToe.player1;
        boolean playAgain = true;

        while (playAgain) {
            do {
                System.out.println("It's Player "
                        + ticTacToe.currentPlayer.getMarker() + "'s turn");

                ticTacToe.board.print();
                makeMove(ticTacToe);
                ticTacToe.switchCurrentPlayer();
            } while (!ticTacToe.hasWinner() && !ticTacToe.board.isFull());

            if (ticTacToe.hasWinner()) {
                printCongratulations(ticTacToe);
            } else if (ticTacToe.board.isFull()) {
                System.out.println("Oh darn, nobody has won");
            }
            ticTacToe.board.clear();
            playAgain = playAgain();
        }
        scanner.close();
    }

    /**
     * Checks if userinput is valid
     *
     * @return input
     */
    static int inputCheck() {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            String s = scanner.nextLine();
            try {
                input = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
                continue;
            }
            if (input < 0 || input > 2) {
                System.out.println("Invalid input, please try again");
            } else {
                break;
            }
        }
        return input;
    }

    /**
     * Makes a move
     *
     * @param ticTacToe TicTacToe
     */
    private static void makeMove(TicTacToe ticTacToe) {
        int row;
        int col;
        do {
            System.out.println("row:");
            row = inputCheck();

            System.out.println("column:");
            col = inputCheck();
            System.out.println("_____\n");
        } while (!ticTacToe.board.place(row, col, ticTacToe.currentPlayer.getMarker()));
    }

    /**
     * Asks if user wants to play again
     *
     * @return true if yes
     */
    static boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Do you want to play again? (y/n)");
            input = scanner.nextLine();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input, please try again");
            }
        }
    }

    /**
     * Prints congratulations message
     *
     */
    static void printCongratulations(TicTacToe ticTacToe) {
        ticTacToe.switchCurrentPlayer();
        ticTacToe.board.print();
        System.out.println("Congratulations! Player "
                + ticTacToe.currentPlayer.getMarker() + " has won");
    }
}
