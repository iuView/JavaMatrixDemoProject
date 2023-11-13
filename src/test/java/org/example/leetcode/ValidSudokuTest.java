package org.example.leetcode;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidSudokuTest {

    ValidSudoku testclass = new ValidSudoku();

    @Test
    void isValidSudoku() {
        char[] row1 = {'8', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] row2 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] row3 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] row4 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};

        char[] row5 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] row6 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] row7 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] row8 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        char[] row9 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};


        char[][] board = new char[][]{
                row1, row2, row3, row4, row5, row6, row7, row8, row9
        };
        boolean retval = testclass.isValidSudoku(board);
        assertThat(retval).isFalse();
    }

    @Test
    void isValidSudoku2() {
        char[] row1 = {'.', '.', '4', '.', '.', '.', '6', '3', '.'};
        char[] row2 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row3 = {'5', '.', '.', '.', '.', '.', '.', '9', '.'};
        char[] row4 = {'.', '.', '.', '5', '6', '.', '.', '.', '.'};

        char[] row5 = {'4', '.', '3', '.', '.', '.', '.', '.', '1'};
        char[] row6 = {'.', '.', '.', '7', '.', '.', '.', '.', '.'};
        char[] row7 = {'.', '.', '.', '5', '.', '.', '.', '.', '.'};
        char[] row8 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};

        char[] row9 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};


        char[][] board = new char[][]{
                row1, row2, row3, row4, row5, row6, row7, row8, row9
        };
        boolean retval = testclass.isValidSudoku(board);
        assertThat(retval).isFalse();
    }

    @Test
    void isValidSudoku3() {
        char[] row1 = {'5','3','.','.','7','.','.','.','.'};
        char[] row2 = {'6','.','.','1','9','5','.','.','.'};
        char[] row3 = {'.','9','8','.','.','.','.','6','.'};
        char[] row4 = {'8','.','.','.','6','.','.','.','3'};

        char[] row5 = {'4','.','.','8','.','3','.','.','1'};
        char[] row6 = {'7','.','.','.','2','.','.','.','6'};
        char[] row7 = {'.','6','.','.','.','.','2','8','.'};
        char[] row8 = {'.','.','.','4','1','9','.','.','5'};

        char[] row9 = {'.','.','.','.','8','.','.','7','9'};


        char[][] board = new char[][]{
                row1, row2, row3, row4, row5, row6, row7, row8, row9
        };
        boolean retval = testclass.isValidSudoku(board);
        assertThat(retval).isTrue();
    }
}