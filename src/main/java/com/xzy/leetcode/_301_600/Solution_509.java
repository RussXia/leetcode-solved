package com.xzy.leetcode._301_600;

/**
 * @author xiazhengyue
 * @since 2021-03-26
 */
public class Solution_509 {

    public static void main(String[] args) {

    }

    /**
     * dp(n) = dp(n-1) + dp(n-2)
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int start = 0, next = 1;
        if (n <= 1) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            int sum = start + next;
            start = next;
            next = sum;
        }
        return next;
    }
}
