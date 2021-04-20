package com.xzy.leetcode._301_600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-04-20
 */
public class Solution_590 {


    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                list.addAll(postorder(child));
            }
        }
        list.add(root.val);
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
