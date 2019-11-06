package com.xzy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum_2 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return res;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                int firstIndex = map.get(target - nums[i]);
                res[0] = firstIndex + 1;
                res[1] = i + 1;
                return res;
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return res;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            map.put(target - nums[i], i);
        }
        return res;
    }
}
