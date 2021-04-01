package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-03-26
 */
public class Solution_746 {

    public static void main(String[] args) {
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] cost = {0, 2, 2, 1};
//        int[] cost = {0, 0, 1, 1};
        int[] cost = {0, 2, 3, 2};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int cost_0 = cost[0], cost_1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int minCost = Math.min(cost_0, cost_1) + cost[i];
            cost_0 = cost_1;
            cost_1 = minCost;
        }
        return Math.min(cost_0, cost_1);
    }
}
