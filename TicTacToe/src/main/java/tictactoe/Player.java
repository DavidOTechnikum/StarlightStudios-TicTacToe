package tictactoe;

/**
 * Class for Player
 * Player is a player in TicTacToe
 * methods:
 * getMarker() - returns player's marker
 */
public class Player {
    char marker;

    Player(char marker) {
        this.marker = marker;
    }

    /**
     * Getter method for player's marker symbol x or o (char).
     *
     * @return marker
     */
    char getMarker() {
        return marker;
    }
}