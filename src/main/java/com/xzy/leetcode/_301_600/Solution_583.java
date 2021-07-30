package com.xzy.leetcode._301_600;

public class Solution_583 {

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";

        System.out.println(minDistance(word1, word2));

    }


    /**
     * if(word1[i] == word2[j]
     * ----dp[i][j]  =  dp[i-1][j-1]
     * else
     * ----dp[i][j] = Math.min(dp[i-1][j-1]+2,dp[i-1][j]+1,dp[i][j-1]+1)
     * return dp[i][j]
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            dp[i][0] = i + 1;
        }
        for (int j = 0; j < len2; j++) {
            dp[0][j] = j + 1;
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
