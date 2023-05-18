package com.xzy.leetcode._1201_2000;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: RuzzZZ
 * Date: 2023/5/18
 * Time: 10:36
 */
public class Solution_1557 {

    public static void main(String[] args) {


        List<List<Integer>> edge = Lists.newArrayList(
                Lists.newArrayList(1, 2),
                Lists.newArrayList(3, 2),
                Lists.newArrayList(1, 3),
                Lists.newArrayList(1, 0),
                Lists.newArrayList(0, 2),
                Lists.newArrayList(0, 2)
        );
        int n = 4;
        Solution_1557 solution1557 = new Solution_1557();
        System.out.println(solution1557.findSmallestSetOfVertices(n, edge));
    }

    public List<Integer> findSmallestSetOfVertices2(int n, List<List<Integer>> edges) {
        List<Integer> reachFroms = new ArrayList<>();
        boolean[] reachTo = new boolean[n];
        for (List<Integer> edge : edges) {
            Integer to = edge.get(1);
            reachTo[to] = true;
        }
        for (int i = 0; i < reachTo.length; i++) {
            if (!reachTo[i]) reachFroms.add(i);
        }
        return reachFroms;
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> reachFroms = new ArrayList<>();
        Set<Integer> reachTos = new HashSet<>();
        for (List<Integer> edge : edges) {
            Integer from = edge.get(0);
            Integer to = edge.get(1);
            reachTos.add(to);
            if (!reachTos.contains(from) && !reachFroms.contains(from)) reachFroms.add(from);
            if (reachTos.contains(to)) reachFroms.remove(to);
            // 如果已遍历完
            if (reachFroms.size() + reachTos.size() == n && reachFroms.size() == 1) {
                return reachFroms;
            }
        }
        return reachFroms;
    }
}
