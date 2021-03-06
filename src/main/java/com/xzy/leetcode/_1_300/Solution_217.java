package com.xzy.leetcode._1_300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xiazhengyue
 * @since 2019-11-01
 */
public class Solution_217 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = dict.put(nums[i], i);
            if (index != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(nums).anyMatch(num -> !seen.add(num));
    }
}
