package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-04-07
 */
public class Solution_152 {

    public static void main(String[] args) {
//        int[] nums = {-2, 2, 20, 3, -2, -3, 0, 3, 4};
        int[] nums = {-2,0,-1};
        System.out.println(maxProduct(nums));
    }

    /**
     * [-2,2,20,3,-2,-3,0,3,4]
     * 从左遍历一遍,然后从右遍历一遍，即可得到最大值
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int product = 1;
        int result = Integer.MIN_VALUE;
        //从左遍历一遍
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            result = Math.max(result, product);
            if (product == 0) {
                product = 1;
            }
        }
        product = 1;
        //从右遍历一遍
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            result = Math.max(result, product);
            if (product == 0) {
                product = 1;
            }
        }
        return result;
    }
}
