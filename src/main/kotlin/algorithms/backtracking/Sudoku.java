package algorithms.backtracking;

public class Sudoku {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {5, 3, 0, 0 ,7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9 ,5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0 ,3, 0, 0 ,1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0 ,5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if (solve(board)) {
            display(board);
        } else {
            System.out.println("not possible");
        }

    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) {
                break;
            }
        }

        if (emptyLeft) {
            return true;
        }

        for (int number = 1; number <=9 ; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static void display(int[][] board) {
        for (int[] row: board) {
            for (int num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int[][] board, int row, int col, int num) {
        //row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        //col
        for (int[] nums: board) {
            if (nums[col] == num) {
                return false;
            }
        }

        //block
        int sqrt = (int) (Math.sqrt(board.length));
        int Rstart = row - (row % sqrt);
        int Cstart = col - (col % sqrt);

        for (int r = Rstart; r < Rstart+sqrt; r++) {
            for (int c = Cstart; c < Cstart+sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
