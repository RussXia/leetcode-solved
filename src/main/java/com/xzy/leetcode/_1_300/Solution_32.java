package com.xzy.leetcode._1_300;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2021-04-04
 */
public class Solution_32 {

    public static void main(String[] args) {
        String str = "(";
        System.out.println(longestValidParentheses(str));
    }

    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int countL = 0;
        for (int i = 0; i < chars.length; i++) {
            //start
            if (stack.isEmpty()) {
                if (chars[i] == '(') {
                    countL++;
                    stack.push(chars[i]);
                }
                continue;
            }


            if (chars[i] == '(') {
                if (stack.peek() == '(') {
                    stack.push(chars[i]);
                    countL += 2;
                } else {
                    stack.push(chars[i]);
                    countL++;
                }
            }
            if (stack.peek() == chars[i]) {
                int count = chars[i] == '(' ? 1 : 0;
                max = Math.max(max, stack.size() - count);
                stack.clear();
                stack.push(chars[i]);
                continue;
            }
            stack.push(chars[i]);
        }
        return (!stack.isEmpty()) && (stack.peek() == '(') ?
                Math.max(max, stack.size() - 1) :
                Math.max(max, stack.size());
    }
}
