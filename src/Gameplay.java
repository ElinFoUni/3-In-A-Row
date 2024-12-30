// This class handles the core loop of the game
public class Gameplay {

        Player p1;
        Player p2;
        AI computer;
        GameSetup board = new GameSetup();
        boolean gameOver = false;
        String player1Name;
        String player2Name;
        String computerName;

        public Gameplay(Player p1, Player p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        public Gameplay(Player p1, AI computer) {
            this.p1 = p1;
            this.computer = computer;
        }




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

        public void p1Round() {
            System.out.println("" + p1.name + " where do you want to place your mark?" + "\n");
            board.printBoard();
            short move = validMove();
            int index = move - 1;
            board.board[index] = 'X';
            board.printBoard();

        }

        public void p2Round() {
            System.out.println("" + p2.name + " where do you want to place your mark?" + "\n");
            board.printBoard();
            short move = validMove();
            int index = move - 1;
            board.board[index] = 'O';
            board.printBoard();
        }

        public void computerRound() {
            System.out.println(computer.name + " makes its move!");
            int randomMove;
            do {
                randomMove = (int) (Math.random() * 9);
            } while (board.board[randomMove] == 'X' || board.board[randomMove] == 'O');
            board.board[randomMove] = 'O';
            board.printBoard();

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
                p1.score++;
                System.out.println(p1.name + " has won! You have now won: " + p1.score + "times!");
                System.out.println(p2.name + " has won: " + p2.score + "times." + "\n");
                return true;
            } else if ((board.board[0] == 'O' && board.board[1] == 'O' && board.board[2] == 'O')
                    || (board.board[3] == 'O' && board.board[4] == 'O' && board.board[5] == 'O')
                    || (board.board[6] == 'O' && board.board[7] == 'O' && board.board[8] == 'O')
                    || (board.board[0] == 'O' && board.board[3] == 'O' && board.board[6] == 'O')
                    || (board.board[1] == 'O' && board.board[4] == 'O' && board.board[7] == 'O')
                    || (board.board[2] == 'O' && board.board[5] == 'O' && board.board[8] == 'O')
                    || (board.board[0] == 'O' && board.board[4] == 'O' && board.board[8] == 'O')
                    || (board.board[2] == 'O' && board.board[4] == 'O' && board.board[6] == 'O')) {
                p2.score++;
                System.out.println(p2.name + " has won! You have now won: " + p2.score + "times!" + "\n");
                System.out.println(p1.name + " has won: " + p1.score + " times." + "\n");
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
                p1.score++;
                System.out.println(p1.name + " has won! You have now won: " + p1.score + " times!");
                System.out.println(computer.name + " has won: " + computer.score + " times." + "\n");
                return true;
            } else if ((board.board[0] == 'O' && board.board[1] == 'O' && board.board[2] == 'O')
                    || (board.board[3] == 'O' && board.board[4] == 'O' && board.board[5] == 'O')
                    || (board.board[6] == 'O' && board.board[7] == 'O' && board.board[8] == 'O')
                    || (board.board[0] == 'O' && board.board[3] == 'O' && board.board[6] == 'O')
                    || (board.board[1] == 'O' && board.board[4] == 'O' && board.board[7] == 'O')
                    || (board.board[2] == 'O' && board.board[5] == 'O' && board.board[8] == 'O')
                    || (board.board[0] == 'O' && board.board[4] == 'O' && board.board[8] == 'O')
                    || (board.board[2] == 'O' && board.board[4] == 'O' && board.board[6] == 'O')) {
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

        public boolean checkDraw() {
            for (char c : board.board) {
                if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5'
                    || c == '6' || c == '7' || c == '8'|| c == '9'){
                    return false;
                }
            }
            return true;
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
