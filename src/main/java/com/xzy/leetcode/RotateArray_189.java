package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-11-01
 */
public class RotateArray_189 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        rotate(nums, 3);

        int[] nums = {-1, -100, 3, 99};
        rotate(nums, 2);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotateOneStep(nums);
        }
    }

    private static void rotateOneStep(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int flag = nums[i];
            nums[i] = temp;
            temp = flag;
        }
        nums[0] = temp;
    }
}
