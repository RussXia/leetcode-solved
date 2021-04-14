package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-04-08
 */
public class Solution_268 {

    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int expectSum = length * (length + 1) / 2;
        int actualSum = 0;
        for (int i = 0; i < length; i++) {
            actualSum += nums[i];
        }
        return expectSum - actualSum;
    }
}
