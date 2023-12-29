public class Main{
    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.board = new Board();
//        board.place(0,2,'o');
//        board.place(1,1,'o');
//        board.place(2,0,'o');

//        board.place(0,0,'x');
//        board.place(0, 1, 'x');
//        board.place(1, 0, 'x');
//        board.place(1, 2, 'x');
//        board.place(2, 1, 'x');
//        board.place(2, 2, 'x');

        ticTacToe.board.place(0,0,'x');
        ticTacToe.board.place(0,1,'o');
        ticTacToe.board.place(0,2,'x');

        ticTacToe.board.print();
        if (ticTacToe.hasWinner()== true) {
            System.out.println("Winner");
        } else if (ticTacToe.hasWinner() == false) {
            System.out.println("no win");
        }

        ticTacToe.board.clear();
        ticTacToe.board.print();
    }
}
