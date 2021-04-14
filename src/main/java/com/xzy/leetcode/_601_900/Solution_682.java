package com.xzy.leetcode._601_900;

import com.xzy.common.AssertUtils;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2020-08-24
 */
public class Solution_682 {

    public static void main(String[] args) {
        String[] ops1 = {"5", "2", "C", "D", "+"};
        AssertUtils.isTrue(calPoints(ops1) == 30);

        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        AssertUtils.isTrue(calPoints(ops2) == 27);
    }


    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                stack.pop();
            } else if ("D".equals(op)) {
                stack.push(stack.peek() * 2);
            } else if ("+".equals(op)) {
                Integer pop = stack.pop();
                Integer peek = stack.peek();
                stack.push(pop);
                stack.push(pop + peek);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
