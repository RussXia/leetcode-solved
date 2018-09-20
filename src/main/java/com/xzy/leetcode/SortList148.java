package com.xzy.leetcode;

public class SortList148 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        sorted(head);
        return head;
    }

    public void sorted(ListNode temp) {
        if (temp == null || temp.next == null) {
            return ;
        }
        // TODO: 2018/8/25 排序
        
        sorted(temp);
    }
}
