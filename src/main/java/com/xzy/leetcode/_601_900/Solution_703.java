package com.xzy.leetcode._601_900;

import java.util.PriorityQueue;

/**
 * User: RuzzZZ
 * Date: 2023/5/23
 * Time: 10:33
 */
public class Solution_703 {

    class KthLargest {

        private int k;
        private PriorityQueue<Integer> priorityQueue;


        public KthLargest(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<>(k);
            for (int num : nums) {
                this.add(num);
            }
        }

        public int add(int val) {
            priorityQueue.add(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            return priorityQueue.peek();
        }
    }
}
