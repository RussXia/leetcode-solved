package com.xzy.leetcode._1_300;

import com.alibaba.fastjson.JSON;
import com.xzy.common.ListNode;

/**
 * @author xiazhengyue
 * @since 2020-07-28
 */
public class Solution_82 {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
//        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(3);
//        list.next.next.next.next = new ListNode(4);
//        list.next.next.next.next.next = new ListNode(4);
//        list.next.next.next.next.next.next = new ListNode(5);

        ListNode newList = deleteDuplicates(list);
        System.out.println(JSON.toJSONString(newList));
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        //标记节点的前置指针
        ListNode startPoint = pre.next;
        //两个标记指针
        ListNode endPoint = startPoint;
        while (endPoint != null) {
            //处理链表头即重复的
            if (pre.val == startPoint.val) {
                startPoint = startPoint.next;
                endPoint = startPoint;
                continue;
            }

            if (pre.next != startPoint) {
                head = startPoint;
                pre = head;
                startPoint = pre.next;
                endPoint = startPoint;
                continue;
            }
            //处理在非链表头位置重复的
            if (endPoint.val == startPoint.val) {
                endPoint = endPoint.next;
            } else if (startPoint.next == endPoint) {
                //jump one
                pre = startPoint;
                startPoint = pre.next;
                endPoint = startPoint;
            } else {
                pre.next = endPoint;
                startPoint = endPoint;
            }
        }
        //处理一开始就重复
        if (pre.next != startPoint && startPoint == null) {
            return null;
        }
        //处理结尾重复的
        if (startPoint != null && startPoint.next != endPoint) {
            pre.next = null;
        }
        return head;
    }
}
