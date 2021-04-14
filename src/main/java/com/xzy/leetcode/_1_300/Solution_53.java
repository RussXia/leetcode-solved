package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-04-02
 */
public class Solution_53 {

    public static void main(String[] args) {
        Solution_53 solution = new Solution_53();
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {5,4,-1,7,8};
//        int[] nums = {1};
//        int[] nums = {-1,-2,-3,-4,-5};
//        int[] nums = {-5, -4, -2, -1, -7, -9};
        System.out.println(solution.maxSubArray(nums));
        System.out.println(solution.maxSubArray2(nums));
    }

    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    /**
     * 1.先从nums中所有的正整数遍历
     * 2.累计sum，sum<0则丢弃
     * 3.保留下最大的sum和
     * 4.返回最大的sum
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxSum) {
                maxSum = nums[i];
            }
            sum += nums[i];
            if (sum <= 0) {
                sum = 0;
                continue;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
