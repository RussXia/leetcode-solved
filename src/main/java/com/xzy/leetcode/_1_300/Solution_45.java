package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-03-23
 */
public class Solution_45 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int count = 0;
        for (int i = nums.length - 1; i > 0; ) {
            for (int j = 0; j < i; j++) {
                int len = i - j;
                if (nums[j] >= len) {
                    i = j;
                    break;
                }
            }
            count++;
        }

        return count;
    }
}
