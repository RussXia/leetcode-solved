package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-03-24
 */
public class Solution_121 {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxPrice = Integer.MIN_VALUE;
        int maxProfit = 0;
        for (int i = (prices.length - 1); i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
        }
        return maxProfit;
    }

}
