package com.xzy.leetcode._601_900;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2019-01-31
 */
public class Solution_701 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        TreeNode insertTree = insertIntoBST(treeNode, 5);
        System.out.println(insertTree);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val <= val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
