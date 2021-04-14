package com.xzy.leetcode._301_600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author xiazhengyue
 * @since 2019-11-01
 */
public class Solution_350 {

    public static void main(String[] args) {
//        int[] nums1 = {4, 9, 5};
//        int[] nums2 = {9, 4, 9, 8, 4};

//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};

        int[] nums1 = {1, 2};
        int[] nums2 = {1, 1};

//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2};
        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> nums2List = IntStream.of(nums2).boxed().collect(Collectors.toList());
        return IntStream.of(nums1).filter(value -> nums2List.remove(Integer.valueOf(value))).toArray();
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        int[] smallArr = nums1.length < nums2.length ? nums1 : nums2;
        int[] bigArr = nums1.length >= nums2.length ? nums1 : nums2;
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i : smallArr) {
            Integer count = dict.getOrDefault(i, 0);
            dict.put(i, count + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i : bigArr) {
            if (dict.containsKey(i) && dict.getOrDefault(i, 0) > 0) {
                result.add(i);
                dict.put(i, dict.get(i) - 1);
            }
        }
        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
        }

        return r;
    }
}
