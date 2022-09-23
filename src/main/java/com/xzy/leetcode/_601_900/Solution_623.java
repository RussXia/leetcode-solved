package com.xzy.leetcode._601_900;

import com.xzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * User: RuzzZZ
 * Date: 2022/8/5
 * Time: 16:57
 */
public class Solution_623 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        TreeNode result = addOneRow(root, 1, 2);
        System.out.println(result);
    }

    /**
     * bfs/dfs 两种思路都可以
     */
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root.left == null && root.right == null) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        List<TreeNode> array = new ArrayList<>();
        array.add(root);
        for (int i = 1; i < depth; i++) {
            List<TreeNode> subArray = new ArrayList<>();
            array.forEach(treeNode -> {
                if (treeNode.left != null) {
                    subArray.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    subArray.add(treeNode.right);
                }
            });
            array = subArray;
        }
        Optional<TreeNode> subTreeNode = array.stream()
                .filter(treeNode -> treeNode.left != null && treeNode.right != null)
                .findFirst();
        if (subTreeNode.isPresent()) {
            TreeNode treeNode = subTreeNode.get();
            TreeNode left = new TreeNode(val);
            left.left = treeNode.left;
            treeNode.left = left;

            TreeNode right = new TreeNode(val);
            right.right = treeNode.right;
            treeNode.right = right;
        }
        return  root;
    }
}
