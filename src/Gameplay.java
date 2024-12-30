// This class handles the core loop of the game
import java.util.Random; // So that the computer can randomize an answer

public class Gameplay {

    Player p1 = new Player();
    Player p2 = new Player();
    AI computer = new AI();
    GameSetup board = new GameSetup();
    boolean gameOver = false;
    int player1Score = p1.score;
    int player2Score = p2.score;
    int AIScore = AI.score;


    public void vsHuman(String p1Name, String p2Name) {
        p1.name = p1Name;
        p2.name = p2Name;

        while (!gameOver) {
            p1Round();
            p2Round();
        }
    }

    public void vsComputer(String p1Name) {
        p1.name = p1Name;

        while (!gameOver) {
            p1Round();
            computerRound();
        }
    }

    public void p1Round() {
        if (!checkGameOverHuman()) gameOver = true;
        System.out.println("" + p1.name + " where do you want to place your mark?" + "\n");
        board.printBoard();
        short move = validMove();
        int index = move - 1;
        board.board[index] = 'X';
        board.printBoard();
        if (!checkGameOverHuman()) gameOver = true;
    }

    public void p2Round() {
        if (!checkGameOverHuman()) gameOver = true;
        System.out.println("" + p2.name + " where do you want to place your mark?" + "\n");
        board.printBoard();
        short move = validMove();
        int index = move - 1;
        board.board[index] = 'O';
        board.printBoard();
        if (!checkGameOverHuman()) gameOver = true;

    }

    public void computerRound() {
        if (!checkGameOverAI()) gameOver = true;
        System.out.println(computer.name + " makes its move!");
        int randomMove;
        do {
            randomMove = (int) (Math.random() * 9);
        } while (board.board[randomMove] == 'X' || board.board[randomMove] == 'O');
        board.board[randomMove] = 'O';
        board.printBoard();
        if (!checkGameOverAI()) gameOver = true;
    }

    public boolean checkGameOverHuman() {
        if ((board.board[0] == 'X' && board.board[1] == 'X' && board.board[2] == 'X')
            || (board.board[3] == 'X' && board.board[4] == 'X' && board.board[5] == 'X')
            || (board.board[6] == 'X' && board.board[7] == 'X' && board.board[8] == 'X')
            || (board.board[0] == 'X' && board.board[3] == 'X' && board.board[6] == 'X')
            || (board.board[1] == 'X' && board.board[4] == 'X' && board.board[7] == 'X')
            || (board.board[2] == 'X' && board.board[5] == 'X' && board.board[8] == 'X')
            || (board.board[0] == 'X' && board.board[4] == 'X' && board.board[8] == 'X')
            || (board.board[2] == 'X' && board.board[4] == 'X' && board.board[6] == 'X')) {
            player1Score++;
            System.out.println(p1.name + " has won! You have now won: " + player1Score + "times!");
            System.out.println(p2.name + " has won: " + player2Score + "times." + "\n");
            return true;
        } else if ((board.board[0] == 'O' && board.board[1] == 'O' && board.board[2] == 'O')
                || (board.board[3] == 'O' && board.board[4] == 'O' && board.board[5] == 'O')
                || (board.board[6] == 'O' && board.board[7] == 'O' && board.board[8] == 'O')
                || (board.board[0] == 'O' && board.board[3] == 'O' && board.board[6] == 'O')
                || (board.board[1] == 'O' && board.board[4] == 'O' && board.board[7] == 'O')
                || (board.board[2] == 'O' && board.board[5] == 'O' && board.board[8] == 'O')
                || (board.board[0] == 'O' && board.board[4] == 'O' && board.board[8] == 'O')
                || (board.board[2] == 'O' && board.board[4] == 'O' && board.board[6] == 'O')) {
            player2Score++;
            System.out.println(p2.name + " has won! You have now won: " + player2Score + "times!" + "\n");
            System.out.println(p1.name + " has won: " + player1Score + "times." + "\n");
            return true;
        } else if (checkDraw()) {
            System.out.println("It's a draw!");
            return true;
        } else return false;
    }

    public boolean checkGameOverAI() {
        if ((board.board[0] == 'X' && board.board[1] == 'X' && board.board[2] == 'X')
                || (board.board[3] == 'X' && board.board[4] == 'X' && board.board[5] == 'X')
                || (board.board[6] == 'X' && board.board[7] == 'X' && board.board[8] == 'X')
                || (board.board[0] == 'X' && board.board[3] == 'X' && board.board[6] == 'X')
                || (board.board[1] == 'X' && board.board[4] == 'X' && board.board[7] == 'X')
                || (board.board[2] == 'X' && board.board[5] == 'X' && board.board[8] == 'X')
                || (board.board[0] == 'X' && board.board[4] == 'X' && board.board[8] == 'X')
                || (board.board[2] == 'X' && board.board[4] == 'X' && board.board[6] == 'X')) {
            player1Score++;
            System.out.println(p1.name + " has won! You have now won: " + player1Score + "times!");
            System.out.println(computer.name + " has won: " + AIScore + "times." + "\n");
            return true;
        } else if ((board.board[0] == 'O' && board.board[1] == 'O' && board.board[2] == 'O')
                || (board.board[3] == 'O' && board.board[4] == 'O' && board.board[5] == 'O')
                || (board.board[6] == 'O' && board.board[7] == 'O' && board.board[8] == 'O')
                || (board.board[0] == 'O' && board.board[3] == 'O' && board.board[6] == 'O')
                || (board.board[1] == 'O' && board.board[4] == 'O' && board.board[7] == 'O')
                || (board.board[2] == 'O' && board.board[5] == 'O' && board.board[8] == 'O')
                || (board.board[0] == 'O' && board.board[4] == 'O' && board.board[8] == 'O')
                || (board.board[2] == 'O' && board.board[4] == 'O' && board.board[6] == 'O')) {
            AIScore++;
            System.out.println(computer.name + " has won! You have now won: " + AIScore + "times!" + "\n");
            System.out.println(p1.name + " has won: " + player1Score + "times." + "\n");
            return true;
        } else if (checkDraw()) {
            System.out.println("It's a draw!");
            return true;
        } else return false;
    }


    public boolean checkDraw() {
        for (char c : board.board) {
            if (c == ' ') return true;
        }
        return false;
    }

    private short validMove() {
        short move = InputValidator.numberSelection();
        int index = move - 1;
        while (move < 1 || move > 9 || board.board[index] == 'X' || board.board[index] == 'O') {
            if (move < 1 || move > 9) {
                System.out.println("Invalid move, try again!");
            } else {
                System.out.println("Spot is occupied, try again!");
            }
            move = InputValidator.numberSelection();
            index = move - 1;
        }
        return move;
    }

    // TODO Game Flow
        // Human Move
        // AI Move
        // Check valid move (empty, OOR)
    // TODO Check Win/Lose
    // TODO Check Draw

}
