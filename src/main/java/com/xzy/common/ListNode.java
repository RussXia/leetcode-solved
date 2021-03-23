package com.xzy.common;

/**
 * @author xiazhengyue
 * @since 2019-01-23
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        for (int i = 0; i < 3; i++) {
            node.next = new ListNode(i + 2);
            node = node.next;
        }
        System.out.println(head);
    }

}
