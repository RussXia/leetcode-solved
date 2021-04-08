package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-04-07
 */
public class Solution_628 {

    public static void main(String[] args) {
        int[] nums = {-100, -98, -1, 2, 3, 4};
        System.out.println(maximumProduct(nums));
    }

    /**
     * 3 positive -> 3 largest (+)
     * 2 positive + 1 negative -> 1 largest (+) 2 smallest (-)
     * 1 positive + 2 negative -> 1 largest (+) 2 smallest (-)
     * 3 negative -> 3 largest (-)
     *
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }

            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min2 * min1);
    }
}
