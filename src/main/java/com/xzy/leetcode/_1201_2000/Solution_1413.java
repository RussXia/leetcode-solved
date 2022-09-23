package com.xzy.leetcode._1201_2000;

/**
 * User: RuzzZZ
 * Date: 2022/8/9
 * Time: 16:20
 */
public class Solution_1413 {

    public static void main(String[] args) {
        int[] nums = {-3,2,-3,4,2};
        System.out.println(minStartValue(nums));
    }

    public static int minStartValue(int[] nums) {
        int minSum = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum);
        }
        if (minSum >= 0) {
            return 1;
        } else {
            return 1 - minSum;
        }
    }
}
