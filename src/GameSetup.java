/*This class draws the playing grid, I put made class just in case I wanted to be able to
make the grid larger at some point. I updated it to check the validity of the Player moves on the board.*/
public class GameSetup {
    char[] board = new char[9];

    public GameSetup() {
        populateBoard();
    }

    public void populateBoard() {
        // Populate the array
        for (int i = 0; i < board.length; i++) {
                board[i] = (char) ('0' + (i + 1));
        }
    }

    public void printBoard() {
        System.out.println("|---|---|---|");
        for (int i = 0; i < board.length; i++) {
            if (i == 0 || i == 3 || i == 6) {
                System.out.print("| ");
            }
            System.out.print(board[i]);
            System.out.print(" | ");

            if ((i + 1) % 3 == 0) {
                System.out.println("\n" + "|---|---|---|");
            }

        }

    }



   /* // bool method which checks if the Player has placed their mark outside the grid and if the spot is already occupied
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length && board[row][col] == ' ';
    }
*/


    // move method,,,


}
