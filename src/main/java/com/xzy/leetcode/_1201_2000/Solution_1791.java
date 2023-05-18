package com.xzy.leetcode._1201_2000;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * User: RuzzZZ
 * Date: 2023/5/17
 * Time: 14:52
 */
public class Solution_1791 {

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        Map<Integer, Integer> edgeCount = new HashMap<>();
        for (int[] edge : edges) {
            for (int j = 0; j < edges[0].length; j++) {
                edgeCount.put(edge[j], edgeCount.getOrDefault(edge[j], 0) + 1);
            }
        }
        Optional<Map.Entry<Integer, Integer>> first = edgeCount.entrySet().stream().max(Map.Entry.comparingByValue());
        return first.isPresent() ? first.get().getKey() : 0;

    }
}
