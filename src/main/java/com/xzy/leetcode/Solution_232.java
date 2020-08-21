package com.xzy.leetcode;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author xiazhengyue
 * @since 2020-08-20
 */
public class Solution_232 {

    private Stack<Integer> input;

    private Stack<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public Solution_232() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        return output.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }


    public static void main(String[] args) {
        Solution_232 queue = new Solution_232();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        queue.push(4);
        System.out.println(queue.peek());
    }
}
