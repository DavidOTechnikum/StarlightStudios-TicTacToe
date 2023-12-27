public class Main{
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Board board = new Board();
        Player player1 = new Player('X');
        Player player2 = new Player('O');
        game.start(player1, player2, game);
    }
}
