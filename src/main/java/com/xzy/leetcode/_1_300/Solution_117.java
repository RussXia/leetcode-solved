package com.xzy.leetcode._1_300;

import com.xzy.common.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiazhengyue
 * @since 2021-04-01
 */
public class Solution_117 {

    public static void main(String[] args) {
        Solution_117 solution117 = new Solution_117();

        {
            Node root = new Node(1);
            root.left = new Node(2);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            root.right = new Node(3);
            root.right.right = new Node(7);
            Node connect = solution117.connect(root);
            System.out.println(connect);
        }

    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node next = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.pollFirst();
                node.next = next;
                next = node;
                if (next.right != null) {
                    queue.offer(next.right);
                }
                if (next.left != null) {
                    queue.offer(next.left);
                }
            }
        }
        return root;
    }

}
