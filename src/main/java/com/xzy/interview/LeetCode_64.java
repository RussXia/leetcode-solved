package com.xzy.interview;

import java.util.Arrays;

public class LeetCode_64 {

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid));
    }

    /**
     * dp[m,n] = Math.min(dp[m,n-1],dp[m-1,n]) + nums[m,n]
     * dp[0,0] = nums[0,0]
     */
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] nums : dp) {
            Arrays.fill(nums, Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];
        for (int m = 1; m < grid.length; m++) {
            dp[m][0] = dp[m - 1][0] + grid[m][0];
        }
        for (int n = 1; n < grid[0].length; n++) {
            dp[0][n] = dp[0][n - 1] + grid[0][n];
        }
        for (int m = 1; m < grid.length; m++) {
            for (int n = 1; n < grid[0].length; n++) {
                dp[m][n] = Math.min(dp[m][n - 1], dp[m - 1][n]) + grid[m][n];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
