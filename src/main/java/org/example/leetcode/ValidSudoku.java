package org.example.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
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
