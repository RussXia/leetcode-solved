package com.xzy.interview;

public class LeetCode_134 {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new LeetCode_134().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remain = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            remain[i] = gas[i] - cost[i];
        }
        int minSpare = Integer.MAX_VALUE;
        int index = -1;
        int spare = 0;
        for (int i = 0; i < remain.length; i++) {
            spare += remain[i];
            if (spare < 0) {
                if (minSpare > spare) {
                    minSpare = spare;
                    index = i;
                }
            }
        }
        if (spare < 0) {
            return -1;
        }
        return minSpare >= 0 ? 0 : index + 1;
    }
}
