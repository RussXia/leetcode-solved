package com.xzy.leetcode._1_300;

public class Solution_80 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int fast = 1, slow = 1;
        int count = 0;
        while (fast < nums.length) {
            if (count > 0) {
                if (nums[fast] != nums[fast - 1]) {
                    count = 0;
                    nums[slow] = nums[fast];
                    slow++;
                } else {
                    count++;
                }
            } else {
                if (nums[fast] == nums[fast - 1]) {
                    count++;
                }
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
