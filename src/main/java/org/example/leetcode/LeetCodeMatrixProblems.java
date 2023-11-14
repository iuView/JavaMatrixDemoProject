package org.example.leetcode;

import java.util.*;

public class LeetCodeMatrixProblems {

    public int numIslands(char[][] grid) {
        List<List<Integer>> visited = new ArrayList<>();

        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    if (visited.contains(Arrays.asList(i, j)))
                        continue;
                    visited.add(Arrays.asList(i, j));
                    visitNeighbors(grid, i, j, visited);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    void visitNeighbors(char[][] grid, int x, int y, List<List<Integer>> visited) {
        // need to do BFS on all 4 directions of x, y
        // upper: x - 1, y
        // left: x, y - 1
        // right: x, y + 1
        // down: x + 1, y
        int row, col;
        row = x - 1;
        col = y;
        if (row >= 0 && grid[row][col] == '1') {
            if (!visited.contains(Arrays.asList(row, col))) {
                visited.add(Arrays.asList(row, col));
                visitNeighbors(grid, row, col, visited);
            }
        }
        row = x;
        col = y - 1;
        if (col >= 0 && grid[row][col] == '1') {
            if (!visited.contains(Arrays.asList(row, col))) {
                visited.add(Arrays.asList(row, col));
                visitNeighbors(grid, row, col, visited);
            }
        }

        row = x;
        col = y + 1;
        if (col <= grid[0].length - 1 && grid[row][col] == '1') {
            if (!visited.contains(Arrays.asList(row, col))) {
                visited.add(Arrays.asList(row, col));
                visitNeighbors(grid, row, col, visited);
            }
        }

        row = x + 1;
        col = y;
        if (row <= grid.length - 1 && grid[row][col] == '1') {
            if (!visited.contains(Arrays.asList(row, col))) {
                visited.add(Arrays.asList(row, col));
                visitNeighbors(grid, row, col, visited);
            }
        }

    }

    public boolean isValidSudoku(char[][] board) {
        boolean isvalid = true;

        Set<Character> set = new HashSet<>();

        // follow the sequence of the row:
        for (int i = 0; i < board.length; i++) { // row level
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;
                isvalid = set.add(board[i][j]);
                if (!isvalid)
                    return isvalid;
            }
            // reset rowSet
            set = new HashSet<>();
        }

        // follow the sequence of the column:
        for (int i = 0; i < board[0].length; i++) { // row level
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.')
                    continue;
                isvalid = set.add(board[j][i]);
                if (!isvalid)
                    return isvalid;
            }
            // reset rowSet
            set = new HashSet<>();
        }

        // for each square:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean val = processEachSquare(board, 3*i, 3*j);
                if (!val)
                    return val;
            }
        }


        return isvalid;
    }

    boolean processEachSquare(char[][] board, int rowStart, int colStart) {
        boolean isvalid = true;
        Set<Character> set = new HashSet<>();

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == '.')
                    continue;
                isvalid = set.add(board[i][j]);
                if (!isvalid)
                    return isvalid;
            }
        }
        return isvalid;
    }
}
