package com.xzy.leetcode._1_300;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * User: RuzzZZ
 * Date: 2023/5/24
 * Time: 17:26
 */
public class Solution_215 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) heap.poll();
        }
        return heap.stream().mapToInt(Integer::intValue).min().orElse(0);
    }
}
