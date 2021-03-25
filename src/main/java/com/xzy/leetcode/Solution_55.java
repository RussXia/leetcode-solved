package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-03-24
 */
public class Solution_55 {

    public static void main(String[] args) {

        int[] nums = {2,5,1,0,0};
        System.out.println(canJumpGreedy(nums));
    }

    /**
     * greedy
     *
     * @param nums
     * @return
     */
    public static boolean canJumpGreedy(int[] nums) {
        int farest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (farest < i) {
                return false;
            }
            farest = Math.max(i + nums[i], farest);
        }
        return true;
    }


    
}
