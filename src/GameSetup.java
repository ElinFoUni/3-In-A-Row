public class GameSetup {
    char[] board = new char[9];

    public GameSetup() {
        populateBoard();
    }

    public void populateBoard() {
        // Populates the array with numbers (used to place marks)
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
}
