package com.xzy.leetcode._2001_;

import com.xzy.common.ListNode;

import java.util.Stack;

/**
 * User: RuzzZZ
 * Date: 2023/5/17
 * Time: 10:25
 */
public class Solution_2130 {

    public static void main(String[] args) {

    }

    public int pairSum(ListNode head) {
        int length = calcLength(head);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length / 2; i++) {
            stack.push(head.val);
            head = head.next;
        }
        int sum = -1;
        while (head != null) {
            sum = Math.max(sum, head.val + stack.pop());
            head = head.next;
        }
        return sum;
    }


    private static int calcLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
