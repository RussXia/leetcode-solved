package com.xzy.leetcode._301_600;

/**
 * @author xiazhengyue
 * @since 2021-03-30
 */
public class Solution_309 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    /**
     * 0-持有股票;1-不持有股票，且在冻结期;2-不持有股票，且不在冻结期
     * dp[i][0]=max{dp[i−1][0],dp[i−1][2]-prices[i]}
     * dp[i][1]=dp[i-1][0]+prices[i]
     * dp[i][2] = max{dp[i-1][2],dp[i-1][1]}
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
