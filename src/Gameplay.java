// This class handles the core loop of the game
public class Gameplay {

        Player p1;
        Player p2;
        AI computer;
        GameSetup board = new GameSetup();
        boolean gameOver = false;

        public Gameplay(Player p1, Player p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        public Gameplay(Player p1, AI computer) {
            this.p1 = p1;
            this.computer = computer;
        }

        // Handles multiplayer game-loop
        public void vsHuman() {

            while (!gameOver) {
                p1Round();

                if (checkGameOverHuman()) {
                    gameOver = true;
                    break;
                }

                p2Round();

                if (checkGameOverHuman()) {
                    gameOver = true;
                    break;
                }
            }
        }

        // Handles single player game-loop
        public void vsComputer() {
            while (!gameOver) {
                    p1Round();

                    if (checkGameOverAI()) {
                        gameOver = true;
                        break;
                    }

                    computerRound();

                    if (checkGameOverAI()) {
                        gameOver = true;
                        break;
                    }
            }
        }

        // player 1 round
        public void p1Round() {
            System.out.println(p1.name + ", where do you want to place your mark?" + "\n");
            board.printBoard();
            short move = validMove();
            int index = move - 1;
            board.board[index] = 'X';
            board.printBoard();

        }

        // player 2 round
        public void p2Round() {
            System.out.println("" + p2.name + " where do you want to place your mark?" + "\n");
            board.printBoard();
            short move = validMove();
            int index = move - 1;
            board.board[index] = 'O';
            board.printBoard();
        }

        // computer player chooses a random unoccupied spot
        public void computerRound() {
            System.out.println(computer.name + " makes its move!");
            int randomMove;
            do {
                randomMove = (int) (Math.random() * 9);
            } while (board.board[randomMove] == 'X' || board.board[randomMove] == 'O');
            board.board[randomMove] = 'O';
            board.printBoard();

        }

        // Checks single player game over status (win/draw)
        public boolean checkGameOverHuman() {
            if (checkXs()) {
                p1.score++;
                System.out.println(p1.name + " has won! You have now won: " + p1.score + " times!");
                System.out.println(p2.name + " has won: " + p2.score + " times." + "\n");
                return true;
            } else if (checkOs()) {
                p2.score++;
                System.out.println(p2.name + " has won! You have now won: " + p2.score + " times!" + "\n");
                System.out.println(p1.name + " has won: " + p1.score + " times." + "\n");
                return true;
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                return true;
            } else {
                return false;
            }
        }

        // Checks multiplayer game status
        public boolean checkGameOverAI() {
            if (checkXs()) {
                p1.score++;
                System.out.println(p1.name + " has won! You have now won: " + p1.score + " times!");
                System.out.println(computer.name + " has won: " + computer.score + " times." + "\n");
                return true;
            } else if (checkOs()) {
                computer.score++;
                System.out.println(computer.name + " has won! You have now won: " + computer.score + " times!" + "\n");
                System.out.println(p1.name + " has won: " + p1.score + " times." + "\n");
                return true;
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                return true;
            } else {
                return false;
            }
        }

        // Checks for a draw, used in buth SP and MP methods above
        public boolean checkDraw() {
            for (char c : board.board) {
                if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5'
                    || c == '6' || c == '7' || c == '8'|| c == '9'){
                    return false;
                }
            }
            return true;
        }

        // checks if a move is valid or not, or out of bounds
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

        private boolean checkXs() {
            return (board.board[0] == 'X' && board.board[1] == 'X' && board.board[2] == 'X')
                    || (board.board[3] == 'X' && board.board[4] == 'X' && board.board[5] == 'X')
                    || (board.board[6] == 'X' && board.board[7] == 'X' && board.board[8] == 'X')
                    || (board.board[0] == 'X' && board.board[3] == 'X' && board.board[6] == 'X')
                    || (board.board[1] == 'X' && board.board[4] == 'X' && board.board[7] == 'X')
                    || (board.board[2] == 'X' && board.board[5] == 'X' && board.board[8] == 'X')
                    || (board.board[0] == 'X' && board.board[4] == 'X' && board.board[8] == 'X')
                    || (board.board[2] == 'X' && board.board[4] == 'X' && board.board[6] == 'X');
        }

        private boolean checkOs() {
            return (board.board[0] == 'O' && board.board[1] == 'O' && board.board[2] == 'O')
                    || (board.board[3] == 'O' && board.board[4] == 'O' && board.board[5] == 'O')
                    || (board.board[6] == 'O' && board.board[7] == 'O' && board.board[8] == 'O')
                    || (board.board[0] == 'O' && board.board[3] == 'O' && board.board[6] == 'O')
                    || (board.board[1] == 'O' && board.board[4] == 'O' && board.board[7] == 'O')
                    || (board.board[2] == 'O' && board.board[5] == 'O' && board.board[8] == 'O')
                    || (board.board[0] == 'O' && board.board[4] == 'O' && board.board[8] == 'O')
                    || (board.board[2] == 'O' && board.board[4] == 'O' && board.board[6] == 'O');
        }
}
