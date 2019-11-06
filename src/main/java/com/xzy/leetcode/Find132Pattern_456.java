package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-09-30
 */
public class Find132Pattern_456 {

    public static void main(String[] args) {
//        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(find132pattern(arr1));

//        int[] arr2 = {1, 3, 2, 4, 5, 6, 7, 8, 9};
//        System.out.println(find132pattern(arr2));

        int[] arr3 = {1, 3, 2, 4};
        System.out.println(find132pattern(arr3));
    }

    public static boolean find132pattern(int[] nums) {
        for (int pos = 1; pos < nums.length - 1; pos++) {
            int min = findMinElement(nums, 0, pos);
            int max = findMaxElement(nums, pos + 1, nums.length);
            if (nums[pos] > max && max > min) {
                return true;
            }
        }
        return false;
    }

    public static int findMaxElement(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[start]) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int findMinElement(int[] nums, int start, int end) {
        int min = nums[start];
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[start]) {
                min = nums[i];
            }
        }
        return min;
    }

}
