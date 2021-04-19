package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-04-19
 */
public class Solution_27 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j; ) {
            if (nums[j] == val) {
                j--;
                continue;
            }
            if (nums[i] != val) {
                i++;
                continue;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
//        System.out.println(JSON.toJSON(nums));
        return j + 1;
    }
}
