package com.xzy.leetcode._301_600;

/**
 * @author xiazhengyue
 * @since 2021-04-10
 */
public class Solution_329 {

    public static void main(String[] args) {
        Solution_329 solution = new Solution_329();

//        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
//        int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
//        int[][] matrix = {{1}};
        int[][] matrix = {{7, 7, 5}, {2, 4, 6}, {8, 2, 0}};
        System.out.println(solution.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] greater = new int[row][col];
        //初始化
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                greater[i][j] = -1;
            }
        }

        int maxLength = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int length = getLength(matrix, i, j, greater);
                greater[i][j] = length;
                if (greater[i][j] > maxLength) {
                    maxLength = greater[i][j];
                }
            }
        }
        return maxLength;

    }

    /**
     * [7,7,5]
     * [2,4,6]
     * [8,2,0]
     * @param matrix
     * @param i
     * @param j
     * @param greater
     * @return
     */
    private int getLength(int[][] matrix, int i, int j, int[][] greater) {
        int row = matrix.length;
        int col = matrix[0].length;

        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        if (greater[i][j] >= 0) {//如果该点已经计算过最长路径，直接返回结果
            return greater[i][j];
        }

        //计算上下左右四个点可以走的长度
        if (j < (col - 1) && matrix[i][j] < matrix[i][j + 1]) {
            right = getLength(matrix, i, j + 1, greater);
            greater[i][j + 1] = right;
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            left = getLength(matrix, i, j - 1, greater);
            greater[i][j - 1] = left;
        }
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            up = getLength(matrix, i - 1, j, greater);
            greater[i - 1][j] = up;
        }
        if (i < (row - 1) && matrix[i][j] < matrix[i + 1][j]) {
            down = getLength(matrix, i + 1, j, greater);
            greater[i + 1][j] = down;
        }
        return Math.max(Math.max(up, down), Math.max(left, right)) + 1;

    }

}
