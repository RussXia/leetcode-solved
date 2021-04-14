package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2019-11-01
 */
public class Solution_189 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        rotate3(nums, 3);
        System.out.println();
    }

    /**
     * 每次移动一格，连续移动n次，时间复杂度O(kn)，耗时
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k - (k / nums.length) * nums.length;
        }
        while (k > 0) {
            int temp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int second = nums[i];
                nums[i] = temp;
                temp = second;
            }
            nums[0] = temp;
            k--;
        }
    }

    /**
     * copy一份数据，然后直接移动k个,时间复杂度O(N)，耗空间
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        //取实际移动的最短距离
        k = k % nums.length;
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (i + k < nums.length) {
                nums[i + k] = copy[i];
            } else {
                nums[i + k - nums.length] = copy[i];
            }
        }
    }

    /**
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        //取实际移动的最短距离
        k = k % nums.length;
        //先反转整个数组
        reverse(nums, 0, nums.length - 1);
        //将前n个元素反转
        reverse(nums, 0, k - 1);
        //反转后面的元素
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转数组
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
