package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-04-01
 */
public class Solution_114 {
    public static void main(String[] args) {
        Solution_114 solution = new Solution_114();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        solution.flatten(root);
        System.out.println();
    }

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode current = list.get(i);
            prev.left = null;
            prev.right = current;
        }
    }

    private static void preorder(TreeNode root, List<TreeNode> preorderList) {
        if (root == null) {
            return;
        }
        preorderList.add(root);
        preorder(root.left, preorderList);
        preorder(root.right, preorderList);
    }


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode list = new TreeNode(root.val);
        flattenTree(root, list);
        root.left = null;
        root.right = list.right;
    }

    public TreeNode flattenTree(TreeNode root, TreeNode list) {
        list.val = root.val;
        if (root.left != null) {
            list.right = new TreeNode(Integer.MIN_VALUE);
            list = flattenTree(root.left, list.right);
        }
        if (root.right != null) {
            list.right = new TreeNode(Integer.MIN_VALUE);
            list = flattenTree(root.right, list.right);
        }
        return list;
    }

}
