package com.xzy.leetcode._1_300;

import com.xzy.common.ListNode;

/**
 * User: RuzzZZ
 * Date: 2023/5/16
 * Time: 10:39
 */
public class Solution_24 {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            ListNode first = temp;
            ListNode second = temp.next;
            int tempVal = first.val;;
            first.val = second.val;
            second.val = tempVal;
            temp = second.next;
        }
        return head;
    }
}
