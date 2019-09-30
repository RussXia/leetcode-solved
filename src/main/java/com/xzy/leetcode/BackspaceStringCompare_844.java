package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-01-25
 */
public class BackspaceStringCompare_844 {

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        System.out.println(backspaceCompare(S, T));
    }

    public static boolean backspaceCompare(String S, String T) {
        int skipS = 0, skipT = 0;
        for (int i = S.length() - 1, j = T.length() - 1; i >= 0 || j >= 0; ) {
            if (i >= 1 && S.charAt(i) == '#') {
                skipS++;
                i--;
                continue;
            }
            if (skipS != 0) {
                i = i - skipS;
                skipS = 0;
                continue;
            }
            if (j >= 1 && T.charAt(j) == '#') {
                skipT++;
                j--;
                continue;
            }
            if (skipT != 0) {
                j = j - skipT;
                skipT = 0;
                continue;
            }
            if (i < 0 && j > 0 || i > 0 && j < 0) {
                return false;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
