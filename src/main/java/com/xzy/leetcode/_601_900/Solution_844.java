package com.xzy.leetcode._601_900;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2019-01-25
 */
public class Solution_844 {

    public static void main(String[] args) {
        String S = "abcd";
        String T = "bcd";
        System.out.println(backspaceCompare(S, T));
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!('#' == c)) {
                stackA.push(c);
            } else if (!stackA.isEmpty()) {
                stackA.pop();
            }
        }
        for (char c : T.toCharArray()) {
            if (!('#' == c)) {
                stackB.push(c);
            } else if (!stackB.isEmpty()) {
                stackB.pop();
            }
        }
        if (stackA.size() != stackB.size()) {
            return false;
        }
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.pop() != stackB.pop()) {
                return false;
            }
        }
        return true;
    }
}
