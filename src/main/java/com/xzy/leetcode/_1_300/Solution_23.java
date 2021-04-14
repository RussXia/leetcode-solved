package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2019-11-01
 */
public class Solution_23 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicates(nums);
        System.out.println(result);
        System.out.println("========================================");
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int flag = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            nums[flag] = nums[i + 1];
            flag++;
        }
        return flag;
    }
}
