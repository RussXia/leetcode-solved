package com.xzy.leetcode._1201_2000;

import com.xzy.common.ListNode;

/**
 * User: RuzzZZ
 * Date: 2023/5/15
 * Time: 14:47
 */
public class Solution_1721 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        ListNode third = new ListNode(3);
        second.next = third;

        ListNode node = swapNodes(head, 2);
        ListNode.printNode(node);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        int length = countLength(head);
        ListNode temp = head;
        ListNode pre = null, next = null;
        int index = 1;
        while (temp != null) {
            if (k == index) {
                pre = temp;
            }
            if (length - k + 1 == index) {
                next = temp;
            }
            temp = temp.next;
            index++;
        }
        int tempVal = pre.val;
        pre.val = next.val;
        next.val = tempVal;
        return head;
    }

    private static int countLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
