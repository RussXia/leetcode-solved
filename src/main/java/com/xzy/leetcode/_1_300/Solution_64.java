package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-04-09
 */
public class Solution_64 {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3}, {4, 5, 6}, {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }

    /**
     * dp[m][n] = min(dp[m-1][n],dp[m][n-1]) + grid[m][n]
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < grid.length; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
