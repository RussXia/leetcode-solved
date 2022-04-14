package com.xzy.leetcode._301_600;

/**
 * User: RuzzZZ
 * Date: 2022/2/22
 * Time: 16:21
 */
public class Solution_342 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("i:" + i + "-" + isPowerOfFour2(i));
        }
    }

    public static boolean isPowerOfFour2(int n) {
        if (n <= 0) {
            return false;
        }
        if ((n & 3) != 0) {
            return n == 1;
        }
        if (n == 1) {
            return true;
        }
        return isPowerOfFour2(n >> 2);
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        //被4整除
        while ((n >= 4) && (n & 3) == 0) {
            n = n >> 2;
        }
        return n == 1;
    }
}
