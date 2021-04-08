package com.xzy.leetcode;

import com.xzy.common.ListNode;

/**
 * @author xiazhengyue
 * @since 2021-04-02
 */
public class Solution_234 {

    public static void main(String[] args) {
        Solution_234 solution_234 = new Solution_234();

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);


        System.out.println(solution_234.isPalindrome(node));
    }

    /**
     * 双指针找中点，反转后半部分链表，然后逐个比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //双指针找中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //奇数个节点，跳过中间的节点
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分的链表
        ListNode tail = reverse(slow);

        //从头部和slow这个中点部分遍历比较
        while (tail != null) {
            if (tail.val != head.val) {
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

}
