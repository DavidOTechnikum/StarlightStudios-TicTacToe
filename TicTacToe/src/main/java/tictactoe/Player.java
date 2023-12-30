package tictactoe;

public class Player {
    char marker;

    Player(char marker) {
        this.marker = marker;
    }

    /**
     * Getter method for player's marker symbol (char).
     *
     * @return marker
     */
    char getMarker() {
        return marker;
    }
}