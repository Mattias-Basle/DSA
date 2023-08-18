package JavaBasics;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = init();
        play(board);
    }

    static char[][] init() {
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '-';
            }
        }
        return board;
    }

    static void play(char[][] board) {
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while(!gameOver) {
            display(board);
            System.out.print("Palyer " + player + " enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == '-') {
                board[row][col] = player;
                gameOver = hasWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has won!!");
                    display(board);
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move");
            }
        }
    }

    private static boolean hasWon(char[][] board, char player) {
        //check row
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) return true;
        }
        //check col
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player) return true;
        }

        //check diagonals
        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) return true;

        if (board[2][0] == player &&
                board[1][1] == player &&
                board[0][2] == player) return true;

        return false;
    }

    static void display(char[][] board) {
        for (char[] row: board) {
            for (char ch: row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
