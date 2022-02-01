package com.xzy.leetcode._601_900;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * User: RuzzZZ
 * Date: 2022/1/14
 * Time: 16:50
 */
public class Solution_847 {

    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(shortestPathLength(graph));
    }

    static int INF = 0x3f;

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;

        // 初始化所有的 (state, u) 距离为正无穷
        int[][] dist = new int[mask][n];
        for (int i = 0; i < mask; i++) Arrays.fill(dist[i], INF);

        // 因为可以从任意起点出发，先将起始的起点状态入队，并设起点距离为 0
        Deque<int[]> d = new ArrayDeque<>(); // state, u
        for (int i = 0; i < n; i++) {
            dist[1 << i][i] = 0;
            d.addLast(new int[]{1 << i, i});
        }

        // BFS 过程，如果从点 u 能够到达点 i，则更新距离并进行入队
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int state = poll[0], u = poll[1], step = dist[state][u];
            if (state == mask - 1) return step;
            for (int i : graph[u]) {
                if (dist[state | (1 << i)][i] == INF) {
                    dist[state | (1 << i)][i] = step + 1;
                    d.addLast(new int[]{state | (1 << i), i});
                }
            }
        }
        return -1; // never
    }
}
