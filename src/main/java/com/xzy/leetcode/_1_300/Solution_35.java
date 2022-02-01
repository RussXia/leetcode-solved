package com.xzy.leetcode._1_300;

/**
 * 搜索插入位置
 * User: RuzzZZ
 * Date: 2022/2/1
 * Time: 01:01
 */
public class Solution_35 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, middle = 0;
        while (start <= end) {
            middle = (end - start) / 2 + start;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return nums[middle] > target ? middle : middle + 1;
    }
}
