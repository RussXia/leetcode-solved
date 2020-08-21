package com.xzy.leetcode;

import com.alibaba.fastjson.JSON;
import com.xzy.common.ListNode;

/**
 * @author xiazhengyue
 * @since 2019-11-22
 */
public class Solution_19 {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        System.out.println(JSON.toJSONString(removeNthFromEnd(list, 2)));
        ListNode list2 = new ListNode(1);
        System.out.println(JSON.toJSONString(removeNthFromEnd(list2, 1)));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = calcLength(head);
        ListNode result = head;
        int index = length - n;
        int flag = 0;
        ListNode before = null;
        while (flag < index) {
            before = head;
            head = head.next;
            flag++;
        }
        if (before == null) {
            return head.next;
        }
        if (head.next == null) {
            before.next = null;
        } else {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        return result;
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
