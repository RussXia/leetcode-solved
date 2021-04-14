package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-04-02
 */
public class Solution_198 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 6, 1};
        System.out.println(rob(nums));
    }

    /**
     * dp(i) = max(dp(i-1),dp(i-2)+nums[i])
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //pre--->dp(i-2);   next--->dp(i-1);
        int pre = nums[0], next = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max((pre + nums[i]), next);
            pre = next;
            next = temp;
        }
        return next;
    }
}
