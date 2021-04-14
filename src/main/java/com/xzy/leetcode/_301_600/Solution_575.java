package com.xzy.leetcode._301_600;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiazhengyue
 * @since 2021-04-08
 */
public class Solution_575 {
    public static void main(String[] args) {
        int[] nums = {6, 6, 6, 6};
        System.out.println(distributeCandies(nums));
    }

    public static int distributeCandies(int[] candyType) {
        int limit = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
            if (set.size() >= limit) {
                return limit;
            }
        }
        return set.size();
    }
}
