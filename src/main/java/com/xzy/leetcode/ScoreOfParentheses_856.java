package com.xzy.leetcode;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2019-01-23
 */
public class ScoreOfParentheses_856 {

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()))"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses("()"));
    }

    public static int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty() || aChar == '(') {
                stack.push(Character.toString(aChar));
            } else {
                adjustStack(stack, Character.toString(aChar));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static void adjustStack(Stack<String> stack, String pushValue) {
        if (stack.isEmpty()) {
            stack.push(pushValue);
            return;
        }
        String firstElement = stack.pop();
        if (firstElement.equals("(") && !pushValue.equals(")")) {
            stack.push(firstElement);
            stack.push(pushValue);
            return;
        }
        //如果栈顶是个数字
        if (!firstElement.equals("(")) {
            //入栈的也是个数字
            if (!pushValue.equals(")")) {
                int temp = Integer.parseInt(firstElement) + Integer.parseInt(pushValue);
                adjustStack(stack, Integer.toString(temp));
            } else {
                int temp = Integer.parseInt(firstElement);
                temp = temp * 2;
                stack.pop();
                adjustStack(stack, Integer.toString(temp));
            }
        } else {
            adjustStack(stack, "1");
        }
    }
}
