package com.xzy.leetcode._301_600;

/**
 * @author xiazhengyue
 * @since 2021-03-26
 */
public class Solution_392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaaa",
                "bbaaaa"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int j = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        boolean flag = false;
        for (int i = 0; i < sChars.length && j < tChars.length; i++) {
            while (j < tChars.length) {
                if (sChars[i] == tChars[j]) {
                    j++;
                    if (i == (sChars.length - 1)) {
                        flag = true;
                    }
                    break;
                }
                j++;
            }

        }
        return flag;
    }
}
