import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTest {
    TicTacToe ticTacToe;

    @BeforeEach
    void setup() {
        ticTacToe = new TicTacToe();
        ticTacToe.board = new Board();
    }

    //hasWinner()
    @Test
    void hasWinner_full_row0() {
        char marker = 'x';
        ticTacToe.board.place(0,0, marker);
        ticTacToe.board.place(0, 1, marker);
        ticTacToe.board.place(0,2, marker);

        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void hasWinner_full_row2() {
        char marker = 'x';
        ticTacToe.board.place(2,0, marker);
        ticTacToe.board.place(2,1, marker);
        ticTacToe.board.place(2,2, marker);

        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void hasWinner_full_column1() {
        char marker = 'x';
        ticTacToe.board.place(0,1, marker);
        ticTacToe.board.place(1,1, marker);
        ticTacToe.board.place(2, 1, marker);

        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void hasWinner_across00() {
        char marker = 'x';
        ticTacToe.board.place(0,0, marker);
        ticTacToe.board.place(1,1, marker);
        ticTacToe.board.place(2,2, marker);

        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void hasWinner_across02() {
        char marker = 'x';
        ticTacToe.board.place(0,2, marker);
        ticTacToe.board.place(1,1, marker);
        ticTacToe.board.place(2,0, marker);

        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void hasWinner_empty_board() {
        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void hasWinner_two_in_a_row() {
        char marker = 'x';
        ticTacToe.board.place(0,0, marker);
        ticTacToe.board.place(0, 2, marker);

        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void hasWinner_two_in_a_column() {
        char marker = 'x';
        ticTacToe.board.place(0, 1, marker);
        ticTacToe.board.place(2, 1, marker);

        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void hasWinner_different_markers() {
        char markerx = 'x';
        char markero = 'o';
        ticTacToe.board.place(1, 0, markerx);
        ticTacToe.board.place(1, 1, markero);
        ticTacToe.board.place(1,2, markerx);

        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void hasWinner_full_board_different_markers() {
        char markerx = 'x';
        char markero = 'o';
        ticTacToe.board.place(0,0,markerx);
        ticTacToe.board.place(0,1,markero);
        ticTacToe.board.place(0,2,markerx);
        ticTacToe.board.place(1,0,markero);
        ticTacToe.board.place(1,1,markero);
        ticTacToe.board.place(1,2,markerx);
        ticTacToe.board.place(2,0,markerx);
        ticTacToe.board.place(2,1,markerx);
        ticTacToe.board.place(2,2,markero);

        assertFalse(ticTacToe.hasWinner());
    }
}
