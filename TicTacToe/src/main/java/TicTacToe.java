public class TicTacToe {
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe() {}

    void start() {
        board = new Board();
    }

    void switchCurrentPlayer() {
        if(currentPlayer == player1) {
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
        } else if (board.cells[0][2] != ' ' && board.cells[0][2] == board.cells[1][1] && board.cells[0][2] == board.cells[2][0]) {
            return true;
        } else {
            return false;
        }
    }

}
