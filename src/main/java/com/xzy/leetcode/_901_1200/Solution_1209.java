package com.xzy.leetcode._901_1200;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2021-04-17
 */
public class Solution_1209 {

    public static void main(String[] args) {
        Solution_1209 solution = new Solution_1209();
        System.out.println(solution.removeDuplicates("deeedbbcccbdaa", 2));
    }

    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) stack.peek().count++;
            else stack.push(new Node(c, 1));
            //满足k个元素，pop出去
            if (stack.peek().count == k) stack.pop();

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (int i = 0; i < pop.count; i++) {
                sb.append(pop.c);
            }
        }
        return sb.reverse().toString();
    }

    class Node {
        char c;
        int count;

        Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

}
