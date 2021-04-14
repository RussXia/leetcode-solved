package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-04-07
 */
public class Solution_62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 3));
    }

    /**
     * dp(m,n) = dp(m-1,n) + dp(m,n-1)
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] ;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
