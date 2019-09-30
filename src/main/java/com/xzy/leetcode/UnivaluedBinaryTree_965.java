package com.xzy.leetcode;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2019-01-24
 */
public class UnivaluedBinaryTree_965 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(0);
        treeNode.left.right.right = new TreeNode(0);
        System.out.println(isUnivalTree(treeNode));
    }

    public static boolean isUnivalTree(TreeNode root) {
        if (root.left != null) {
            if (root.val != root.left.val)
                return false;
            if (!isUnivalTree(root.left))
                return false;
        }
        if (root.right != null) {
            if (root.val != root.right.val)
                return false;
            if (!isUnivalTree(root.right))
                return false;
        }
        return true;
    }

}
