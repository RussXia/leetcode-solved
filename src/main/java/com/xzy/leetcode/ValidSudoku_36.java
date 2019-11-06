package com.xzy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiazhengyue
 * @since 2019-11-05
 */
public class ValidSudoku_36 {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!dict.add(board[i][j] + "row" + i)
                            || !dict.add(board[i][j] + "col" + j)
                            || !dict.add(board[i][j] + "box-" + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
