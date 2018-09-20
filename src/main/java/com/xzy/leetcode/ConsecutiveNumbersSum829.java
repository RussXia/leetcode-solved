package com.xzy.leetcode;

public class ConsecutiveNumbersSum829 {

    /**
     * Submission Detail
     154 / 170 test cases passed.
     Status: Time Limit Exceeded
     */
    public static void main(String[] args) {
//        System.out.println(consecutiveNumbersSum(5));
//        System.out.println(consecutiveNumbersSum(9));
//        System.out.println(consecutiveNumbersSum(15));
//        System.out.println(consecutiveNumbersSum(101));
//        System.out.println(consecutiveNumbersSum(2));
//        System.out.println(consecutiveNumbersSum(1));
//        System.out.println(consecutiveNumbersSum(3));
        System.out.println(consecutiveNumbersSum(855204));

//        System.out.println(checkResult(855204, 1, 855204));
//        System.out.println(checkResult(285067, 3, 855204));
//        System.out.println(checkResult(122169, 7, 855204));
//        System.out.println(checkResult(106897, 8, 855204));
//        System.out.println(checkResult(40714, 21, 855204));
//        System.out.println(checkResult(35622, 24, 855204));
//        System.out.println(checkResult(15244, 56, 855204));
//        System.out.println(checkResult(5007, 168, 855204));
//        System.out.println(checkResult(8640, 105208, 855204));
//        System.out.println(checkResult(917, 363976, 855204));
    }

    public static int consecutiveNumbersSum(int N) {
        if (N == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= N / 2 + 1; i++) {
            long t1 = 2L * N - i * (i - 1L);
            if (t1 <= 0) {
                continue;
            }
            long t2 = 2L * i;
            if (t1 % t2 == 0) {
                System.out.println(t1 / t2 + "----" + i);
                count++;
            }
        }
        return count;
    }

    public static boolean checkResult(int a1, int n, int result) {
        return result == (a1 * n + (n - 1) * n / 2);
    }
}
