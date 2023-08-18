package algorithms.backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(knight(board, 0, 0, 4));
    }

    static int knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return 1;
        }
        if (row == board.length) {
            return 0;
        }
        int count = 0;

        if (col == board.length) {
            count += knight(board, row+1, 0, knights);
            return count;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += knight(board, row, col+1, knights-1);
            board[row][col] = false;
        }

        count += knight(board, row, col+1, knights);

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if(row == 0) {
            return true;
        }
        if(row > 1) {
            if (col > 0) {
                //lower right
                if (board[row-2][col-1]) {
                    return false;
                }
            }
            if (col < board.length-1) {
                //lower left
                if (board[row-2][col+1]) {
                    return false;
                }
            }
        }
        if (col < board.length-2) {
            //upper left
            if (board[row-1][col+2]) {
                return false;
            }
        }

        if (col > 1) {
            //upper right
            if (board[row-1][col-2]) {
                return false;
            }
        }

        return true;
    }

    static void display(boolean[][] board) {
        for (boolean[] row: board) {
            for (boolean element: row) {
                if (element) {
                    System.out.print("Kn ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
