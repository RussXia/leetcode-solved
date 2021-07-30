package com.xzy.leetcode_cn.algorithm_interview;

/**
 * User: RuzzZZ
 * Date: 2021/5/12
 * Time: 19:05
 */
public class LC_1_OnlyOnce {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 2, 1};
        System.out.println(singleNumber(nums));

        System.out.println(Integer.toHexString(2551));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
            result ^= nums[i];
        return result;
    }
}
