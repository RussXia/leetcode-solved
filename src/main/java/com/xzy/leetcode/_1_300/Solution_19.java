package com.xzy.leetcode._1_300;

import com.alibaba.fastjson.JSON;
import com.xzy.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

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
        System.out.println(JSON.toJSONString(removeNthFromEnd3(list, 2)));
        ListNode list2 = new ListNode(1);
        //list2.next = new ListNode(2);
        //list2.next.next = new ListNode(3);
        System.out.println(JSON.toJSONString(removeNthFromEnd3(list2, 1)));
    }


    /**
     * two pointer
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0, head);
        //two pointer
        ListNode fast = head;
        ListNode slow = fakeHead;
        //fast fist move n-1 step
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        //both move fast and slow
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //remove node after slow
        slow.next = slow.next.next;
        return fakeHead.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp = head;
        Deque<ListNode> deque = new LinkedList<>();
        int length = 0;
        while (head != null) {
            length++;
            if (deque.size() == (n + 1)) {
                deque.removeFirst();
            }
            deque.add(head);
            head = head.next;
        }
        ListNode preNode = deque.removeFirst();
        //删除头节点
        if (length == n) {
            return temp.next;
        }
        if (!deque.isEmpty()) {
            ListNode removeElement = deque.removeFirst();
            preNode.next = removeElement.next;
        }
        return temp;
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
