package com.xzy.leetcode._1201_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-04-01
 */
public class Solution_1582 {

    public static void main(String[] args) {

        Solution_1582 solution_1582 = new Solution_1582();

        int[][] mat = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(solution_1582.numSpecial(mat));
    }

    public int numSpecial(int[][] mat) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            if (sum == 1) {
                row.add(i);
            }
        }

        for (int i = 0; i < mat[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum += mat[j][i];
            }
            if (sum == 1) {
                col.add(i);
            }
        }
        int count = 0;
        for (Integer rowIndex : row) {
            for (Integer colIndex : col) {
                if (mat[rowIndex][colIndex] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
