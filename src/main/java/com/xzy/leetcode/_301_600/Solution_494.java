package com.xzy.leetcode._301_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_494 {

    public static void main(String[] args) {
//        int[] nums = {6, 44, 30, 25, 8, 26, 34, 22, 10, 18, 34, 8, 0, 32, 13, 48, 29, 41, 16, 30};
//        int S = 12;

//        int[] nums = {1};
//        int S = 2;

        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        int S = 1;

//        int[] nums = {1, 1, 1, 1, 1};
//        int S = 3;
        System.out.println(findTargetSumWays2(nums, S));
    }

    /**
     * Time Limit Exceeded
     * @param nums
     * @param S
     * @return
     */
    public static int findTargetSumWays(int[] nums, int S) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int num : nums) {
            list = count(num, list);
        }
        Map<Integer, Long> countResult = list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        return countResult.get(S) == null ? 0 : countResult.get(S).intValue();
    }

    public static List<Integer> count(int num, List<Integer> list) {
        List<Integer> tempResult = new ArrayList<>();
        list.forEach(sum -> {
            tempResult.add(sum + num);
            tempResult.add(sum - num);
        });
        return tempResult;
    }

    /**
     *
     139 / 139 test cases passed.
     Status: Accepted
     Runtime: 92 ms
     Submitted: 0 minutes ago
     * @param nums
     * @param S
     * @return
     */
    public static int findTargetSumWays2(int[] nums, int S) {
        Map<Integer, Integer>/* Map<sum,count> */ result = new HashMap<>();
        for (int num : nums) {
            result = count2(num, result);
        }
        return result.get(S) == null ? 0 : result.get(S);
    }

    public static Map<Integer, Integer> count2(int num, Map<Integer, Integer> map) {
        if (map.keySet().size() == 0) {
            if (num == 0) {
                map.put(num, 2);
            } else {
                map.put(num, 1);
                map.put(-num, 1);
            }
            return map;
        }
        Map<Integer, Integer> result = new HashMap<>();
        map.forEach((k, v) -> {
            if (result.get(k + num) == null) {
                result.put(k + num, v);
            } else {
                int countTimes = result.get(k + num);
                result.put(k + num, countTimes + v);
            }
            if (result.get(k - num) == null) {
                result.put(k - num, v);
            } else {
                int countTimes = result.get(k - num);
                result.put(k - num, countTimes + v);
            }
        });
        return result;
    }
}
