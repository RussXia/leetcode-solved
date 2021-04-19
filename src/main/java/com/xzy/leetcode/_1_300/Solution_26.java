package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-04-02
 */
public class Solution_26 {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        System.out.println(removeDuplicates3(nums1));
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates3(nums2));
    }

    public static int removeDuplicates3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++, i++) {
            nums[i] = nums[j];
            if (i > 0 && nums[i - 1] == nums[j]) {
                i -= 1;
            }
        }
        return i;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (temp != nums[i]) {
                temp = nums[i];
                nums[count] = temp;
                count++;
            }
        }
        return count;
    }

    public static int removeDuplicates2(int[] nums) {
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
