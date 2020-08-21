package com.xzy.leetcode;

import java.util.Arrays;

/**
 * @description: https://leetcode.com/problems/plus-one/description/
 * @author: xzy
 * @create: 2018-09-18 16:12
 **/
public class Solution_66 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
//        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 8, 9, 9})));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int result = digits[i] + 1;
            if (result < 10) {
                digits[i] = result;
                return digits;
            }
            digits[i] = result - 10;
            if (i == 0) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                return newDigits;
            }
        }
        return digits;
    }
}
