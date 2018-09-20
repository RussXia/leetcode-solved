package com.xzy.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers1 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);

        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3.val + "" + l3.next.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode currentNode = null;
        ListNode temp;
        boolean carryBit = false;   //进位标记
        while (l1 != null && l2 != null) {
            int result = carryBit ? l1.val + l2.val + 1 : l1.val + l2.val;
            if (result >= 10) {
                carryBit = true;
                result = result % 10;
            } else {
                carryBit = false;
            }
            temp = new ListNode(result);
            if (res == null) {
                res = temp;
                currentNode = res;
            } else {
                currentNode.next = temp;
                currentNode = currentNode.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            complementListNode(l2, currentNode, carryBit);
        } else if (l2 == null && l1 != null) {
            complementListNode(l1, currentNode, carryBit);
        } else {
            if (carryBit) {
                currentNode.next = new ListNode(1);
            }
        }
        return res;
    }

    private static void complementListNode(ListNode l, ListNode currentNode, boolean carryBit) {
        while (l != null) {
            if (carryBit) {
                l.val = l.val + 1;
            }
            if (l.val >= 10) {
                currentNode.next = new ListNode(l.val % 10);
                currentNode = currentNode.next;
                currentNode.next = new ListNode(1);
            } else {
                currentNode.next = l;
                currentNode = currentNode.next;
                carryBit = false;
            }
            l = l.next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
