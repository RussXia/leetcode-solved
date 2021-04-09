package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-04-09
 */
public class Solution_240 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 25));
    }

    /**
     * 从右上角遍历
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int row = 0, col = matrix[0].length - 1; row < matrix.length && col >= 0; ) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

}
