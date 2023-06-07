package com.xzy.leetcode._601_900;

/**
 * User: RuzzZZ
 * Date: 2023/5/25
 * Time: 10:28
 */
public class Solution_837 {

    public static void main(String[] args) {
        int n = 9811, k = 8890, maxPts = 7719;
        Solution_837 solution837 = new Solution_837();
        System.out.println(solution837.new21Game(n, k, maxPts));
    }

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1.0;
        int maxPoint = k + maxPts - 1;
        if (n > maxPoint) {
            return 0.0;
        }
        // n在[k,k+maxPts-1]之间,probability[]表示[k,k+maxPts-1]的概率
        double[] probability = new double[maxPoint + 1];
        probability[0] = 1;
        for (int i = 1; i <= maxPoint; i++) {
            for (int w = 1; w <= maxPts; w++) {
                if (i - w < 0) break;
                if (i - w >= 0 && i - w < k)
                    probability[i] += probability[i - w] * 1 / maxPts;
            }
        }
        double targetProbability = 0.0; // Probability of N or less points.
        for (int i = k; i <= n; i++) {
            targetProbability += probability[i];
        }
        return targetProbability;
    }
}
