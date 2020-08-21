package com.xzy.leetcode;

import com.alibaba.fastjson.JSON;
import com.xzy.common.ListNode;

import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2019-11-22
 */
public class Solution_206 {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(3);
        list.next.next = new ListNode(5);
        list.next.next.next = new ListNode(7);
        list.next.next.next.next = new ListNode(9);
        System.out.println(JSON.toJSONString(reverseList2(list)));
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode result = new ListNode(stack.pop());
        head = result;
        while (!stack.empty()) {
            head.next = new ListNode(stack.pop());
            head = head.next;
        }
        return result;
    }

    public static ListNode reverseList2(ListNode head) {
       ListNode before = null;
       ListNode curr = head;
       while(curr != null) {
           ListNode temp = curr.next;
           curr.next = before;
           before = curr;
           curr = temp;
       }
       return before;
    }

}
