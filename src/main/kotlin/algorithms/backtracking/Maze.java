package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
//        System.out.println(count(3, 3));
//        path("", 3, 3);
//        System.out.println(pathRet("", 3, 3));
//        System.out.println(pathRetDiagonal("", 3, 3));
//        pathObstacle("", maze, 0, 0);
//        pathBacktracking("", maze, 0, 0);
        printBacktracking("", maze, 0, 0, path, 1);
    }

    // Counting the number of possible paths from beginning till end for an n*n maze.
    // Only move right and/or down.
    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = count(r-1, c);
        int right = count(r, c-1);

        return left + right;
    }

    // Printing the possible paths from beginning till end for an n*n maze.
    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            path(p + 'D', r-1, c);
        }

        if (c > 1) {
            path(p + 'R', r, c-1);
        }
    }

    static List<String> pathRet(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        if (r > 1) {
            list.addAll(pathRet(p + 'D', r-1, c));
        }

        if (c > 1) {
            list.addAll(pathRet(p + 'R', r, c-1));
        }

        return list;
    }

    //Allow diagonal moves.
    static List<String> pathRetDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        if (r > 1 && c > 1) {
            list.addAll(pathRetDiagonal(p + 'D', r-1, c-1)); // D for diagonal
        }

        if (r > 1) {
            list.addAll(pathRetDiagonal(p + 'V', r-1, c)); // V for vertical
        }

        if (c > 1) {
            list.addAll(pathRetDiagonal(p + 'H', r, c-1)); // H for horizontal
        }

        return list;
    }

    static void pathObstacle(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length -1 && c == maze[0].length-1) {
            System.out.println(p);
            return;
        }

        if (maze[r][c] == false) {
            return;
        }

        if (r < maze.length -1) {
            pathObstacle(p + 'D', maze, r+1, c);
        }

        if (c < maze[0].length-1) {
            pathObstacle(p + 'R', maze, r, c+1);
        }
    }

    //Showing all possible path going orthogonally

    static void pathBacktracking(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length -1 && c == maze[0].length-1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        //blocking the current path
        maze[r][c] = false;

        if (r < maze.length -1) {
            pathBacktracking(p + 'D', maze, r+1, c);
        }

        if (c < maze[0].length-1) {
            pathBacktracking(p + 'R', maze, r, c+1);
        }

        if (r > 0) {
            pathBacktracking(p + 'U', maze, r-1, c);
        }

        if (c > 0) {
            pathBacktracking(p + 'L', maze, r, c-1);
        }

        //reverse the alterations made
        maze[r][c] = true;
    }

    static void printBacktracking(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length -1 && c == maze[0].length-1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        //blocking the current path
        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length -1) {
            printBacktracking(p + 'D', maze, r+1, c, path, step+1);
        }

        if (c < maze[0].length-1) {
            printBacktracking(p + 'R', maze, r, c+1, path, step+1);
        }

        if (r > 0) {
            printBacktracking(p + 'U', maze, r-1, c, path, step+1);
        }

        if (c > 0) {
            printBacktracking(p + 'L', maze, r, c-1, path, step+1);
        }

        //reverse the alterations made
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
