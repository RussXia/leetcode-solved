package com.xzy.leetcode._601_900;

import com.xzy.common.ListNode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xiazhengyue
 * @since 2019-01-23
 */
public class Solution_817 {

    public static void main(String[] args) {

    }

    public static int numComponents(ListNode head, int[] nums) {
        if (head == null) {
            return 0;
        }
        //Map<Integer, Boolean> map = Arrays.stream(nums).boxed().collect(Collectors.toMap(Function.identity(), value -> true));
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int count = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                count++;
            }
            head = head.next;
        }
        return count;
    }
}
