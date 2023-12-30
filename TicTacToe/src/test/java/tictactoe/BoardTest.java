package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    // isCellEmpty()
    @Test
    void isCellEmpty_empty_cell() {
        int row = 0;
        int col = 0;

        assertEquals(Board.TRUE, board.isCellEmpty(row, col));
        assertEquals(Board.TRUE, board.isCellEmpty(row+1, col+1));
        assertEquals(Board.TRUE, board.isCellEmpty(row+2, col+2));
    }

    @Test
    void isCellEmpty_full_cell() {
        int row = 0;
        int col = 0;
        char marker = 'x';
        board.place(row,col,marker);
        board.place(row+1, col+1, marker);
        board.place(row+2, col+2, marker);

        assertEquals(Board.FALSE, board.isCellEmpty(row, col));
        assertEquals(Board.FALSE, board.isCellEmpty(row+1, col+1));
        assertEquals(Board.FALSE, board.isCellEmpty(row+2, col+2));
    }

    @Test
    void isCellEmpty_out_of_bounds() {
        int valid = 0;

        assertEquals(Board.EXCEPTION, board.isCellEmpty(-1,valid));
        assertEquals(Board.EXCEPTION, board.isCellEmpty(valid, -1));
        assertEquals(Board.EXCEPTION, board.isCellEmpty(3, 3));
        assertEquals(Board.EXCEPTION, board.isCellEmpty(-1, -1));
        assertEquals(Board.EXCEPTION, board.isCellEmpty(Integer.MAX_VALUE, valid));
        assertEquals(Board.EXCEPTION, board.isCellEmpty(valid, Integer.MAX_VALUE));
        assertEquals(Board.EXCEPTION, board.isCellEmpty(Integer.MIN_VALUE, valid));
        assertEquals(Board.EXCEPTION, board.isCellEmpty(valid, Integer.MIN_VALUE));
    }


    //place()
    @Test
    void place_empty_board() {
        int row = 0;
        int col = 0;
        char marker = 'x';

        assertTrue(board.place(row, col, marker));
        assertTrue(board.place(row+1, col+1, marker));
        assertTrue(board.place(row+2, col+2, marker));
    }

    @Test
    void place_full_cell() {
        int row = 0;
        int col = 0;
        char markerx = 'x';
        char markero = 'o';

        board.place(row, col, markerx);
        board.place(row+1, col+1, markerx);
        board.place(row+2, col+2, markerx);

        assertFalse(board.place(row, col, markero));
        assertFalse(board.place(row+1, col+1, markero));
        assertFalse(board.place(row+2, col+2, markero));
    }

    @Test
    void place_input_out_of_bounds() {
        int valid = 0;
        char marker = 'x';

        assertFalse(board.place(-1, valid, marker));
        assertFalse(board.place(valid, -1, marker));
        assertFalse(board.place(3, valid, marker));
        assertFalse(board.place(valid, 3, marker));
        assertFalse(board.place(Integer.MIN_VALUE, valid, marker));
        assertFalse(board.place(valid, Integer.MIN_VALUE, marker));
        assertFalse(board.place(Integer.MIN_VALUE, Integer.MAX_VALUE, marker));
    }

    //isFull()

    @Test
    void isFull_empty_board() {
        assertFalse(board.isFull());
    }

    @Test
    void isFull_all_but_one() {
        char markerx = 'x';
        char markero = 'o';
        board.place(0,0,markerx);
        board.place(0,1,markero);
        board.place(0,2,markerx);
        board.place(1,0,markero);
        board.place(1,1,markero);
        board.place(1,2,markerx);
        board.place(2,0,markerx);
        board.place(2,1,markerx);

        assertFalse(board.isFull());
    }

    @Test
    void isFull_full_one_marker() {
        char marker = 'x';
        for (int i = 0; i < Board.MAX; i++) {
            for(int j = 0; j < Board.MAX; j++) {
                board.place(i, j, marker);
            }
        }

        assertTrue(board.isFull());
    }

    @Test
    void isFull_full_two_markers() {
        char markerx = 'x';
        char markero = 'o';
        board.place(0,0,markerx);
        board.place(0,1,markero);
        board.place(0,2,markerx);
        board.place(1,0,markero);
        board.place(1,1,markero);
        board.place(1,2,markerx);
        board.place(2,0,markerx);
        board.place(2,1,markerx);
        board.place(2,2,markero);

        assertTrue(board.isFull());
    }







}
