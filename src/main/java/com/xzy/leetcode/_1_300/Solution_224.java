package com.xzy.leetcode._1_300;

import com.xzy.common.AssertUtils;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2020-08-21
 */
public class Solution_224 {

    public static void main(String[] args) {
        AssertUtils.isTrue(3 == calculate2("2-(5-6)"));
        AssertUtils.isTrue(2 == calculate2("1 + 1"));
        AssertUtils.isTrue(3 == calculate2("2-1 + 2 "));
        AssertUtils.isTrue(23 == calculate2("(1+(4+5+2)-3)+(6+8)"));
        AssertUtils.isTrue(11 == calculate2("(7)-(0)+(4)"));
    }

    public static int calculate(String s) {
        Stack<Integer> number = new Stack<>();
        Stack<Character> operation = new Stack<>();
        int len = s.length();
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                while (i + 1 <= len && Character.isDigit(s.charAt(i))) {
                    temp = temp * 10 + s.charAt(i) - '0';
                    i++;
                }
                number.push(temp);
                if (!operation.isEmpty() && (operation.peek() == '+' || operation.peek() == '-')) {
                    calc(number, operation);
                }
                i--;
                temp = 0;
            } else if (isOperation(s.charAt(i))) {
                if (s.charAt(i) == '(') {
                    operation.push(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    while (operation.peek() != '(') {
                        calc(number, operation);
                    }
                    operation.pop();
                    if (!operation.isEmpty() && (operation.peek() == '+' || operation.peek() == '-')) {
                        calc(number, operation);
                    }
                } else {
                    operation.push(s.charAt(i));
                }
            }
        }
        while (!operation.isEmpty()) {
            calc(number, operation);
        }
        return number.pop();
    }

    private static void calc(Stack<Integer> number, Stack<Character> operation) {
        char operator = operation.pop();    //取出前面的操作符号
        int next = number.pop();
        int pre = number.pop();
        if (operator == '+') {
            number.push(pre + next);
        } else {
            number.push(pre - next);
        }
    }

    public static boolean isOperation(char c) {
        if (c == '(' || c == '+' || c == '-' || c == ')') {
            return true;
        }
        return false;
    }


    /**
     * leetcode上的优化版本
     *
     * @param s
     * @return
     */
    public static int calculate2(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }
}
