package com.xzy.leetcode._1_300;

import com.xzy.common.ListNode;

/**
 * User: RuzzZZ
 * Date: 2023/5/24
 * Time: 17:37
 */
public class Solution_148 {
    /**
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 找到中点，断开链接
        ListNode middle = findMiddle(head);
        ListNode midNext = middle.next;
        middle.next = null;
        // 分段排序
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        // merge
        return merge(left, right);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                current.next = node2;
                node2 = node2.next;
            } else {
                current.next = node1;
                node1 = node1.next;
            }
            current = current.next;
        }
        if (node1 != null) {
            current.next = node1;
        }
        if (node2 != null) {
            current.next = node2;
        }
        return dummy.next;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
