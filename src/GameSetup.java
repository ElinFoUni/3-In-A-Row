/*This class draws the playing grid, I put made class just in case I wanted to be able to
make the grid larger at some point. I updated it to check the validity of the player moves on the board.*/
public class GameSetup {
    private char[][] board; // Two-dimensional array declared

    // The constructor, for now it's a 3x3 grid:
    public GameSetup() {
        board = new char[3][3];
        // For loop that will run as many times as the grid has rows (for now only 3)
        for (int i = 0; i < board.length; i++) {

        }
    }

    // bool method which checks if the player has placed their mark outside the grid and if the spot is already occupied
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length && board[row][col] == ' ';
    }

    // move method,,,


}
