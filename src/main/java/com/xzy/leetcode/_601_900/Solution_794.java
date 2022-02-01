package com.xzy.leetcode._601_900;

/**
 * 二分查找
 * User: RuzzZZ
 * Date: 2022/1/30
 * Time: 14:43
 */
public class Solution_794 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
