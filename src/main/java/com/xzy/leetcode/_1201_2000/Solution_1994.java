package com.xzy.leetcode._1201_2000;

/**
 * User: RuzzZZ
 * Date: 2022/2/22
 * Time: 14:46
 */
public class Solution_1994 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution_1994 solution_1994 = new Solution_1994();
        System.out.println(solution_1994.numberOfGoodSubsets(nums));

    }

    /**
     * 去重没考虑！！！！！
     * @param nums
     * @return
     */
    public int numberOfGoodSubsets(int[] nums) {
        int[] dp = new int[nums.length];
        int count = 0;
        //第一列
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                dp[i] = nums[i] * (-1);
            } else if (isPrimeFactoring(nums[i])) {
                dp[i] = nums[i];
                count++;
            } else {
                dp[i] = nums[i];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (dp[i] > 0 && nums[j] == 1) {
                    dp[i] = dp[i] * -1;
                    count++;
                } else if (nums[j] != 1 && isPrimeFactoring(nums[j]) && isPrimeFactoring(Math.abs(dp[i]) * nums[j])) {
                    dp[i] = dp[i] * nums[j];
                    count++;
                }
            }
        }
        return count;
    }

    private static final long PRIME_PRODUCT = 6469693230L;

    public boolean isPrimeFactoring(int num) {
        return PRIME_PRODUCT % num == 0;
    }
}
