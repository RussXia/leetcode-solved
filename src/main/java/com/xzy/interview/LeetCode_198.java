package com.xzy.interview;

import java.util.Arrays;

public class LeetCode_198 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new LeetCode_198().rob(nums));
    }

    /**
     * nums.length = k
     * dp(k) = Math.max( dp(k-1),dp(k-2)+nums[k-1])
     * dp[0] = 0
     * dp[1] = nums[0]
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i-1]);
        }
        return dp[nums.length];
    }
}
