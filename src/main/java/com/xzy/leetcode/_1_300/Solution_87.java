package com.xzy.leetcode._1_300;

import java.util.Objects;

/**
 * @author xiazhengyue
 * @since 2021-04-16
 */
public class Solution_87 {

    public static void main(String[] args) {
        String s1 = "eebaacbcbcadaaedceaaacadccd";
        String s2 = "eadcaacabaddaceacbceaabeccd";
        System.out.println(isScramble2(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        if (Objects.equals(s1, s2)) return true;
        if (s1.length() != s2.length()) return false;
        int length = s1.length();
        //校验s1和s2的字母组成是否相同
        int[] alphabet = new int[26];
        for (int i = 0; i < length; i++) {
            alphabet[s1.charAt(i) - 'a']++;
            alphabet[s2.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) return false;
        }
        if (length <= 3) return true;
        //校验是否是反转的
        //如果是反转的，那么 s1的前0-i长的字符串(i在0到n之间)，肯定在 s2的开头或者末尾
        //剩下的，递归计算是否是反转的
        for (int i = 1; i < length; i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                    || (isScramble(s1.substring(0, i), s2.substring(length - i)) && isScramble(s1.substring(i), s2.substring(0, length - i)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isScramble2(String s1, String s2) {
        if (Objects.equals(s1, s2)) return true;
        if (s1.length() != s2.length()) return false;
        int length = s1.length();
        //校验s1和s2的字母组成是否相同
        int[] alphabet = new int[26];
        for (int i = 0; i < length; i++) {
            alphabet[s1.charAt(i) - 'a']++;
            alphabet[s2.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) return false;
        }
        if (length <= 3) return true;

        boolean[][][] dp = new boolean[length][length][length + 1];

        // 初始化单个字符的情况
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }


        // 枚举区间长度 2～n
        for (int len = 2; len <= length; len++) {
            // 枚举 S 中的起点位置
            for (int i = 0; i <= length - len; i++) {
                // 枚举 T 中的起点位置
                for (int j = 0; j <= length - len; j++) {
                    // 枚举划分位置
                    for (int k = 1; k <= len - 1; k++) {
                        // 第一种情况：S1 -> T1, S2 -> T2
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        // 第二种情况：S1 -> T2, S2 -> T1
                        // S1 起点 i，T2 起点 j + 前面那段长度 len-k ，S2 起点 i + 前面长度k
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[length - 1][length - 1][length];

    }
}
