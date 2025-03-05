package com.xzy.interview;

import java.util.PriorityQueue;

public class LeetCode_215 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(new LeetCode_215().findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() != k) {
                queue.add(nums[i]);
            } else if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.poll();
    }
}
