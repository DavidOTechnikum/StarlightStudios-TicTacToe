package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.currentPlayer = ticTacToe.player1;
        int row;
        int col;

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

        scanner.close();
    }

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
