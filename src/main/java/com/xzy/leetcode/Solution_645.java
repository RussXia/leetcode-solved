package com.xzy.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author xiazhengyue
 * @since 2021-04-08
 */
public class Solution_645 {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 5};
        System.out.println(JSON.toJSON(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - 1]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                result[0] = i + 1;
            }
            if (count[i] == 0) {
                result[1] = i + 1;
            }
        }
        return result;
    }
}
