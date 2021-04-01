package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-03-30
 */
public class Solution_714 {

    public static void main(String[] args) {
        int[] prices = {1, 3, 7, 5, 10, 3};
        System.out.println(maxProfit2(prices, 3));
    }

    /**
     * dp(k,n) = max(dp(k,n-1) ,max(dp(k-1,n-1)+a[n]-a[j]))
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy = -prices[0];   //前k-1次交易剩余的钱
        int sell = 0;           //前k次交易剩余的钱
        for (int i = 1; i < prices.length; i++) {
            int tmpBuy = buy;
            buy = Math.max(buy, sell - prices[i]);
            //sell分两种，一种是本次不交易dp(k,n-1)，另一种是本次交易
            sell = Math.max(sell, tmpBuy + prices[i] - fee);
        }
        return sell;
    }

    /**
     * 0代表没有持有股票；1代表持有一支股票
     * dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]−fee}
     * dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
     */
    public static int maxProfit2(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
