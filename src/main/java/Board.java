public class Board {
    char[][] cells;
    Board() {
        cells = new char[3][3];
    }
    void print() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }
    boolean isFull() {
        return false;
    }
    void clear() {
        cells = new char[3][3];
    }
    void place(int row, int col, char marker) {
        cells[row][col] = marker;
    }
    int isCellEmpty(int row, int col) {
        if (cells[row][col] == ' ') {
            return 0;
        } else {
            return 1;
        }
    }
}
