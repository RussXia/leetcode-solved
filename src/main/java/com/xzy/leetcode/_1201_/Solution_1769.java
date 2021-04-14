package com.xzy.leetcode._1201_;

import com.alibaba.fastjson.JSON;

/**
 * @author xiazhengyue
 * @since 2021-03-29
 */
public class Solution_1769 {

    public static void main(String[] args) {
        String boxes = "001011";
        System.out.println(JSON.toJSON(minOperations(boxes)));
    }

    public static int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        int index = 0;
        while (index < boxes.length()) {
            if (boxes.charAt(index) == '1') {
                for (int i = 0; i < result.length; i++) {
                    result[i] += Math.abs(index - i);
                }
            }
            index++;
        }
        return result;
    }
}
