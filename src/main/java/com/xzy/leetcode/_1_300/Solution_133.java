package com.xzy.leetcode._1_300;

import java.util.*;

/**
 * User: RuzzZZ
 * Date: 2023/5/17
 * Time: 11:02
 */
public class Solution_133 {

    public static void main(String[] args) {
        String str = "dsaasfsaf";
        System.out.println(str.getBytes().length);
        System.out.println(str.length());
    }

    public Node clone(Node node) {
        if (node == null) return null;
        // bfs 遍历整个图
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        // 用map来记录已克隆的node
        Map<Node, Node> clonedMap = new HashMap<>();
        clonedMap.put(node, new Node(node.val));
        while (!que.isEmpty()) {
            Node poll = que.poll();
            for (Node neighbor : poll.neighbors) {
                if (!clonedMap.containsKey(neighbor)) {
                    clonedMap.put(neighbor, new Node(neighbor.val));
                    que.add(neighbor);
                }
                // copy the neighbor
                clonedMap.get(poll).neighbors.add(clonedMap.get(neighbor));
            }
        }
        return clonedMap.get(node);
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
