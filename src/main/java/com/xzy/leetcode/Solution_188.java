package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-03-25
 */
public class Solution_188 {

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][prices.length];
        int len = prices.length;
        //不限制次数时，贪婪每次的收益
        if (k >= len / 2) {
            return quickSolve(prices);
        }

        for (int i = 1; i <= k; i++) {
            int maxTemp = -prices[0];
            for (int j = 1; j < len; j++) {
                //maxTemp +  price[j] ===> 前j-1天进行i-1次交易，第j天卖出
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxTemp);
                maxTemp = Math.max(maxTemp, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }

    public static int maxProfit2(int m, int[] prices) {
        int len = prices.length;
        //不限制次数时，贪婪每次的收益
        if (m >= len / 2) {
            return quickSolve(prices);
        }
        //
        int[][] dp = new int[m + 1][len];
        for (int k = 1; k <= m; k++) {
            for (int i = 1; i < prices.length; i++) {
                int maxSecond = 0 - prices[0];   //dp[k - 1][0] ==0
                for (int j = 1; j <= i - 1; j++) {
                    maxSecond = Math.max(dp[k - 1][j] - prices[j], maxSecond);
                }
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] + maxSecond);
            }
        }
        return dp[m][len - 1];
    }

    public static int maxProfit3(int k, int[] prices) {
        int len = prices.length;
        //不限制次数时，贪婪每次的收益
        if (k >= len / 2) {
            return quickSolve(prices);
        }
        //
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }

    private static int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

}
