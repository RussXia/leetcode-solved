package com.xzy.leetcode._1201_2000;

/**
 * User: RuzzZZ
 * Date: 2023/5/8
 * Time: 17:49
 */
public class Solution_1572 {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0, j = mat.length - 1; i <= j; i++, j--) {
            if (i == j) {
                sum += mat[i][j];
                continue;
            }
            sum += mat[i][i];
            sum += mat[i][j];
            sum += mat[j][i];
            sum += mat[j][j];
        }
        return sum;
    }
}
