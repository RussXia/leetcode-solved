package com.xzy.leetcode;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2020-08-20
 */
public class Solution_20 {

    public static void main(String[] args) {
        System.out.println(isValid("([)"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char next : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(next);
                continue;
            }
            Character pre = stack.peek();
            if (match(pre, next)) {
                stack.pop();
                continue;
            }
            stack.push(next);
        }
        return stack.isEmpty();
    }

    public static boolean match(char pre, char next) {
        if (pre == '(' && next == ')') {
            return true;
        }
        if (pre == '[' && next == ']') {
            return true;
        }
        if (pre == '{' && next == '}') {
            return true;
        }
        return false;
    }
}
