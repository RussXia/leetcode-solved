package com.xzy.leetcode._1201_2000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * User: RuzzZZ
 * Date: 2023/5/24
 * Time: 15:26
 */
public class Solution_1383 {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = speed[i];
            pairs[i][1] = efficiency[i];
        }
        // sort pairs by efficiency,
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        Queue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        long sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            queue.add(pairs[i][0]);
            sum += pairs[i][0];
            if (queue.size() > k) sum -= queue.poll();
            if (queue.size() <= k) max = Math.max(sum * pairs[i][1], max);
        }
        return (int) (max % 1000000007L);
    }
}
