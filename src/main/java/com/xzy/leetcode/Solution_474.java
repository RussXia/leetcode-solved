package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-04-06
 */
public class Solution_474 {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }

    /**
     * dp[i][j] 表示包含了最少个0和1的i,j（i 就是0的个数，j就是1的个数）dp[i][j]表示字符串的个数
     * <p>
     * 所以，dp[i][j] = max(dp[i-a][j-b] + 1 ,dp[i][j])
     * 其中a是字符串里面0的个数，b是字符串中1的个数
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = count(str);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i - count[0]][j - count[1]] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    private static int[] count(String s) {
        int[] result = new int[2];
        char[] array = s.toCharArray();
        for (int i : array) {
            result[i - '0']++;
        }
        return result;
    }

}
