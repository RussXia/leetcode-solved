package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-04-21
 */
public class Solution_91 {

    public static void main(String[] args) {
        Solution_91 solution = new Solution_91();
//        System.out.println(solution.numDecodings("12"));
//        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("2101"));

        //2 1 2 1
        // 2 12 1
        // 21 2 1
        // 21 21
        // 2 1 21
    }

    /**
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= chars.length; i++) {
            if (chars[i - 1] == '0') {
                if (chars[i - 2] == '2' || chars[i - 2] == '1') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (chars[i - 2] > '2' || (chars[i - 2] == '2' && chars[i - 1] > '6') || chars[i - 2] == '0') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }
        return dp[chars.length];
    }
}
