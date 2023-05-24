package com.xzy.leetcode._2001_;

import java.util.*;

/**
 * User: RuzzZZ
 * Date: 2023/5/24
 * Time: 11:00
 */
public class Solution_2542 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;
        Solution_2542 solution2542 = new Solution_2542();
        System.out.println(solution2542.maxScore(nums1, nums2, k));
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        long sum = 0;
        long max = 0L;
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < pairs.length; i++) {
            queue.add(pairs[i][0]);
            sum += pairs[i][0];
            if (queue.size() > k) sum -= queue.poll();
            if (queue.size() == k) {
                max = Math.max(sum * pairs[i][1], max);
            }
        }
        return max;
    }

    /**
     * 生成元素这段，修改成回溯法试一试？
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long maxScore1(int[] nums1, int[] nums2, int k) {
        long max = 0L;
        int n = nums1.length;
        // maxHeap 用来存放nums1的元素
        List<Integer> maxHeap = new ArrayList<>(k);
        // minHeap 用户存放nums2的元素
        List<Integer> minHeap = new ArrayList<>(k);
        int[] combinationIndices = new int[k];

        // init
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums1[i]);
            minHeap.add(nums2[i]);
            combinationIndices[i] = i;
        }
        max = Math.max(max, calc(maxHeap, minHeap));
        // 遍历nums1中的k元素组合,放入maxHeap和minHeap中
        while (true) {
            int i = k - 1;

            // Find the rightmost element that has not reached its maximum value
            while (i >= 0 && combinationIndices[i] == n - k + i) {
                i--;
            }

            if (i < 0) {
                // All elements have reached their maximum values, exit the loop
                break;
            }

            // Increment the rightmost element that has not reached its maximum value
            combinationIndices[i]++;

            // Update the values of the subsequent elements
            for (int j = i + 1; j < k; j++) {
                combinationIndices[j] = combinationIndices[j - 1] + 1;
            }

            // Update the combination based on the new indices
            maxHeap.clear();
            minHeap.clear();
            for (int index : combinationIndices) {
                maxHeap.add(nums1[index]);
                minHeap.add(nums2[index]);
            }

            // Process the new combination
            max = Math.max(max, calc(maxHeap, minHeap));
        }
        // (两个heap固定长度为k,如果超了，从maxHeap中移除的元素，按A[index]从minHeap中移除)


        return max;
    }


    private long calc(List<Integer> maxHeap, List<Integer> minHeap) {
        int sum = maxHeap.stream().mapToInt(Integer::intValue).sum();
        int min = minHeap.stream().mapToInt(Integer::intValue).min().orElse(0);
        return (long) sum * min;
    }
}
