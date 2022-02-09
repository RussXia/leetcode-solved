package com.xzy.leetcode._2001_;

import java.util.HashMap;
import java.util.Map;

/**
 * User: RuzzZZ
 * Date: 2022/2/9
 * Time: 14:41
 */
public class Solution_2006 {

    /**
     * 差的绝对值为 K 的数对数目
     *
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //add frequency
            Integer value = dict.getOrDefault(nums[i], 0);
            dict.put(nums[i], value + 1);
            //count
            count += dict.getOrDefault(nums[i] - k, 0);
            count += dict.getOrDefault(nums[i] + k, 0);
        }
        return count;
    }
}
