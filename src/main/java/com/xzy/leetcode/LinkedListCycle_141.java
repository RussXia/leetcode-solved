package com.xzy.leetcode;

import com.xzy.common.ListNode;

/**
 * @author xiazhengyue
 * @since 2019-02-19
 */
public class LinkedListCycle_141 {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(1);
        ListNode second = first.next;
        second.next = new ListNode(1);
        ListNode third = second.next;
        third.next = new ListNode(1);
        ListNode forth = third.next;
        forth.next = second;

        System.out.println(hasCycle(first));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode faster = head;
        ListNode slow = head;
        while (faster.next != null && faster.next.next != null) {
            slow = slow.next;
            faster = faster.next.next;
            if (slow == faster) {
                return true;
            }
        }
        return false;
    }
}
