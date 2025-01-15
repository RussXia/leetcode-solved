package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

import java.util.*;

/**
 * @author xiazhengyue
 * @since 2021-03-17
 */
public class Solution_102 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);

        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(levelOrder(treeNode));
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                levelList.add(treeNode.val);
                Optional.ofNullable(treeNode.left).ifPresent(queue::add);
                Optional.ofNullable(treeNode.right).ifPresent(queue::add);
            }
            result.add(levelList);
        }
        return result;
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> levelOrderList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> orderList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                orderList.add(treeNode.val);
                Optional.ofNullable(treeNode.left).ifPresent(queue::add);
                Optional.ofNullable(treeNode.right).ifPresent(queue::add);
            }
            levelOrderList.add(orderList);
        }
        return levelOrderList;
    }

}
