package com.xzy.leetcode._301_600;

/**
 * @author xiazhengyue
 * @since 2019-11-22
 */
public class Solution_479 {

    public static void main(String[] args) {
        System.out.println(largestPalindrome(8));
    }

    public static int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int) Math.pow(10, n) - 1;
        for (int v = max - 1; v > max / 10; v--) {
            long u = Long.valueOf(v + new StringBuilder().append(v).reverse().toString());
            for (long x = max; x * x >= u; x--)
                if (u % x == 0)
                    return (int) (u % 1337);
        }
        return 0;
    }
}
