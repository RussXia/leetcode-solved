package com.xzy.leetcode._301_600;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiazhengyue
 * @since 2021-04-20
 */
public class Solution_429 {

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> list = new ArrayList<>();
        {
            Node node_3 = new Node(3);
            Node node_5 = new Node(5);
            Node node_6 = new Node(6);
            node_3.children = Arrays.asList(node_5, node_6);

            list.add(node_3);
        }
        {
            Node node_2 = new Node(2);
            list.add(node_2);
        }
        {
            Node node_4 = new Node(4);
            list.add(node_4);
        }
        root.children = list;

        System.out.println(JSON.toJSON(levelOrder(root)));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        //初始化根节点
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelElements = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node pop = queue.poll();
                levelElements.add(pop.val);
                //将子节点保存到栈中，供下一次遍历
                if (pop.children != null && !pop.children.isEmpty()) {
                    for (int j = 0; j < pop.children.size(); j++) {
                        queue.offer(pop.children.get(j));
                    }
                }
            }
            result.add(levelElements);
        }
        return result;
    }

    static class Node {
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
    }

    ;
}
