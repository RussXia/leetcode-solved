package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-02-19
 */
public class LinkedListCycle142 {

    public static void main(String[] args) {
        ListNode first = new ListNode(0);
        first.next = new ListNode(1);
        ListNode second = first.next;
        second.next = new ListNode(2);
        ListNode third = second.next;
        third.next = new ListNode(3);
        ListNode forth = third.next;
        forth.next = second;

        System.out.println(detectCycle(first).val);
    }

    /**
     * a---b---c---d---e
     * |       |
     * h---g---f
     * 设a-c距离为x1
     * 设相遇点为c-h环中的一点，距离点c距离为x2
     * 相遇点到入环的距离为x3
     * 则slow = x1+x2; faster = x1+(x2+x3)*n + x2
     * 2*slow = faster
     * =>2*(x1+x2) = x1+(x2+x3)*n+x2
     * =>x1=(n-1)(x2+x3)+x3
     * 又因为其中x2+x3是整个环的距离
     * 所以当一个指针在x1的起点处(链表的起点)，另一个在x3的起点处(快慢指针相遇处)
     * 两个指针以相同的步长一起走，两个指针相遇的地方就是环的入口
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode faster = head;
        ListNode slow = head;
        while (faster.next != null && faster.next.next != null) {
            slow = slow.next;
            faster = faster.next.next;
            //两指针相遇，说明有环存在
            if (slow == faster) {
                ListNode detect1 = slow;    //检测指针1放在相遇点
                ListNode detect2 = head;    //检测指针2放在出发点
                while (detect1 != detect2) {
                    detect1 = detect1.next;
                    detect2 = detect2.next;
                }
                return detect1;
            }
        }
        return null;
    }
}
