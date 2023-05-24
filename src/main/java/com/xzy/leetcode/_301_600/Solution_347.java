package com.xzy.leetcode._301_600;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * User: RuzzZZ
 * Date: 2023/5/22
 * Time: 10:28
 */
public class Solution_347 {

    public static void main(String[] args) {
        int nums[] = {4,1,-1,2,-1,2,3};
        int k = 2;
        int[] result = new Solution_347().topKFrequent(nums, k);
        System.out.println(JSON.toJSONString(result));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        countMap.entrySet().forEach(maxHeap::add);
        return maxHeap.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).limit(k).toArray();
    }
}
