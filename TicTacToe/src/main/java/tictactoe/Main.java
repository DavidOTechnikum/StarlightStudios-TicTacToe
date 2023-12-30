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
        int row;
        int col;
        boolean playAgain = true;


        while (playAgain) {

            do {
                System.out.println("It's Player " + ticTacToe.currentPlayer.getMarker() + "'s turn");
                ticTacToe.board.print();

                do {
                    System.out.println("row:");
                    row = inputCheck();

                    System.out.println("column:");
                    col = inputCheck();
                    System.out.println("_____\n");

                } while (!ticTacToe.board.place(row, col, ticTacToe.currentPlayer.getMarker()));

                ticTacToe.switchCurrentPlayer();

            } while (!ticTacToe.hasWinner() && !ticTacToe.board.isFull());

            if (ticTacToe.hasWinner()) {
                ticTacToe.switchCurrentPlayer();
                ticTacToe.board.print();
                System.out.println("Congratulations! Player " + ticTacToe.currentPlayer.getMarker() + " has won");
            } else if (ticTacToe.board.isFull()) {
                System.out.println("Oh darn, nobody has won");
            }
            ticTacToe.board.clear();

            System.out.println("\nWould you like to play again? (y - yes, n - no)");
            while (true) {
                String s = scanner.nextLine();
                if (s.equals("y")) {
                    ticTacToe.switchCurrentPlayer();
                    break;
                } else if (s.equals("n")) {
                    playAgain = false;
                    System.out.println("Thanks for playing!");
                    break;
                } else {
                    System.out.println("Invalid input, please try again");
                }
            }
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
}
