package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2020-08-20
 */
public class Solution_155 {

    private Node head;

    /**
     * initialize your data structure here.
     */
    public Solution_155() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, null, x);
        } else {
            head = new Node(x, head, Math.min(x, head.minimum));
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.minimum;
    }

    private class Node {
        private int value;

        private Node next;

        private int minimum;


        Node(int value, Node next, int minimum) {
            this.value = value;
            this.next = next;
            this.minimum = minimum;
        }
    }

    public static void main(String[] args) {
        Solution_155 minStack = new Solution_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
