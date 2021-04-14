package com.xzy.leetcode._301_600;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2020-08-24
 */
public class Solution_496 {


    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(JSON.toJSONString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int result = -1;
            int index = -1;
            for (int j = 0; j < nums2.length; j++) {
                //找到nums1[i]在nums2中的位置
                if (nums2[j] == nums1[i]) {
                    index = j;
                }
                //如果已经找到nums2中位置，且找到了一个next greater element
                if (index != -1 && nums2[j] > nums2[index]) {
                    result = nums2[j];
                    break;
                }
            }
            results[i] = result;
        }
        return results;
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                dict.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = dict.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
