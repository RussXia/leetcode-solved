package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-01-24
 */
public class InvertBinaryTree226 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.left.right.right = new TreeNode(4);
        System.out.println(invertTree(treeNode));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }
}
