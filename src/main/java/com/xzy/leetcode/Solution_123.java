package com.xzy.leetcode;

import java.util.Arrays;

/**
 * @author xiazhengyue
 * @since 2021-03-24
 */
public class Solution_123 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};       //4 check
        int[] nums = {3, 3, 5, 0, 0, 3, 1, 4};       //6 check
//        int[] nums = {7,6,4,3,1};       //0 check
//        int[] nums = {1};       //0 check
        System.out.println(maxProfit__(nums));
    }

    /**
     * dp(k,i) = max[dp(k,i-1),max(a[i]-a[j] + dp(k-1,j-1))]--> 其中j=[0..i-1]
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length];
        //根据第一层计算出第二层、第三层,dp二维数组第一层全为0(0次交易，所以收益全为0),所以直接从第二层算起
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < prices.length; i++) {
                //计算前i个元素在k次交易中的能拿到的最大收益
                int total = 0;
                for (int j = 0; j <= i; j++) {
                    int price = (j - 1) < 0 ? 0 : dp[k - 1][j - 1];
                    total = Math.max(price + prices[i] - prices[j], total);
                }
                dp[k][i] = Math.max(dp[k][i - 1], total);
            }
        }
        return dp[2][prices.length - 1];
    }

    /**
     * 调整加减法
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++) {
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                }
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][prices.length - 1];
    }

    /**
     * 去掉重复的min运算
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][prices.length - 1];
    }

    /**
     * 用min[]保存每次交易中最小的min
     *
     * @param prices
     * @return
     */
    public static int maxProfit4(int[] prices) {
        int[][] dp = new int[3][prices.length];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min[k]);
            }
        }
        return dp[2][prices.length - 1];
    }

    public static int maxProfit__(int[] prices) {
        int oneBuyOneSell = 0, twoBuyTwoSell = 0;
        int oneBuy = Integer.MAX_VALUE, twoBuy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //取一次购买最低价格
            oneBuy = Math.min(oneBuy, prices[i]);
            //得到一次购买的最大收益
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] - oneBuy);
            //一次交易+一次购买的 最少成本
            twoBuy = Math.min(twoBuy, prices[i] - oneBuyOneSell);
            //两次交易的最大收益
            twoBuyTwoSell = Math.max(twoBuyTwoSell, prices[i] - twoBuy);
        }
        return twoBuyTwoSell;
    }

}
