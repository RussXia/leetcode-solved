package com.xzy.leetcode._1_300;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2021-04-04
 */
public class Solution_32 {

    public static void main(String[] args) {
        String str = "()(()";     //2
//        String str = "(())";      //4
//        String str = "()(())";       //6
//        String str = ")()())";     //4
        System.out.println(longestValidParentheses(str));
    }

    /**
     * 遍历字符串s并入栈其索引，如果入栈元素和栈顶元素可以配对，栈顶元素出栈
     * 这样栈内剩余元素就是无法配对的元素,依次遍历栈元素，取两者差值
     * 如果整个栈为空，说明全部配对，返回字符串长度即可
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (!stack.empty()) {
                    if (s.charAt(stack.peek()) == '(') stack.pop();
                    else stack.push(i);
                } else stack.push(i);
            }
        }
        if (stack.isEmpty()) {
            return n;
        }

        int a = n, b = 0;
        while (!stack.empty()) {
            b = stack.pop();
            longest = Math.max(longest, a - b - 1);
            a = b;
        }
        longest = Math.max(longest, a);

        return longest;
    }
}
