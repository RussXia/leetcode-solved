package com.xzy.leetcode;

import com.alibaba.fastjson.JSON;
import com.xzy.common.ListNode;

/**
 * @author xiazhengyue
 * @since 2020-07-23
 */
public class Solution_83 {


    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(4);

        ListNode newList = deleteDuplicates(list);
        System.out.println(JSON.toJSONString(newList));
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;

        while (pre != null && next != null) {
            if (pre.val == next.val) {
                //删除节点
                pre.next = next.next;
                next = next.next;
                continue;
            }
            pre = next;
            next = next.next;
        }
        return head;
    }
}
