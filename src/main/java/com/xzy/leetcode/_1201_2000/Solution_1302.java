package com.xzy.leetcode._1201_2000;

import com.xzy.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiazhengyue
 * @since 2021-04-12
 */
public class Solution_1302 {

    public static void main(String[] args) {

    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            sum = 0;
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.pollFirst();
                sum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return sum;
    }
}
