package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-03-26
 */
public class Solution_70 {

    public static void main(String[] args) {

    }

    /**
     * f(n) = f(n-1)+f(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int pre = 1, next = 2, result = 0;
        for (int i = 1; i <= n - 2; i++) {
            result = pre + next;
            pre = next;
            next = result;
        }
        return result;
    }
}
