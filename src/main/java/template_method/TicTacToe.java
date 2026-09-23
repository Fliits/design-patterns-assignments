package template_method;

import java.util.Scanner;

public class TicTacToe extends Game{

    private Scanner input = new Scanner(System.in);
    private char[][] board;
    private int numberOfTurns;
    private boolean player1wins;
    private boolean player2wins;

    private void ticTacToe(){
        initializeGame(2);
        int playerInTurn = 0;
        while (!endOfGame()) {
            playSingleTurn(playerInTurn);
            playerInTurn = ++playerInTurn % 2;
        }
        displayWinner();
    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        //NOTE: there can be only 2 players in tic-tac-toe, so we will ignore the numberOfPlayers parameter
        //make a new 3 by 3 ASCII board
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        System.out.println("  |   |  ");
        System.out.println("---------");
        System.out.println("  |   |  ");
        System.out.println("---------");
        System.out.println("  |   |  ");
    }

    @Override
    public boolean endOfGame() {
        if (numberOfTurns == 9) {
            return true;
        }
        if (player1wins || player2wins) {
            return true;
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        //player chooses a position on the board to place their mark (X for player 1 or O for player 2)
        if (player == 0) {
            System.out.println("Player 1's turn (X): ");
        } else {
            System.out.println("Player 2's turn (O): ");
        }
        // Read the player's input and update the board, unless that spot is already taken, in which case ask the player to choose again
        while (true) {
            System.out.println("Enter the row and column (0-2) to place your mark: ");
            int row = input.nextInt();
            if (row < 0 || row > 2) {
                System.out.println("Invalid row. Please enter a number between 0 and 2.");
                continue;
            }
            int col = input.nextInt();
            if (col < 0 || col > 2) {
                System.out.println("Invalid column. Please enter a number between 0 and 2.");
                continue;
            }
            if (board[row][col] == ' ') {
                if (player == 0) {
                    board[row][col] = 'X';
                } else {
                    board[row][col] = 'O';
                }
                break;
            } else {
                System.out.println("That spot is already taken. Please choose another.");
            }
        }

        // Display the updated board
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
        System.out.println("---------");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
        System.out.println("---------");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");

        //check if the current player has won the game by getting 3 in a row, column, or diagonal
        if (player == 0) {
            if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||
                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||
                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) {
                player1wins = true;
            }
        } else {
            if ((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||
                (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
                (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||
                (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
                (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {
                player2wins = true;
            }
        }
        //turn ends, increment the number of turns
        numberOfTurns++;
    }

    @Override
    public void displayWinner() {
        if (player1wins) {
            System.out.println("Player 1 wins!");
        } else if (player2wins) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie! Everyone loses!");
        }
    }
}
