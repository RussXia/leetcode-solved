package com.xzy.leetcode._1_300;

import com.alibaba.fastjson.JSONObject;

public class Solution_21 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        {
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(2);
            ListNode l3 = new ListNode(4);
            l1.next = l2;
            l2.next = l3;

            ListNode r1 = new ListNode(1);
            ListNode r2 = new ListNode(3);
            ListNode r3 = new ListNode(4);
            r1.next = r2;
            r2.next = r3;

            ListNode result = mergeTwoLists2(l1, r1);
            System.out.println(JSONObject.toJSONString(result));
        }

        {
            ListNode l1 = new ListNode(1);
            ListNode r1 = new ListNode(1);
            ListNode result = mergeTwoLists2(l1, r1);
            System.out.println(JSONObject.toJSONString(result));
        }

    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode merged = l1.val <= l2.val ? l1 : l2;
        ListNode result = merged;
        ListNode insert = l1.val <= l2.val ? l2 : l1;
        while (merged != null && insert != null) {
            if (isMergedAble(merged, merged.next, insert)) {
                ListNode temp = merged.next;
                merged.next = new ListNode(insert.val);
                merged.next.next = temp;
                insert = insert.next;
            }
            merged = merged.next;
        }
        return result;
    }

    public static boolean isMergedAble(ListNode left, ListNode right, ListNode value) {
        if (right == null) {
            return left.val <= value.val;
        }
        return left.val <= value.val && right.val >= value.val;
    }


    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
