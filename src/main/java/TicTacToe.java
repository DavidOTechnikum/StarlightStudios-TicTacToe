public class TicTacToe {
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe() {

    }

    boolean hasWinner() {
        if (board.cells[0][0] == board.cells[0][1] && board.cells[0][1] == board.cells[0][2] && board.cells[0][0] != ' ') {
            return true;
        }
        if (board.cells[1][0] == board.cells[1][1] && board.cells[1][1] == board.cells[1][2] && board.cells[1][0] != ' ') {
            return true;
        }
        if (board.cells[2][0] == board.cells[2][1] && board.cells[2][1] == board.cells[2][2] && board.cells[2][0] != ' ') {
            return true;
        }
        if (board.cells[0][0] == board.cells[1][0] && board.cells[1][0] == board.cells[2][0] && board.cells[0][0] != ' ') {
            return true;
        }
        if (board.cells[0][1] == board.cells[1][1] && board.cells[1][1] == board.cells[2][1] && board.cells[0][1] != ' ') {
            return true;
        }
        if (board.cells[0][2] == board.cells[1][2] && board.cells[1][2] == board.cells[2][2] && board.cells[0][2] != ' ') {
            return true;
        }
        if (board.cells[0][0] == board.cells[1][1] && board.cells[1][1] == board.cells[2][2] && board.cells[0][0] != ' ') {
            return true;
        }
        return board.cells[0][2] == board.cells[1][1] && board.cells[1][1] == board.cells[2][0] && board.cells[0][2] != ' ';
    }
    void switchCurrentPlayer() {

        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
    void start(Player player1, Player player2, TicTacToe game) {
        Board board = new Board();
        Player currentPlayer = player2;
        board.print();
        while (!game.hasWinner()) {
            game.switchCurrentPlayer();
            System.out.println("Player " + currentPlayer.getMarker() + " turn");
            board.print();

        }
    }
}
