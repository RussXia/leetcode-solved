package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-03-26
 */
public class Solution_1137 {

    public static void main(String[] args) {

    }

    public int tribonacci(int n) {
        int first = 0, second = 1, third = 1;
        if (n <= 1) {
            return n;
        }

        for (int i = 3; i <= n; i++) {
            int sum = first + second + third;
            first = second;
            second = third;
            third = sum;
        }
        return third;
    }
}
