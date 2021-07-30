package com.xzy.leetcode._1_300;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double value = findMedianSortedArrays(nums1, nums2);
        System.out.println(value);
        System.out.println("Hello World");
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        list.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        list.sort(Integer::compareTo);
        int mod = list.size() % 2;
        int median = list.size() / 2;
        if (mod == 0) {
            return (list.get(median) + list.get(median - 1)) / 2.0;
        }
        return list.get(median);
    }
}
