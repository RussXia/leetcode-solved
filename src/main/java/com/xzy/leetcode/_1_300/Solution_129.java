package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_129 {


    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }


    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // 层序遍历
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.add(root);
        numQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nodeQueue.poll();
                Integer element = numQueue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    sum += element;
                }
                if (treeNode.left != null) {
                    nodeQueue.add(treeNode.left);
                    numQueue.add(element * 10 + treeNode.left.val);
                }
                if (treeNode.right != null) {
                    nodeQueue.add(treeNode.right);
                    numQueue.add(element * 10 + treeNode.right.val);
                }
            }
        }
        return sum;
    }


    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }


}
