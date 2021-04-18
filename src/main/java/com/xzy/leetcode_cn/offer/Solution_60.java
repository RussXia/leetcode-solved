package com.xzy.leetcode_cn.offer;

import com.alibaba.fastjson.JSON;

/**
 * @author xiazhengyue
 * @since 2021-04-15
 */
public class Solution_60 {

    public static void main(String[] args) {
        Solution_60 solution = new Solution_60();
        System.out.println(JSON.toJSON(solution.dicesProbability(2)));
    }

    /**
     * dp[n][m] = (dp[n-1][m] + dp[n-1][m-1] + ... + dp[n-1][m-5]) * 0.16667
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        double probability = 1.0 / 6;

        double[][] dp = new double[n][];
        dp[0] = new double[6];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = probability;
        }
        for (int i = 1; i < n; i++) {
            dp[i] = new double[5 * n + 1];
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = calcProbability(dp, i, j);
            }
        }

        return dp[n - 1];
    }

    private double calcProbability(double[][] dp, int i, int j) {
        double basicProbability = 1.0 / 6;
        double _1 = (j >= 0 && j < dp[i - 1].length) ? dp[i - 1][j] : 0;
        double _2 = (j - 1 >= 0 && j - 1 < dp[i - 1].length) ? dp[i - 1][j - 1] : 0;
        double _3 = (j - 2 >= 0 && j - 2 < dp[i - 1].length) ? dp[i - 1][j - 2] : 0;
        double _4 = (j - 3 >= 0 && j - 3 < dp[i - 1].length) ? dp[i - 1][j - 3] : 0;
        double _5 = (j - 4 >= 0 && j - 4 < dp[i - 1].length) ? dp[i - 1][j - 4] : 0;
        double _6 = (j - 5 >= 0 && j - 5 < dp[i - 1].length) ? dp[i - 1][j - 5] : 0;
        return basicProbability * (_1 + _2 + _3 + _4 + _5 + _6);
    }
}
