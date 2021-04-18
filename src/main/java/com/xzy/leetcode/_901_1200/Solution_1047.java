package com.xzy.leetcode._901_1200;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2021-04-18
 */
public class Solution_1047 {
    public static void main(String[] args) {
        String str = "abbacaa";
        System.out.println(removeDuplicates2(str));
    }

    /**
     * stack
     *
     * @param S
     * @return
     */
    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.toCharArray().length; i++) {
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(S.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    /**
     * two point
     *
     * @param
     * @return
     */
    public static String removeDuplicates2(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[j]) {
                i = i - 2;
            }
        }
        return new String(res, 0, i);
    }
}
