package com.xzy.leetcode;

public class MiddleofLinkedList_876 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;
        head.next.next.next.next = node5;
        System.out.println(middleNode(head).val);

    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        int middle = size / 2;
        int index = 0;
        while (index < middle) {
            head = head.next;
            index++;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
