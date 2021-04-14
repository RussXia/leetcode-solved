package com.xzy.leetcode._1_300;

import com.xzy.common.ListNode;

/**
 * @author xiazhengyue
 * @since 2021-04-14
 */
public class Solution_86 {

    public static void main(String[] args) {
        Solution_86 solution = new Solution_86();
        {
            ListNode listNode = new ListNode(1);
            listNode.next = new ListNode(4);
            listNode.next.next = new ListNode(3);
            listNode.next.next.next = new ListNode(2);
            listNode.next.next.next.next = new ListNode(5);
            listNode.next.next.next.next.next = new ListNode(2);

            ListNode partition = solution.partition(listNode, 3);
            System.out.println(partition);
        }
        {
            ListNode listNode = new ListNode(2);
            listNode.next = new ListNode(1);

            ListNode partition = solution.partition(listNode, 2);
            System.out.println(partition);
        }

    }

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode pointLess = less;
        ListNode pointMore = more;
        ListNode start = head;
        while (start != null) {
            if (start.val < x) {
                pointLess.next = new ListNode(start.val);
                pointLess = pointLess.next;
            } else {
                pointMore.next = new ListNode(start.val);
                pointMore = pointMore.next;
            }
            start = start.next;
        }
        pointLess.next = more.next;
        return less.next;
    }
}
